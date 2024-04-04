package utils;

public class pageNavigator {

	public pageNavigator() {
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * 페이징 네비게이터를 만들어주는 함수
	 * @param totalCount	- 총수
	 * @param listCount		- 노출될 목록 게시물 수
	 * @param pagePerBlock	- 노출될 블록 수
	 * @param pageNum		- 페이지 번호
	 * @return
	 */
	public String getPageNavigator(int totalCount, int listCount, int pagePerBlock, int pageNum) {
		StringBuffer sb = new StringBuffer();
		if(totalCount > 0) {
			int totalNumOfPage = (totalCount % listCount == 0) ? 
												totalCount / listCount :
												totalCount / listCount + 1;
			
			int totalNumOfBlock = (totalNumOfPage % pagePerBlock == 0) ?
												totalNumOfPage / pagePerBlock :
												totalNumOfPage / pagePerBlock + 1;
			
			int currentBlock = (pageNum % pagePerBlock == 0) ? 
										pageNum / pagePerBlock :
										pageNum / pagePerBlock + 1;
			
			int startPage = (currentBlock - 1) * pagePerBlock + 1;
			int endPage = startPage + pagePerBlock - 1;
			
			if(endPage > totalNumOfPage){
				endPage = totalNumOfPage;
			}
			
			boolean isNext = false;
			boolean isPrev = false;
			if(currentBlock < totalNumOfBlock){
				isNext = true;
			}
			
			if(currentBlock > 1){
				isPrev = true;
			}
			
			if(totalNumOfBlock == 1){
				isNext = false;
				isPrev = false;
			}
			
			if(pageNum > 1){
				sb.append("<a href=\"").append("ProductListServlet?pageNum=1");
				sb.append("\" title=\"◀◀\">◀◀</a>&nbsp;");
			}
			
			if (isPrev) {
				int goPrevPage = startPage - pagePerBlock;			
				sb.append("&nbsp;<a href=\"").append("ProductListServlet?pageNum="+goPrevPage);
				sb.append("\" title=\"◁\">◁</a>&nbsp;");
			} else {
				
			}
			
			for (int i = startPage; i <= endPage; i++) {
				if (i == pageNum) {
					sb.append("<a href=\"#\"><strong>").append(i).append("</strong></a>&nbsp;&nbsp;");
				} else {
					sb.append("<a href=\"").append("ProductListServlet?pageNum="+i);
					sb.append("\" title=\""+i+"\">").append(i).append("</a>&nbsp;&nbsp;");
				}
			}
			
			if (isNext) {
				int goNextPage = startPage + pagePerBlock;
	
				sb.append("<a href=\"").append("ProductListServlet?pageNum="+goNextPage);
				sb.append("\" title=\"▷\">▷</a>");
			} else {
				
			}
			
			if(totalNumOfPage > pageNum){
				sb.append("&nbsp;&nbsp;<a href=\"").append("ProductListServlet?pageNum="+totalNumOfPage);
				sb.append("\" title=\"▶▶\">▶▶</a>");
			}
			
		}
		return sb.toString();
	}
}
