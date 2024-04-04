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

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import dao.MemberDAO;
import dao.ZipcodeDAO;
import dto.MemberDTO;
import dto.ZipcodeDTO;

/**
 * 회원 가입 controller
 * @author 임주연
 */
@WebServlet("/member/SignUpServlet/*")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MemberDTO member = null;
    private MemberDAO memberDAO = null;
    private ZipcodeDAO zipcodeDAO = null;
   
    public SignUpServlet() {
        super();
    } // 생성자 END

	/**
	 * GET 요청 수행(회원가입 페이지로 이동)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// view 보내기
 		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/signup.jsp");
 		requestDispatcher.forward(request, response);
	} // GET() END

	/**
	 * POST 요청 수행(회원가입 수행)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	} // POST() END

	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8");
	     response.setContentType("test/html; charset=utf-8");
	      
	     String action = request.getPathInfo(); // 요청 주소 추출
	     System.out.println("action : " + action);
	     
	     if (action == null || action.equals("/signup.jsp")) {
	    	 member = new MemberDTO();
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
	        }
	        
	 		member.setId(request.getParameter("id"));
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
	 		memberDAO.signup(member);
	 		
	 		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.jsp");
	 		requestDispatcher.forward(request, response);

	     } else if (action.equals("/confirmDuplicate.do")) { // 아이디 중복 조회
	    	 PrintWriter out = response.getWriter();
	    	 
	    	 String id = (String) request.getParameter("id");
	    	 memberDAO = new MemberDAO();
	    	 boolean result = memberDAO.confirmDuplicate(id);
	    	 
	    	 if (result) {
	    		 out.write("not_usable");
	    	 } else {
	    		 out.write("usable");
	    	 }
	    	 return;
	     } else if (action.equals("/findZipcode.do")) {
	    	 PrintWriter out = response.getWriter();
	    	 List<ZipcodeDTO> zipList = null;
	    	 
	    	 String address = (String) request.getParameter("address");
	    	 zipcodeDAO = new ZipcodeDAO();
	    	 zipList = zipcodeDAO.findZipcode(address);
	    	 
	    	 JSONArray jsonArray = new JSONArray();
	    	 if (!zipList.isEmpty()) {
	    		 for (ZipcodeDTO zipcode: zipList) {
		    		 JSONObject jsonObject = new JSONObject();
		    		 jsonObject.put("zipcode", zipcode.getZipcode());
		    		 jsonObject.put("area1", zipcode.getArea1());
		    		 jsonObject.put("area2", zipcode.getArea2());
		    		 jsonObject.put("area3", zipcode.getArea3());
		    		 jsonObject.put("area4", zipcode.getArea4());
		    		 
		    		 jsonArray.add(jsonObject);
		    	 }
	    	 }
	    	 
	    	 out.write(jsonArray.toJSONString());
	    	 return;
	     }
		
	} // doHandle() END
}
