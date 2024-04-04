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
 * ��ǰ ��� ������ ���� Ŭ����
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
		
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("pname");
		String price = request.getParameter("pprice");
		if(price == "" || price == null)
			price = "0";
		
		String contents = request.getParameter("pcontents");
		String count = request.getParameter("pcount");
		if(count == ""|| count == null)
			count = "0";
		
		String image = doHandle(request, response);
		
		ProductDTO product = new ProductDTO();
		product.setDetail(contents);
		product.setImage(image);
		product.setName(name);
		product.setPrice(Integer.parseInt(price));
		product.setStock(Integer.parseInt(count));
		
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
	
	private String doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fileName = "";
		// �ѱۃ��� ����
				request.setCharacterEncoding("utf-8");

				// ���� ��ü
				File currentPath = new File("c:/github/miniPrj/images");

				// ���� ���ε带 ���� ���� ��ü
				DiskFileItemFactory factory = new DiskFileItemFactory();
				factory.setRepository(currentPath);
				factory.setSizeThreshold(1024 * 1024);

				// ���� ���� ���ε� ��ü
				ServletFileUpload upload = new ServletFileUpload(factory);

				// �ܺ� �ڿ� �ٷ��
				try {
					List items = upload.parseRequest(request);
					
					for(int i = 0; i < items.size(); i++) {
						System.out.println("���ε��� ������ ���� ����");
						
						FileItem fileitem = (FileItem)items.get(i);
						
						/** FileItem.isFormField() : boolean
						 * FileItem������Ʈ�� ����Ǿ� �ִ� ���� ���ϵ���������
						 * �׿��� <form> ���������� �Ǵ�
						 * �� ���� <form> �������� ���� true�� ��ȯ�ϰ�,
						 * ���ϵ������� ���� false�� ��ȯ				 	
						 **/				
						if(fileitem.isFormField()) {
							System.out.println("==> " +  fileitem.getFieldName() + " " + fileitem.getString("utf-8"));
						}else {
							System.out.println("==> �Ű������� : " + fileitem.getFieldName());
							System.out.println("==> ���ϸ� : " + fileitem.getName());
							System.out.println("==> ������ ũ�� : " + fileitem.getSize() + "byte");
							
							if(fileitem.getSize() > 0) {
								System.out.println("==> ���� �̸� : " + fileitem.getName());
								int idx = fileitem.getName().lastIndexOf("\\");
								System.out.println("==> \\�� index ��ȣ : " + idx);
								
								if(idx == -1) {
								 	idx = fileitem.getName().lastIndexOf("/");
								 	System.out.println("==> /�� index ��ȣ : " + idx);
								} // if(idx == -1){} END
								fileName = fileitem.getName().substring(idx + 1);
								System.out.println("==> ���� �̸� : " + fileitem.getName().substring(idx + 1));
								
								System.out.print("==> ����� ���� : " + currentPath + "\\" + fileName);						
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
