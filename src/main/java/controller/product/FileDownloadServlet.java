package controller.product;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * �̹��� �ҷ����� 
 * @since 2024.04.04
 * @author nsr
 */
@WebServlet("/FileDownloadServlet")
public class FileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FileDownloadServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	}
	
	/** doHandle() ������ �ؾ��� �ϵ�
	1. request.getOutputStream() �� �̿��Ͽ� OutputStream ��ü
	2. �迭�� ���� ����
	3. while() �� �̿��Ͽ� ���Ϸκ��� �����͸� �ѹ��� ?byte��ŭ �б�
	4. OutputStream�� write()�� �������� ���
	
	1. �Ű�����request�� ���۵� ���� �̸� ����
	2. response���� OutputStream ��ü
	3. ������ �ٿ�ε�
	4. ���۸� �̿��Ͽ� ���Ͽ��� ���۷� �����͸� �о� �ѹ��� ���...
 
 **/

protected void doHandle(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html;charset=utf-8");
	
	String file_repo="c:\\file_repo";
	
	String fileName = (String)request.getParameter("fileName");
	System.out.println("==> fileName : " + fileName);
	
	//2. 
	OutputStream out = response.getOutputStream();
	
	String downFile = file_repo + "\\" + fileName;
	File f = new File(downFile);
	
	//3. �� �������� ĳ�ø� ��Ȱ��ȭ
	response.setHeader("Cache-Control", "no-Cache");
	/**
	 * Content-disposition : ����� ����Ͽ� ���������� ������ ��� ó�� �� ��...
	 * attachment : ����ó���� �ٿ�ε��.. ��, �����̸��� �ʿ�.
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
