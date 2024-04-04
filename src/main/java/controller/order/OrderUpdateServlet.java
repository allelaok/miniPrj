package controller.order;

/**
 * �ֹ� ���� ������ ���� Ŭ����(admin)
 * @since 2024.04.04
 * @author cyb
 */
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDAO;
import dto.OrderDTO;

@WebServlet("/order/OrderUpdateServlet")
public class OrderUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/** ORDER DAO */
	private OrderDAO orderDAO = null;

	public OrderUpdateServlet() {
		super();
	}

	/** GET ���ٽ� (�ֹ� ���� ���� ��) */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ��
		OrderDTO orderDTO = new OrderDTO();
		int n = Integer.parseInt(request.getParameter("no"));
		orderDTO.setNo(n);
		
		// �ֹ� �� ��ȸ
		orderDAO = new OrderDAO();
		OrderDTO orderOne = orderDAO.orderDetail(n);

		request.setAttribute("orderDAO", orderOne);
		
		RequestDispatcher rd=request.getRequestDispatcher("orderMgr.jsp");
		rd.forward(request, response);

	}
	/** POST ���ٽ� (�ֹ� ���� ó�� ���� ��) */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// POST �ѱ� �Ķ���� ���� ó��
		request.setCharacterEncoding("UTF-8");
		
		// �Ķ����
		int n=Integer.parseInt(request.getParameter("num"));
	    String state = request.getParameter("state");
		
		// ��
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setNo(n);
		orderDTO.setState(state);

		// DAO ȣ���Ͽ� ����
		orderDAO = new OrderDAO();
		orderDAO.updateOrder(orderDTO);
		
		// ���� �� �ֹ� �� ����Ʈ ������ �̵�
		response.sendRedirect(request.getContextPath() + "/admin/orderMgr.jsp");
		   
		
	}

}
