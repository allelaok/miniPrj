package controller.cart;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartDAO;
import dto.CartDTO;


@WebServlet("/cart/CartListServlet")
public class CartListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       	
    public CartListServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CartDAO cartDAO = new CartDAO();
        List<CartDTO> cartList = cartDAO.listMembers();
        System.out.println(cartList.size());
        request.setAttribute("cartList", cartList);
        request.getRequestDispatcher("/cartList.jsp").forward(request, response);
	}

}
