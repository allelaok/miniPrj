package controller.order;

/**
 * �ֹ� �� ������
 * @since 2024.04.04
 * @author cyb
 */
import java.io.IOException;

/**
 * �ֹ� �� ��ȸ ���� Ŭ����
 * @since 2024.04.04
 * @author cyb
 */

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDAO;
import dto.OrderDTO;
import dto.ProductDTO;

@WebServlet("/order/OrderDetailServlet")
public class OrderDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/** ORDER DAO */
	private OrderDAO orderDAO = null;

	public OrderDetailServlet() {
		super();
		this.orderDAO = new OrderDAO();
	}

	/**
	 * GET ���� �� (�󼼺��� ���� ��)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// �Ķ����
		int no = Integer.parseInt(request.getParameter("no"));
		

		// ��
		OrderDTO orderDTO = this.orderDAO.orderDetail(no);
		if(orderDTO !=null) {
			// ��ǰ ��ȣ�� ����Ͽ� ��ǰ ������ ������
			ProductDTO productDTO = this.orderDAO.getProduct(orderDTO.getProductno());
            request.setAttribute("orderDTO", orderDTO);
            request.setAttribute("productDTO", productDTO);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/orderDetail.jsp");
            dispatcher.forward(request, response);
        } else {
            // �ֹ��� �������� �ʴ� ��쿡 ���� ó��
            response.sendRedirect(request.getContextPath() + "/admin/orderDetail.jsp?error=notfound");
        
		}
		
		
		
				
		// �ֹ� �� ��ȸ
		this.orderDAO = new OrderDAO();
		orderDTO = this.orderDAO.orderDetail(no);

		// View ������
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admin/orderDetail.jsp");
		requestDispatcher.forward(request, response);

	}

	/**
	 * POST ���� �� (�ֹ����� ���� ��)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// POST ��û �ѱ� �Ķ���� ���ڵ� ó��
		request.setCharacterEncoding("UTF-8");

		// �Ķ���� ��������
		String no = request.getParameter("no");
		String state = request.getParameter("state");

		// ��
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setNo(Integer.parseInt(no));
		orderDTO.setState(state);

		// �ֹ� ���� ����
		this.orderDAO = new OrderDAO();
		this.orderDAO.updateOrder(orderDTO);

		// �ֹ� �� ��ȸ �������� �����̷�Ʈ
		response.sendRedirect(request.getContextPath() + "/order/OrderDetailServlet?no=" + no);
		
	}

}
