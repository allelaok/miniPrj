package controller.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import dto.ListDTO;
import dto.ProductDTO;
import utils.pageNavigator;

/**
 * ��ǰ ��� ������ ���� Ŭ����
 * @since 2024.04.04
 * @author nsr
 */
@WebServlet("/ProductListServlet")
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 /** BOARD DAO */
	private ProductDAO productdDAO = null;
   
    public ProductListServlet() {
        super();
    }

	/**
	 * GET ���� �� (��� ��ȸ ���� ��)
	 * 1. ��û�� ������ �� (��������ȣ)
	 * 3. ������ ��ȣ�� Ŭ������ ��
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// ���޵� �Ķ���͸� �̿��Ͽ� �� ����(ó������ ���޵Ǵ� ���� ����)
		String pageNum = request.getParameter("pageNum"); // ������ ��ȣ
		int countPerPage = 3;
		if(pageNum == null) {
			pageNum = "1";
			System.out.println("PAGENUM NULL");
		}
		
		// DAO (DB�� ���̺� �����Ͽ� ������ ������ �� �ִ� �޼��� ���� ��ü ����)
		this.productdDAO = new ProductDAO();
		// �Խù� �� �� (��� �Ʒ��� ������ ��ȣ�� ����ϱ� ���� �޼��� ȣ��)
		int totalCount = this.productdDAO.selectCount();
		
		// �Խù� ����� ��� ���� ���� (������� ArrayList <BoardModel> �� ��ȯ ����)
		List<ProductDTO> productArray = this.productdDAO.productList(Integer.parseInt(pageNum), countPerPage);
		
		// View ���� ��ü ����
		request.setAttribute("totalCount", totalCount);
		
		// ��� �ϴ� ������ ��ȣ����� ���� ��ü ����
		pageNavigator pNavigator=new pageNavigator();
		
		String p_navi=pNavigator.getPageNavigator(totalCount,countPerPage,10, Integer.parseInt(pageNum));
		
		request.setAttribute("pageNavigator", p_navi);	// ������ ��ȣ��
		request.setAttribute("productArray" , productArray);	// ��ȸ ��� ����Ʈ
		
		
		// View ������
		String pageName = "";
		boolean admin = true;
		if(admin)
			pageName = "admin/productMgr.jsp";
		else
			pageName = "/productList.jsp";
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(pageName);
		requestDispatcher.forward(request, response);
		System.out.println("�̵�");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	}

}
