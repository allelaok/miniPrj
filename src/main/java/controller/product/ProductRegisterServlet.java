package controller.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import dto.ProductDTO;

/**
 * 상품 등록 페이지 서블릿 클래스
 * @since 2024.04.04
 * @author nsr
 */
@WebServlet("/ProductRegisterServlet")
public class ProductRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 /** BOARD DAO */
	private ProductDAO productdDAO = null;
    public ProductRegisterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String name = request.getParameter("pname");
		String price = request.getParameter("pprice");
		String contents = request.getParameter("pcontents");
		String count = request.getParameter("pcount");
		String image = request.getParameter("image");
		
		
		ProductDTO product = new ProductDTO();
		product.setDetail(contents);
		product.setImage(image);
		product.setName(name);
		product.setPrice(Integer.parseInt(price));
		product.setStock(count);
		
		productdDAO = new ProductDAO();
		boolean complete = productdDAO.insertProduct(product);
		
		
		
		
		
	}

}
