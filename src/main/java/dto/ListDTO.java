package dto;

public class ListDTO {

	/** ������ ��ȣ */
	private String pageNum = "1";
	/** ��� ������ �Խù� ���� �� */
	private int listCount = 10;
	/** ��� ������ �׺������ ��� �� */
	private int pagePerBlock = 10;
	
	public ListDTO() {
		
	}

	public String getPageNum() {
		return pageNum;
	}

	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}

	public int getListCount() {
		return listCount;
	}

	public void setListCount(int listCount) {
		this.listCount = listCount;
	}

	public int getPagePerBlock() {
		return pagePerBlock;
	}

	public void setPagePerBlock(int pagePerBlock) {
		this.pagePerBlock = pagePerBlock;
	}
	

	@Override
	public String toString() {
		return "ListDTO [pageNum=" + pageNum + ", listCount=" + listCount + ", pagePerBlock=" + pagePerBlock + "]";
	}

}
