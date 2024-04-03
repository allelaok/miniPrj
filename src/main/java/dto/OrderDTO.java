package dto;

public class OrderDTO {

	private int no;
	private int productno;
	private int quantity;
	private String date;
	private String state;
	private String id;

	public OrderDTO() {

	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "OrderDTO [no=" + no + ", productno=" + productno + ", quantity=" + quantity + ", date=" + date
				+ ", state=" + state + ", id=" + id + "]";
	}
}
