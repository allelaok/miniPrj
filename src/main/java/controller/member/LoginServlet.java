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
 * �α��� controller
 * @author ���ֿ�
 * **/
@WebServlet("/member/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberDAO memberDAO = null;
       
    public LoginServlet() {
        super();
    } // ������ END

    /** GET ��û ����(�α��� �������� �̵�) **/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// view ������
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.jsp");
		requestDispatcher.forward(request, response);
	} // GET() END

	/** POST ��û ����(�α��� ���� ����) **/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage = "/index.jsp";
		boolean status = false;
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		memberDAO = new MemberDAO();
		status = memberDAO.login(id, pwd);
		
		// �α��� ���� ��, ���ǿ� ���� ����
		if (status) {
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
		} else {
			nextPage = "/logError.jsp?mod=0";
		}
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(nextPage);
		requestDispatcher.forward(request, response);
	} // POST() END

}
