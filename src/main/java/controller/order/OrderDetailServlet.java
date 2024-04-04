package controller.order;

/**
 * 주문 상세 페이지
 * @since 2024.04.04
 * @author cyb
 */
import java.io.IOException;

/**
 * 주문 상세 조회 서블릿 클래스
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
	 * GET 접근 시 (상세보기 접근 시)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 파라미터
		int no = Integer.parseInt(request.getParameter("no"));
		

		// 모델
		OrderDTO orderDTO = this.orderDAO.orderDetail(no);
		if(orderDTO !=null) {
			// 제품 번호를 사용하여 제품 정보를 가져옴
			ProductDTO productDTO = this.orderDAO.getProduct(orderDTO.getProductno());
            request.setAttribute("orderDTO", orderDTO);
            request.setAttribute("productDTO", productDTO);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/orderDetail.jsp");
            dispatcher.forward(request, response);
        } else {
            // 주문이 존재하지 않는 경우에 대한 처리
            response.sendRedirect(request.getContextPath() + "/admin/orderDetail.jsp?error=notfound");
        
		}
		
		
		
				
		// 주문 상세 조회
		this.orderDAO = new OrderDAO();
		orderDTO = this.orderDAO.orderDetail(no);

		// View 보내기
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admin/orderDetail.jsp");
		requestDispatcher.forward(request, response);

	}

	/**
	 * POST 접근 시 (주문상태 수정 시)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// POST 요청 한글 파라미터 인코딩 처리
		request.setCharacterEncoding("UTF-8");

		// 파라미터 가져오기
		String no = request.getParameter("no");
		String state = request.getParameter("state");

		// 모델
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setNo(Integer.parseInt(no));
		orderDTO.setState(state);

		// 주문 상태 수정
		this.orderDAO = new OrderDAO();
		this.orderDAO.updateOrder(orderDTO);

		// 주문 상세 조회 페이지로 리다이렉트
		response.sendRedirect(request.getContextPath() + "/order/OrderDetailServlet?no=" + no);
		
	}

}
