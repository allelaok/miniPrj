package controller.product;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import dto.ProductDTO;
/**
 * 상품 상세 페이지 서블릿 클래스
 * @since 2024.04.04
 * @author nsr
 */
@WebServlet("/ProductDetailServlet")
public class ProductDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private ProductDAO productDAO = null;
    public ProductDetailServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		
		int no = Integer.parseInt(request.getParameter("productno"));
		
		ProductDTO productDTO = new ProductDTO();
		this.productDAO = new ProductDAO();
		productDTO = this.productDAO.productDetail(no);
		
		request.setAttribute("product", productDTO);
		String pageName = "";
		boolean admin = true;
		if(admin)
			pageName = "admin/productDetail.jsp";
		else
			pageName = "/productDetail.jsp";
		RequestDispatcher requestDispatcher =
			request.getRequestDispatcher(pageName);
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	}

}
