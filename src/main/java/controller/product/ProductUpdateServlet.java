package controller.product;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dao.ProductDAO;
import dto.ProductDTO;

/**
 * 상품 수정 페이지 서블릿 클래스
 * @since 2024.04.04
 * @author nsr
 */
@WebServlet("/ProductUpdateServlet")
public class ProductUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProductDAO productDAO = null;
    
    public ProductUpdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("productno"));
		
		this.productDAO = new ProductDAO();
		ProductDTO productDTO = new ProductDTO();
		productDTO = this.productDAO.productDetail(no);
		
		request.setAttribute("product", productDTO);

		RequestDispatcher requestDispatcher =
			request.getRequestDispatcher("admin/productUpdate.jsp");
		requestDispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String no = request.getParameter("no");
		
		System.out.println("===> " + no);
		
		String name = request.getParameter("pname");
		String price = request.getParameter("pprice");
		if(price == "" || price==null)
			price = "0";
		
		System.out.println("price  ===> " + price);
		String contents = request.getParameter("pcontents");
		String count = request.getParameter("pcount");
		if(count == "" || count == null)
			count = "0";
		
		String image = doHandle(request, response);
		
		ProductDTO product = new ProductDTO();
		product.setNo(Integer.parseInt(no));
		product.setDetail(contents);
		product.setImage(image);
		product.setName(name);
		product.setPrice(Integer.parseInt(price));
		product.setStock(Integer.parseInt(count));
		
		productDAO = new ProductDAO();
		boolean complete = productDAO.updateProduct(product);
		
		
//		System.out.println("====> " + complete);
		
		
		request.setAttribute("bool", complete);	
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin/productUpdate.jsp");
		if(requestDispatcher != null) {
		    requestDispatcher.forward(request, response);
		} else {
		    System.out.println("RequestDispatcher is null");
		}
	}
	

	private String doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fileName = "";
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
						System.out.println("업로드할 데이터 추출 시작");
						
						FileItem fileitem = (FileItem)items.get(i);
						
						/** FileItem.isFormField() : boolean
						 * FileItem오브젝트에 저장되어 있는 값이 파일데이터인지
						 * 그외의 <form> 데이터인지 판단
						 * 그 밖의 <form> 데이터의 경우는 true을 반환하고,
						 * 파일데이터의 경우는 false을 반환				 	
						 **/				
						if(fileitem.isFormField()) {
							System.out.println("==> " +  fileitem.getFieldName() + " " + fileitem.getString("utf-8"));
						}else {
							System.out.println("==> 매개변수명 : " + fileitem.getFieldName());
							System.out.println("==> 파일명 : " + fileitem.getName());
							System.out.println("==> 파일의 크기 : " + fileitem.getSize() + "byte");
							
							if(fileitem.getSize() > 0) {
								System.out.println("==> 파일 이름 : " + fileitem.getName());
								int idx = fileitem.getName().lastIndexOf("\\");
								System.out.println("==> \\의 index 번호 : " + idx);
								
								if(idx == -1) {
								 	idx = fileitem.getName().lastIndexOf("/");
								 	System.out.println("==> /의 index 번호 : " + idx);
								} // if(idx == -1){} END
								fileName = fileitem.getName().substring(idx + 1);
								System.out.println("==> 파일 이름 : " + fileitem.getName().substring(idx + 1));
								
								System.out.print("==> 저장될 파일 : " + currentPath + "\\" + fileName);						
								File uploadFile = new File(currentPath + "\\" + fileName);
								fileitem.write(uploadFile);
								
							} // if(fileitem.getSize() > 0){} END
						} // if(fileitem.isFormField()){} else{} END
					}
					
				} catch (Exception e) {
					System.err.println("FILE UPLOAD FAIL!!!");
				}

        return fileName;

	} // doHandle()

}
