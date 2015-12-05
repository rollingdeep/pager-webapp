package com.xch.page.model;

import java.io.Serializable;
import java.util.List;

public class Pager<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6150972860315433465L;
	
	private int pageSize;//每页显示多少条数据
	
	private int currentPage;//当前第几页数据
	
	private int totalRecord;//一共多少条记录
	
	private int totalPage;//一共多少页记录
	
	private List<T> dataList;//要显示的数据

	
	public Pager() {
		super();
	}
	
	public Pager(int pageNum,int pageSize, List<T> source) {
		if(source == null){
			return;
		}
		this.pageSize = pageSize;
		this.totalRecord = source.size();
		this.pageSize = pageSize;
		
		//总页数
		this.totalPage = this.totalRecord/this.pageSize;
		if(this.totalRecord % this.pageSize != 0){
			this.totalPage += 1;
		}
		//当前页数
		if(this.totalPage < pageNum){
			this.currentPage = this.totalPage;
		}else{
			this.currentPage = pageNum;
		}
		
		int fromIndex = this.pageSize * (this.currentPage - 1);
		int toIndex;
		if(this.pageSize * this.currentPage > this.totalRecord){
			toIndex = this.totalRecord;
		}else{
			toIndex = this.pageSize * this.currentPage;
		}
		
		this.dataList = source.subList(fromIndex, toIndex);
	}


	public Pager(int pageSize, int currentPage, int totalRecord, int totalPage,
			List<T> dataList) {
		super();
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		this.totalRecord = totalRecord;
		this.totalPage = totalPage;
		this.dataList = dataList;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}

	
	
}
