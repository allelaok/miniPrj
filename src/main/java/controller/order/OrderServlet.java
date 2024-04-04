package controller.order;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDAO;
import dto.OrderDTO;

@WebServlet("/order/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/** ORDER DAO */
	private OrderDAO orderDAO = null;

	public OrderServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 파라미터
		String no = request.getParameter("no");
		String productno = request.getParameter("productno");
		String quantity = request.getParameter("quantity");
		String date = request.getParameter("date");
		String state = request.getParameter("state");
		String id = request.getParameter("id");

		// 모델
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setNo(Integer.parseInt(no));
		orderDTO.setProductno(Integer.parseInt(productno));
		orderDTO.setQuantity(Integer.parseInt(quantity));
		orderDTO.setDate(date);
		orderDTO.setState(state);
		orderDTO.setId(id);

		// 주문하기
		this.orderDAO = new OrderDAO();
		this.orderDAO.insertOrder(orderDTO);

		// 주문 내역 리스트 페이지 이동
	    RequestDispatcher requestDispatcher = request.getRequestDispatcher("OrderListServlet");
        requestDispatcher.forward(request, response);
	}

}
