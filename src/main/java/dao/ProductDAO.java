package dao;

import java.sql.Connection;
import java.util.ArrayList;

import dto.ProductDTO;

public class ProductDAO extends MySQLConnector {
	private Connection conn = null;
	
	public ProductDAO() {

	}

	/**
	 * 상품 목록 조회
	 * @return
	 */
	public ArrayList<ProductDTO> productList(){
		ArrayList<ProductDTO> result = null;
		return result;
	}

	/**
	 * 상품 상세 조회
	 * 
	 * @param no
	 * @return
	 */
	public ProductDTO productDetail(int no)
	{
		conn = connection();
		
		
		return null;
	}

	/**
	 * 상품 등록
	 * 
	 * @param product
	 * @return
	 */
	public boolean insertProduct(ProductDTO product) {
		return false;
	}

	/**
	 * 상품 수정
	 * 
	 * @param ProductDTO
	 * @return
	 */
	public boolean updateProduct(ProductDTO product) {
		return false;
	}

	/**
	 * 상품 삭제
	 * 
	 * @param no
	 * @return
	 */
	public boolean deleteProduct(int no) {
		return false;
	}
}
