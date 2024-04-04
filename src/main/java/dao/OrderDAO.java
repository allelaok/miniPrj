package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.OrderDTO;
import dto.ProductDTO;

public class OrderDAO extends MySQLConnector {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public OrderDAO() {

	}
	
	/** ��ǰ ���� �������� **/
	public ProductDTO getProduct(int productNo) {
        conn = connection();
        ProductDTO product = null;
        try {
            String query = "SELECT * FROM tblProduct WHERE no = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, productNo);
            rs = pstmt.executeQuery();

            if (rs.next()) {
            	product = new ProductDTO();
            	product.setNo(rs.getInt("no"));
            	product.setProductno(rs.getInt("productno"));
            	product.setProductname(rs.getString("productname"));
            	product.setPrice(rs.getInt("price"));
            	product.setStock(rs.getInt("stock"));
            }
        } catch (SQLException e) {
            System.err.println("getProduct() ����: " + e.getMessage());
        } finally {
            closeResources();
        }
        return productDTO;
    }
	

	/** �ֹ� ����Ʈ ��ȸ **/
	public List<OrderDTO> orderList(int pageNum, int countPerPage) {
	    List<OrderDTO> orderArray = null;
	    this.conn = connection();
	    try {
	        // �ֹ� ����Ʈ ��ȸ
	        String query = "SELECT o.no, o.id, p.name AS productname, o.quantity, o.date, o.state " +
	                        "FROM tblOrder o " +
	                        "JOIN tblProduct p ON o.productno = p.no " +
	                        "ORDER BY o.no DESC " +
	                        "LIMIT ?, ?";
	        this.pstmt = this.conn.prepareStatement(query);
	        this.pstmt.setInt(1, countPerPage * (pageNum - 1)); // ������ ����
	        this.pstmt.setInt(2, countPerPage);// ��ȸ ����
	        // ��ȸ ����
	        this.rs = this.pstmt.executeQuery();

	        // LIST ��ü�� �����ϱ� ���� ��ü ����
	        orderArray = new ArrayList<OrderDTO>();

	        while (rs.next()) {
	            OrderDTO order = new OrderDTO(); // �� ���ڵ带 �ϳ��� ��ü��
	            order.setNo(rs.getInt("no"));
	            order.setProductno(rs.getInt("productno"));
	            order.setProductname(rs.getString("productname"));
	            order.setQuantity(rs.getInt("quantity"));
	            order.setDate(rs.getString("date"));
	            order.setState(rs.getString("state"));
	            order.setId(rs.getString("id"));

	            orderArray.add(order); // ArrayList�� �߰�
	        } // while() END
	    } catch (SQLException e) {
	        System.err.println("selectList() ERR: " + e.getMessage());
	    } finally {
	        closeResources();
	    }

	    return orderArray;
	}


	/** �ֹ� �� ��ȸ **/
	public OrderDTO orderDetail(int no) {
		conn = connection();
		OrderDTO order = null;
		try {
			String query = "SELECT * FROM tblOrder WHERE no = ?";
			this.pstmt = this.conn.prepareStatement(query);
			this.pstmt.setInt(1, no);
			this.rs = this.pstmt.executeQuery();

			if (rs.next()) {
				order = new OrderDTO();
				order.setNo(rs.getInt("no"));
				order.setProductno(rs.getInt("productno"));
				order.setQuantity(rs.getInt("quantity"));
				order.setDate(rs.getString("date"));
				order.setState(rs.getString("state"));
				order.setId(rs.getString("id"));
				
			   	}
		} catch (Exception e) {
			System.err.println("orderDetail() ERR: " + e.getMessage());
		} finally {
			closeResources();
		}
		return order;
	}

	/** �ֹ� ���� �߰� **/
	public boolean insertOrder(OrderDTO order) {
		try {
			String first = "INSERT INTO tblOrder (productno, quantity, date, state, id)";
			String last = "VALUES (?, ?, NOW(), ?, ?)";
			String query = first + last;
			this.pstmt = conn.prepareStatement(query);
			this.pstmt.setInt(1, order.getProductno());
			this.pstmt.setInt(2, order.getQuantity());
			this.pstmt.setString(3, order.getDate());
			this.pstmt.setString(4, order.getState());
			this.pstmt.setString(5, order.getId());
			this.pstmt.executeUpdate();

			return true;

		} catch (Exception e) {
			System.err.println("insertOrder() ERR: " + e.getMessage());

			return false;

		} finally {
			closeResources();
		}
	}

	/** �ֹ� ���� ���� **/
	public boolean updateOrder(OrderDTO order) {
		try {
			String query = "UPDATE tblOrder SET state=? WHERE no=?";
			this.pstmt = conn.prepareStatement(query);
			this.pstmt.setString(1, order.getState());
			this.pstmt.setInt(2, order.getNo());
			this.pstmt.executeUpdate();

			return true;

		} catch (Exception e) {
			System.err.println("updateOrder() ERR: " + e.getMessage());
			return false;
		} finally {
			closeResources();
		}
	}

	/** �ֹ� ���� ���� **/
	public boolean deleteOrder(int no) {
		try {
			this.conn = connection();

			String query = "DELETE FROM tblOrder WHERE no=?";
			this.pstmt = conn.prepareStatement(query);
			this.pstmt.setInt(1, no);
			int affectedRows = pstmt.executeUpdate();
			if (affectedRows > 0) {
				System.out.println("=> Deletion SUCCESS!!");
			} else {
				System.out.println("=> No order found with the given ID.");
			}

			return true;
		} catch (Exception e) {
			System.err.println("deleteOrder() ERR: " + e.getMessage());
			return false;
		} finally {
			closeResources();
		}
	}

	private void closeResources() {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
