package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.ZipcodeDTO;

/**
 * 林家 包访 DAO
 * @author 烙林楷
 * **/
public class ZipcodeDAO {
	private Connection connector = null;
	private MySQLConnector datasource = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public ZipcodeDAO() {
		datasource = new MySQLConnector();
	}
	
	
	/**
	 * 林家 八祸
	 * @param address
	 * @return List<ZipcodeDTO>
	 * **/
	public List<ZipcodeDTO> findZipcode(String address) {
		List<ZipcodeDTO> zipList = new ArrayList<ZipcodeDTO>();
		
		String[] addressList = address.split(" ");
		
		try {
			connector = datasource.connection();
			String query = "select * from tblZipcode where zipcode like ? or area1 like ? or area2 like ? or area3 like ? or area4 like ?";
			
			for (String addressOne : addressList) {
				pstmt = connector.prepareStatement(query);
				String wildcard = "%" + addressOne + "%";
				pstmt.setString(1, wildcard);
				pstmt.setString(2, wildcard);
				pstmt.setString(3, wildcard);
				pstmt.setString(4, wildcard);
				pstmt.setString(5, wildcard);
				System.out.println(pstmt);
				rs = pstmt.executeQuery();
				
				ZipcodeDTO zipcode = null;
				while(rs.next()) {
					zipcode = new ZipcodeDTO();
					zipcode.setZipcode(rs.getString("zipcode"));
					zipcode.setArea1(rs.getString("area1"));
					zipcode.setArea2(rs.getString("area2"));
					zipcode.setArea3(rs.getString("area3"));
					zipcode.setArea4(rs.getString("area4"));
					System.out.println(zipcode.getArea1());
					if (!zipList.contains(zipcode)) {
						zipList.add(zipcode);
					}
				}
			}
		} catch (SQLException e) {
			System.err.println("findZipcode(): " + e.getMessage());
		} finally {
			datasource.close(connector, pstmt, rs);
		}
		
		return zipList;
	}
}
