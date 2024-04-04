package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.MemberDTO;
import dto.ZipcodeDTO;

/**
 * 회원 관련 DAO
 * @author 임주연
 * **/
public class MemberDAO {
	private Connection connector = null;
	private MySQLConnector datasource = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public MemberDAO() {
		datasource = new MySQLConnector();
	}
	
	/**
	 * 회원가입
	 * @param MemberDTO
	 * @return boolean
	 * **/
	public boolean signup(MemberDTO member) {
		boolean state = false;
		
		try {
			connector = datasource.connection();
			String query = "insert into tblMember values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			pstmt = connector.prepareStatement(query);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPwd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getGender());
			pstmt.setString(5, member.getBirthday());
			pstmt.setString(6, member.getEmail());
			pstmt.setString(7, member.getZipcode());
			pstmt.setString(8, member.getAddress());
			pstmt.setString(9, member.getHobby());
			pstmt.setString(10, member.getJob());
			System.out.println(pstmt);
			
			int n = pstmt.executeUpdate();
			
			if (n > 1) {
				state = true;
			}
		} catch (SQLException e) {
			System.err.println("signup(): " + e.getMessage());
		} finally {
			datasource.close(connector, pstmt);
		}
		
		return state;
	}
	
	/**
	 * 로그인
	 * @param String id
	 * @param String pwd
	 * @return boolean
	 * **/
	public boolean login(String id, String pwd) {
		boolean state = false;
		try {
			connector = datasource.connection();
			String query = "select count(*) from tblMember where id = ? and pwd = ?";
			
			pstmt = connector.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			
			rs = pstmt.executeQuery();
			
			int count = 0;
			if (rs.next()) {
				count = rs.getInt("count(*)");
			}
			
			if (count == 1) {
				state = true;
			}
		} catch (SQLException e) {
			System.err.println("login(): " + e.getMessage());
		} finally {
			datasource.close(connector, pstmt, rs);
		}
		
		return state;
	}
	
	/**
	 * 아이디 중복 확인
	 * @param String id
	 * @return boolean
	 * **/
	public boolean confirmDuplicate(String id) {
		boolean state = false;
		try {
			connector = datasource.connection();
			String query = "select count(*) from tblMember where id = ?";
			
			pstmt = connector.prepareStatement(query);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			int count = 0;
			if (rs.next()) {
				count = rs.getInt("count(*)");
			}
			
			if (count == 1) {
				state = true;
			}
		} catch (SQLException e) {
			System.err.println("login(): " + e.getMessage());
		} finally {
			datasource.close(connector, pstmt, rs);
		}
		
		return state;
	}

	
	/**
	 * 주소 검색
	 * @return List<MemberDTO>
	 * **/
	public List<MemberDTO> selectList() {
		List<MemberDTO> memberList = new ArrayList<MemberDTO>();
		
		try {
			connector = datasource.connection();
			String query = "select * from tblMember order by name";
			
			pstmt = connector.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			MemberDTO member = null;
			while(rs.next()) {
				member = new MemberDTO();
				member.setId(rs.getString("id"));
				member.setPwd(rs.getString("pwd"));
				member.setName(rs.getString("name"));
				member.setEmail(rs.getString("email"));
				member.setZipcode(rs.getString("zipcode"));
				member.setAddress(rs.getString("address"));
				member.setGender(rs.getString("gender"));
				member.setJob(rs.getString("job"));
				member.setHobby(rs.getString("hobby"));
				
				memberList.add(member);
			}	
		} catch (SQLException e) {
			System.err.println("selectList(): " + e.getMessage());
		} finally {
			datasource.close(connector, pstmt, rs);
		}
		
		return memberList;
	}
	
	/**
	 * 유저 상세 정보
	 * @param id
	 * @return MemberDTO
	 * **/
	public MemberDTO detail(String id) {
		MemberDTO member = new MemberDTO();
		
		try {
			connector = datasource.connection();
			String query = "select * from tblMember where id=?";
			
			pstmt = connector.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				member = new MemberDTO();
				member.setId(rs.getString("id"));
				member.setPwd(rs.getString("pwd"));
				member.setName(rs.getString("name"));
				member.setEmail(rs.getString("email"));
				member.setBirthday(rs.getString("birthday"));
				member.setZipcode(rs.getString("zipcode"));
				member.setAddress(rs.getString("address"));
				member.setGender(rs.getString("gender"));
				member.setJob(rs.getString("job"));
				member.setHobby(rs.getString("hobby"));
			}	
		} catch (SQLException e) {
			System.err.println("detail(): " + e.getMessage());
		} finally {
			datasource.close(connector, pstmt, rs);
		}
		
		return member;
	}
	
	/**
	 * 회원 정보 수정
	 * @param MemberDTO
	 * @return boolean
	 * **/
	public boolean update(MemberDTO member) {
		boolean state = false;
		
		try {
			connector = datasource.connection();
			String query = "update tblMember set pwd = ?, name = ?, gender =?, birthday = ?, email = ?, zipcode = ?, address = ?, hobby = ?, job = ? where id = ?";
			
			pstmt = connector.prepareStatement(query);
			
			pstmt.setString(1, member.getPwd());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getGender());
			pstmt.setString(4, member.getBirthday());
			pstmt.setString(5, member.getEmail());
			pstmt.setString(6, member.getZipcode());
			pstmt.setString(7, member.getAddress());
			pstmt.setString(8, member.getHobby());
			pstmt.setString(9, member.getJob());
			pstmt.setString(10, member.getId());
			System.out.println(pstmt);
			int n = pstmt.executeUpdate();
			
			if (n > 1) {
				state = true;
			}
		} catch (SQLException e) {
			System.err.println("update(): " + e.getMessage());
		} finally {
			datasource.close(connector, pstmt);
		}
		
		return state;
	}
}
