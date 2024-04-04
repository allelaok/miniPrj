package controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminDAO;

/**
 * ������(admin) �α��� controller
 * @author ���ֿ�
 */
@WebServlet("/admin/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AdminDAO adminDAO = null;
    
    public AdminLoginServlet() {
        super();
    } // ������ END

	/**
	 * GET ��û ����(������ �α��� �������� �̵�)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// view ������
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admin/login.jsp");
		requestDispatcher.forward(request, response);
	} // GET() END

	/**
	 * POST ��û ����(������ �α���)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage = "/admin/index.jsp";
		boolean status = false;
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		adminDAO = new AdminDAO();
		status = adminDAO.adminLogin(id, pwd);
		
		// �α��� ���� ��, ���ǿ� ���� ����
		if (status) {
			HttpSession session = request.getSession();
			session.setAttribute("adminId", id);
			session.setAttribute("isAdmin", true);
		} else {
			nextPage = "/logError.jsp?mod=0";
		}
		
		// ������ �� admin/index.jsp��
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(nextPage);
		requestDispatcher.forward(request, response);
	} // POST() END

}
