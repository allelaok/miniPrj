package controller.product;

import javax.servlet.http.Part;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import java.util.List;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
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
		
		ProductDTO product = doHandle(request, response);
		
		productdDAO = new ProductDAO();
		boolean complete = productdDAO.insertProduct(product);
		
		request.setAttribute("bool", complete);	
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin/productInsert.jsp");
		if(requestDispatcher != null) {
		    requestDispatcher.forward(request, response);
		} else {
		    System.out.println("RequestDispatcher is null");
		}
		
	}
	
	private ProductDTO doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductDTO product = new ProductDTO();
		// 한글꺠짐 방지
		request.setCharacterEncoding("utf-8");

		// 파일 객체
		File currentPath = new File("c:/github/miniPrj/images");

		// 파일 업로드를 위한 설정 객체
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(currentPath);
		factory.setSizeThreshold(1024 * 1024);

		// 서블릿 파일 업로드 객체
		ServletFileUpload upload = new ServletFileUpload(factory);

		// 외부 자원 다루기
		try {
			List items = upload.parseRequest(request);
			
			for(int i = 0; i < items.size(); i++) {
				FileItem fileitem = (FileItem)items.get(i);
				// 파일이 아닌 나머지
				if(fileitem.isFormField()) {
					if("no".equals(fileitem.getFieldName())) {
						
						product.setNo(Integer.parseInt(fileitem.getString("utf-8")));
					}
					else if("pname".equals(fileitem.getFieldName())) {	
						product.setName(fileitem.getString("utf-8"));
					}
					else  if("pprice".equals(fileitem.getFieldName())) {
						product.setPrice(Integer.parseInt(fileitem.getString("utf-8")));
					}
					else  if("pcontents".equals(fileitem.getFieldName())) {
						product.setDetail(fileitem.getString("utf-8"));
					}
					else  if("pcount".equals(fileitem.getFieldName())) {
						product.setStock(Integer.parseInt(fileitem.getString("utf-8")));
					}
				}
				// 파일인 경우
				else if(fileitem.getSize() > 0) {
					int idx = fileitem.getName().lastIndexOf("\\");
					if(idx == -1) {
						idx = fileitem.getName().lastIndexOf("/");
					}							
					
					String fileName = fileitem.getName().substring(idx + 1);
					product.setImage(fileName);
					System.out.println("==> 저장될 파일 : " + currentPath + "\\" + fileName);						
					File uploadFile = new File(currentPath + "\\" + fileName);
					fileitem.write(uploadFile);
				}
			}
			
		} catch (Exception e) {
			System.err.println("FILE UPLOAD FAIL!!!");
		}	

        return product;

	} // doHandle()
	
}
