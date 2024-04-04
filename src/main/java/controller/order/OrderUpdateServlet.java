package controller.order;

/**
 * 주문 수정 페이지 서블릿 클래스(admin)
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

	/** GET 접근시 (주문 수정 접근 시) */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 모델
		OrderDTO orderDTO = new OrderDTO();
		int n = Integer.parseInt(request.getParameter("no"));
		orderDTO.setNo(n);
		
		// 주문 상세 조회
		orderDAO = new OrderDAO();
		OrderDTO orderOne = orderDAO.orderDetail(n);

		request.setAttribute("orderDAO", orderOne);
		
		RequestDispatcher rd=request.getRequestDispatcher("orderMgr.jsp");
		rd.forward(request, response);

	}
	/** POST 접근시 (주문 수정 처리 접근 시) */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// POST 한글 파라미터 깨짐 처리
		request.setCharacterEncoding("UTF-8");
		
		// 파라미터
		int n=Integer.parseInt(request.getParameter("num"));
	    String state = request.getParameter("state");
		
		// 모델
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setNo(n);
		orderDTO.setState(state);

		// DAO 호출하여 수정
		orderDAO = new OrderDAO();
		orderDAO.updateOrder(orderDTO);
		
		// 수정 후 주문 후 리스트 페이지 이동
		response.sendRedirect(request.getContextPath() + "/admin/orderMgr.jsp");
		   
		
	}

}
