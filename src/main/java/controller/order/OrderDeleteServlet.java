package controller.order;

import java.io.IOException;
/**
 * �ֹ� �� ��ȸ ���� Ŭ����
 * 
 */
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDAO;
import dto.OrderDTO;

@WebServlet("/order/OrderDeleteServlet")
public class OrderDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/** ORDER DAO */
	private OrderDAO orderDAO = null;

	public OrderDeleteServlet() {
		super();
		this.orderDAO = new OrderDAO();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// �ֹ� ��ȣ ��������
		int no = Integer.parseInt(request.getParameter("no"));

		// ��
	    OrderDTO orderDTO = new OrderDTO();
	    orderDTO.setNo(no);

	    // �ֹ� ����
	    
	    boolean complete = this.orderDAO.deleteOrder(no);
	    
	    
	    // �ֹ� ���� �� ��� �������� �̵�
	    response.sendRedirect(request.getContextPath() + "/admin/orderMgr.jsp");
	}
}
