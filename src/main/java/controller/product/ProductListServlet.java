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
 * 상품 목록 페이지 서블릿 클래스
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
	 * GET 접근 시 (목록 조회 접근 시)
	 * 1. 요청이 들어왔을 때 (페이지번호)
	 * 3. 페이지 번호를 클릭했을 때
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// 전달된 파라미터를 이용하여 값 추출(처음에는 전달되는 값이 없음)
		String pageNum = request.getParameter("pageNum"); // 페이지 번호
		int countPerPage = 3;
		if(pageNum == null) {
			pageNum = "1";
			System.out.println("PAGENUM NULL");
		}
		
		// DAO (DB의 테이블에 접속하여 쿼리를 실행할 수 있는 메서드 보유 객체 생성)
		this.productdDAO = new ProductDAO();
		// 게시물 총 수 (목록 아래에 페이지 번호를 계산하기 위한 메서드 호출)
		int totalCount = this.productdDAO.selectCount();
		
		// 게시물 목록을 얻는 쿼리 실행 (결과값을 ArrayList <BoardModel> 로 반환 받음)
		List<ProductDTO> productArray = this.productdDAO.productList(Integer.parseInt(pageNum), countPerPage);
		
		// View 사용될 객체 설정
		request.setAttribute("totalCount", totalCount);
		
		// 목록 하단 페이지 번호출력을 위한 객체 생성
		pageNavigator pNavigator=new pageNavigator();
		
		String p_navi=pNavigator.getPageNavigator(totalCount,countPerPage,10, Integer.parseInt(pageNum));
		
		request.setAttribute("pageNavigator", p_navi);	// 페이지 번호들
		request.setAttribute("productArray" , productArray);	// 조회 결과 리스트
		
		
		// View 보내기
		String pageName = "";
		boolean admin = true;
		if(admin)
			pageName = "admin/productMgr.jsp";
		else
			pageName = "/productList.jsp";
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(pageName);
		requestDispatcher.forward(request, response);
		System.out.println("이동");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	}

}
