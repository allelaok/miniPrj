package controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;

/**
 * �α׾ƿ� controller
 *  @author ���ֿ�
 */
@WebServlet("/member/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberDAO memberDAO = null;
     
    public LogoutServlet() {
        super();
    } // ������ END

    /** GET ��û: �α׾ƿ� ��û ���� **/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage = "/index.jsp";
		
		 HttpSession session = request.getSession(false);
	        if (session != null) {
	            session.invalidate();
	        }
		
		// �α׾ƿ� ������ �� index.jsp��
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(nextPage);
		requestDispatcher.forward(request, response);
	} // GET() END

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	} // POST() END

}
