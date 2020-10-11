package com.cs.util;

public class PageSupport {
	//��ǰҳ��-�������û�����
		private int currentPageNo = 1;
		
		//����������
		private int totalCount = 0;
		
		//ҳ������
		private int pageSize = 5;
		
		//��ҳ��-totalCount/pageSize��+1��
		private int totalPageCount = 1;

	public int getCurrentPageNo() {
		return currentPageNo;
	}

	public void setCurrentPageNo(int currentPageNo) {
		if(currentPageNo > 0){
			this.currentPageNo = currentPageNo;
		}
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		if(totalCount > 0){
			this.totalCount = totalCount;
			this.setTotalPageCountByRs();
		}
	}
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		if(pageSize > 0){
			this.pageSize = pageSize;
		}
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	
	//������ҳ���ķ���
	public void setTotalPageCountByRs(){
		//��Ԫ���ʽ
		//this.totalPageCount=(this.totalCount % this.pageSize == 0) ? this.totalCount / this.pageSize:this.totalPageCount = this.totalCount / this.pageSize + 1
		if(this.totalCount % this.pageSize == 0){
			this.totalPageCount = this.totalCount / this.pageSize;
		}else if(this.totalCount % this.pageSize > 0){
			this.totalPageCount = this.totalCount / this.pageSize + 1;
		}else{
			this.totalPageCount = 0;
		}
	}

}
