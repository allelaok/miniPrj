package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.ProductDTO;

public class ProductDAO extends MySQLConnector {
	private Connection conn = null;

	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public ProductDAO() {

	}

	/**
	 * Total number of products
	 * 
	 * @param no
	 * @return
	 */
	public int selectCount() {
		int totalCount = 0;

		this.conn = connection();
		try {
			// 게시물의 총 수를 얻는 쿼리 실행
			String query = "SELECT COUNT(NO) AS TOTAL FROM tblproduct";
			this.pstmt = this.conn.prepareStatement(query);
			this.rs = this.pstmt.executeQuery(); // 쿼리 실행

			if (this.rs.next()) {
				totalCount = this.rs.getInt("TOTAL"); // 결과 필드명을 이용
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close(this.conn, this.pstmt, this.rs);
		}
		return totalCount;
	}
	
	/**
	 * Get All Product List
	 * 
	 * @return
	 */
	public ArrayList<ProductDTO> allProductList() {
		ArrayList<ProductDTO> productArray = null;

		this.conn = connection();
		try {
			// 게시물 목록 조회 (목록화면에 필요한 필드만...)
			String query = "SELECT * FROM tblproduct ORDER BY NO DESC";
			this.pstmt = this.conn.prepareStatement(query);
			// 조회 실행
			this.rs = this.pstmt.executeQuery();

			// LIST 객체에 저장하기 위한 객체 생성
			productArray = new ArrayList<ProductDTO>();

			while (this.rs.next()) {
				ProductDTO product = new ProductDTO(); // 각 레코드를 하나의 객체로
				product.setDate(rs.getDate("date"));
				product.setNo(rs.getInt("no"));
				product.setPrice(rs.getInt("price"));
				product.setName(rs.getString("name"));
				product.setDetail(rs.getString("detail"));
				product.setStock(rs.getInt("stock"));
				product.setImage(rs.getString("image"));

				productArray.add(product); // ArrayList에 추가
				
			} // while() END
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			// 사용한 객체 종료
			close(this.conn, this.pstmt, this.rs);
		}
		return productArray;
	}

	/**
	 * Get Product List part
	 * 
	 * @return
	 */
	public ArrayList<ProductDTO> productList(int pageNum, int countPerPage) {
		ArrayList<ProductDTO> productArray = null;

		this.conn = connection();
		try {
			// 게시물 목록 조회 (목록화면에 필요한 필드만...)
			String query = "SELECT * FROM tblproduct ORDER BY NO DESC LIMIT ?, ?";
			this.pstmt = this.conn.prepareStatement(query);
			this.pstmt.setInt(1, countPerPage * (pageNum - 1)); // 페이지의 시작 번호
			this.pstmt.setInt(2, countPerPage); // 조회 갯수
			System.out.println(countPerPage * (pageNum - 1));
			// 조회 실행
			this.rs = this.pstmt.executeQuery();

			// LIST 객체에 저장하기 위한 객체 생성
			productArray = new ArrayList<ProductDTO>();

			while (this.rs.next()) {
				ProductDTO product = new ProductDTO(); // 각 레코드를 하나의 객체로
				product.setDate(rs.getDate("date"));
				product.setNo(rs.getInt("no"));
				product.setPrice(rs.getInt("price"));
				product.setName(rs.getString("name"));
				product.setDetail(rs.getString("detail"));
				product.setStock(rs.getInt("stock"));
				product.setImage(rs.getString("image"));

				productArray.add(product); // ArrayList에 추가
				
			} // while() END
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			// 사용한 객체 종료
			close(this.conn, this.pstmt, this.rs);
		}
		return productArray;
	}

	/**
	 * Product Detail
	 * 
	 * @param no
	 * @return
	 */
	public ProductDTO productDetail(int no) {
		conn = connection();
		ProductDTO product = null;
		
		try {
			String query="SELECT * FROM tblproduct WHERE NO = ?";
			this.pstmt = this.conn.prepareStatement(query);
			this.pstmt.setInt(1, no);
			this.rs = this.pstmt.executeQuery();
			
			// 값이 존재한다면 
			if (this.rs.next()) {
				product = new ProductDTO(); 
				product.setDate(rs.getDate("date"));
				product.setNo(rs.getInt("no"));
				product.setPrice(rs.getInt("price"));
				product.setName(rs.getString("name"));
				product.setDetail(rs.getString("detail"));
				product.setStock(rs.getInt("stock"));
				product.setImage(rs.getString("image"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			// 사용한 객체 종료
			close(this.conn, this.pstmt, this.rs);
		}
		return product;
	}

	/**
	 * Insert product data
	 * 
	 * @param product
	 * @return
	 */
	public boolean insertProduct(ProductDTO product) {
		
		try {
			
			this.conn = connection();
			
			String first ="INSERT INTO tblproduct (NAME, PRICE, DETAIL, DATE, STOCK, IMAGE)";
			String last =" VALUES (?, ?, ?,  NOW(), ?, ?)";
			String query=first+last;
			this.pstmt = this.conn.prepareStatement(query);
			
			this.pstmt.setString(1, product.getName());
			this.pstmt.setInt(2, product.getPrice());
			this.pstmt.setString(3, product.getDetail());
			this.pstmt.setInt(4, product.getStock());
			this.pstmt.setString(5, product.getImage());
			this.pstmt.executeUpdate();
			
			return true;
			
		} catch (SQLException e) {
			
			System.out.println("insertProduct() ERR : " + e.getMessage());
			return false;
		} finally {
			// 사용한 객체 종료
			close(this.conn, this.pstmt);
		}
	}

	/**
	 * Update product data
	 * 
	 * @param ProductDTO
	 * @return
	 */
	public boolean updateProduct(ProductDTO product) {

		try {
			this.conn =connection();
			String image = "";
			if(product.getImage() != null)
				image = ", IMAGE=?";
			
			String query="update tblproduct set NAME=?, PRICE=?, DETAIL=?, STOCK=?" + image + " where no=" + product.getNo();

			this.pstmt=this.conn.prepareStatement(query);
			this.pstmt.setString(1, product.getName());
			this.pstmt.setInt(2, product.getPrice());
			this.pstmt.setString(3, product.getDetail());
			this.pstmt.setInt(4, product.getStock());
			if(product.getImage() != null)
			this.pstmt.setString(5, product.getImage());
			this.pstmt.executeUpdate();
			
				return true;
		} catch (SQLException e) {
			
			System.out.println("updateProduct() ERR : " + e.getMessage());
			return false;
		} finally {
			// 사용한 객체 종료
			close(this.conn, this.pstmt);
		}
		
	}

	/**
	 * �긽�뭹 �궘�젣
	 * 
	 * @param no
	 * @return
	 */
	public boolean deleteProduct(int no) {
		try {
			this.conn = connection();
			
			// 삭제 쿼리 실행
			String query="delete from tblproduct where no=?";

			this.pstmt=this.conn.prepareStatement(query);
			this.pstmt.setInt(1, no);
			this.pstmt.executeUpdate();

			return true;

		} catch (SQLException e) {
			System.err.println("deleteProduct() ERR : " + e.getMessage());
			return false;
		} finally {
			// 사용한 객체 종료
			close(this.conn, this.pstmt);
		}
		
	}
}
