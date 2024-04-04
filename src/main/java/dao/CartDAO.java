package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.CartDTO;

public class CartDAO extends MySQLConnector {
	private Connection connect = null;
	private PreparedStatement pstmt = null;
	private MySQLConnector dataFactory = null;
	private ResultSet rs = null;
	
	public CartDAO() {
		dataFactory = new MySQLConnector(); 
	}
	
	public List<CartDTO> listMembers() {
		List<CartDTO> membersList = new ArrayList<CartDTO>();
		try {
			connect = dataFactory.connection();
			String query = "select * from  tblcart order by no desc";
			System.out.println(query);
			
			pstmt = connect.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int no = rs.getInt("no");
				int productno = rs.getInt("productno");
				int quantity = rs.getInt("quantity");
				String id = rs.getString("id");
				CartDTO cartDTO = new CartDTO(no, productno, quantity, id);
				membersList.add(cartDTO);
				System.out.println(cartDTO);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return membersList;
	}
	
	public void insertCart(CartDTO c) {
		try {
			connect = dataFactory.connection();
			int no = c.getNo();
			int productno = c.getProductno();
			int quantity = c.getQuantity();
			String id = c.getId();
			String query = "INSERT INTO tblcart (no, productno, quantity, id)" + " VALUES (?, ? ,? ,?, now())";
			System.out.println(query);
			
			pstmt = connect.prepareStatement(query);
			pstmt.setInt(1, no);
			pstmt.setInt(2, productno);
			pstmt.setInt(3, quantity);
			pstmt.setString(4, id);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateCart(CartDTO cartDTO) {
		int no = cartDTO.getNo();
		int productno = cartDTO.getProductno();
		int quantity = cartDTO.getQuantity();
		String id = cartDTO.getId();
		try {
			connect = dataFactory.connection();
			String query = "update tblcart set id=?,productno=?, quantity=? where no=?";
			System.out.println(query);
			pstmt = connect.prepareStatement(query);
			pstmt.setInt(1, no);
			pstmt.setInt(2, productno);
			pstmt.setInt(3, quantity);
			pstmt.setString(4, id);
			pstmt.executeUpdate();
			pstmt.close();
//			connect.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteCart(String id) {
		try {
			connect = dataFactory.connection();
			String query = "delete from tblcart where id=?";
			System.out.println(query);
			pstmt = connect.prepareStatement(query);
			pstmt.setString(1,id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
