package dto;

public class ProductDTO {

	private int no;
	private String name;
	private int price;
	private String detail;
	private int date;
	private String stock;
	private String image;

	public ProductDTO() {

	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "ProductDTO [no=" + no + ", name=" + name + ", price=" + price + ", detail=" + detail + ", date=" + date
				+ ", stock=" + stock + ", image=" + image + "]";
	}
	
//	// 파라미터
//	String no = request.getParameter("no");
//	String name = request.getParameter("name");
//	String price = request.getParameter("price");
//	String detail = request.getParameter("detail");
//	String date = request.getParameter("date");
//	String stock = request.getParameter("stock");
//	String image = request.getParameter("image");
//
//	// 모델
//	ProductDTO productDTO = new ProductDTO();
//	productDTO.setNo(Integer.parseInt(no));
//	productDTO.setName(name);
//	productDTO.setNo(Integer.parseInt(price));
//	productDTO.setDetail(detail);
//	productDTO.setNo(Integer.parseInt(date));
//	productDTO.setStock(stock);
//	productDTO.setImage(image);
	
}
