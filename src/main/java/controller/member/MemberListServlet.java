package controller.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import dto.MemberDTO;

/**
 * ȸ�� ����Ʈ �ҷ����� ��Ʈ�ѷ�
 *  @author ���ֿ�
 * **/
@WebServlet("/member/MemberListServlet")
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberDAO memberDAO = null;
	
    public MemberListServlet() {
        super();
    } // ������ END

	/**
	 * GET ��û ���� (ȸ�� ����Ʈ ��ȸ)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		memberDAO = new MemberDAO();
		List<MemberDTO> memberList = memberDAO.selectList();
		
		request.setAttribute("memberList", memberList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/memberMgr.jsp");
	    dispatcher.forward(request, response);
	} // GET() END

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	} // POST() END

}
