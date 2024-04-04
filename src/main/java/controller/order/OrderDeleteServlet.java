package controller.order;

import java.io.IOException;
/**
 * 주문 상세 조회 서블릿 클래스
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
		// 주문 번호 가져오기
		int no = Integer.parseInt(request.getParameter("no"));

		// 모델
	    OrderDTO orderDTO = new OrderDTO();
	    orderDTO.setNo(no);

	    // 주문 삭제
	    
	    boolean complete = this.orderDAO.deleteOrder(no);
	    
	    
	    // 주문 삭제 후 목록 페이지로 이동
	    response.sendRedirect(request.getContextPath() + "/admin/orderMgr.jsp");
	}
}
