package controller.product;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

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
			pageName = "productDetail.jsp";
		RequestDispatcher requestDispatcher =
			request.getRequestDispatcher(pageName);
		requestDispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String file_repo="C:\\github\\miniPrj\\images";
		
		String fileName = (String)request.getParameter("fileName");
		System.out.println("==> fileName : " + fileName);
		
		//2. 
		OutputStream out = response.getOutputStream();
		
		String downFile = file_repo + "\\" + fileName;
		File f = new File(downFile);
		
		//3. 웹 브라우저의 캐시를 비활성화
		response.setHeader("Cache-Control", "no-Cache");
		/**
		 * Content-disposition : 헤더를 사용하여 브라우저에게 파일을 어떻게 처리 할 지...
		 * attachment : 파일처리를 다운로드로.. 단, 파일이름이 필요.
		 */
		response.addHeader("Content-disposition", "attachment; fileName=" + fileName);
		
		FileInputStream in = new FileInputStream(f);
		
		// 4.
		byte[] buffer = new byte[1024*8];
		while(true) {
			int count = in.read(buffer);
			if(count == -1) {
				break;
			}
			out.write(buffer, 0, count);
		}
		in.close();
		out.close();
		
	} // doHandle()


}
