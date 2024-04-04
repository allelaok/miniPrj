package controller.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import dto.MemberDTO;

/**
 * 회원 정보 수정 controller
 *  @author 임주연
 */
@WebServlet("/member/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MemberDTO member = null;
    private MemberDAO memberDAO = null;
    HttpSession session = null;
    private String nowPath;
    private String nextPage;
   
    
    public UpdateServlet() {
        super();
    } // 생성자 END

	/**
	 * GET 요청 수행 (회원 정보 수정 페이지로 이동)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//	회원 정보 가져온 뒤 view로 이동
		memberDAO = new MemberDAO();
		request.setCharacterEncoding("utf-8");
	    response.setContentType("test/html; charset=utf-8");
	     
	    session = request.getSession(false);
		String id = (String) session.getAttribute("id");
		member = memberDAO.detail(id);
		request.setAttribute("member", member);
		
		// 일반 회원인지, admin인지에 따라 루트 변경
		nowPath = request.getParameter("nowPath");
		
		if (nowPath == "a") {
			nextPage = "/admin/memberUpdate.jsp";
		} else {
			nextPage = "/memberUpdate.jsp";
		}
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(nextPage);
		requestDispatcher.forward(request, response);
	} // GET() END

	/**
	 * POST 요청 수행 (회원 정보 수정 수행)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		member = new MemberDTO();
		PrintWriter out = response.getWriter();
		
		request.setCharacterEncoding("utf-8");
	    response.setContentType("test/html; charset=utf-8");
	 	   
 	   	List<String> hobbies = new ArrayList<>();

 	   	List<String> hobbiesName = new ArrayList<>();
 	   	String joinedHobbies = "";
 	   	hobbiesName.add("internet");
        hobbiesName.add("travel");
        hobbiesName.add("gaming");
        hobbiesName.add("movie");
        hobbiesName.add("exercise");
        
        for (String hobby : hobbiesName) {
        	System.out.println(hobby);
            if (request.getParameter(hobby) != null) {
            	System.out.println("yes");
            	hobbies.add(request.getParameter(hobby));
            }
        }
        
        if (hobbies != null && !hobbies.isEmpty()) {
        	joinedHobbies = String.join("", hobbies);
        	System.out.println(joinedHobbies);
        }
        
        session = request.getSession(false);
		String id = (String) session.getAttribute("id");
		
 		member.setId(id);
 		member.setPwd(request.getParameter("pwd"));
 		member.setName(request.getParameter("name"));
 		member.setGender(request.getParameter("gender"));
 		member.setBirthday(request.getParameter("birthday"));
 		member.setEmail(request.getParameter("email"));
 		member.setZipcode(request.getParameter("zipcode"));
 		member.setAddress(request.getParameter("address"));
 		member.setHobby(joinedHobbies);
 		member.setJob(request.getParameter("job"));
		memberDAO = new MemberDAO();
		memberDAO.update(member);
		
		nowPath = request.getParameter("nowPath");
		
		
		if (nowPath == "a") {
			nextPage = "/admin/memberMgr.jsp";
		} else {
			nextPage = "/index.jsp";
		}
		
		System.out.println(nowPath);
		System.out.println(nextPage);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(nextPage);
		requestDispatcher.forward(request, response);
	} // POST() END

}
