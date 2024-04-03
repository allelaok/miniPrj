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

@WebServlet("/product/ProductDetailServlet")
public class ProductDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private ProductDAO productDAO = null;
    public ProductDetailServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		// 게시물 상세 조회
		ProductDTO productDTO = new ProductDTO();
		this.productDAO = new ProductDAO();
		productDTO = this.productDAO.productDetail(no);
		
		// View 사용될 객체 설정
		request.setAttribute("productDTO", productDTO);
		
		// View 보내기
		RequestDispatcher requestDispatcher =
			request.getRequestDispatcher("/productDetail.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	}

}
