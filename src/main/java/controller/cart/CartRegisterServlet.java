package controller.cart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartDAO;
import dto.CartDTO;

@WebServlet("/cart/CartRegisterServlet")
public class CartRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CartRegisterServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
        int productno = Integer.parseInt(request.getParameter("productno"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String id = request.getParameter("id");

        CartDTO cartDTO = new CartDTO(no, productno, quantity, id);
        CartDAO cartDAO = new CartDAO();
        cartDAO.insertCart(cartDTO);

        response.sendRedirect("/cartList.jsp");
	}

}
