package dto;

public class ListDTO {

	/** 페이지 번호 */
	private String pageNum = "1";
	/** 목록 페이지 게시물 노출 수 */
	private int listCount = 10;
	/** 목록 페이지 네비게이터 블록 수 */
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
