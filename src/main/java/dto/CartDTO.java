package dto;

public class CartDTO {
	private int no;
	private String id;
	private int productno;
	private int quantity;
	
	public CartDTO() {
		
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getProductno() {
		return productno;
	}

	public void setProductno(int productno) {
		this.productno = productno;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "CartDTO [no=" + no + ", id=" + id + ", productno=" + productno + ", quantity=" + quantity + "]";
	}
}
