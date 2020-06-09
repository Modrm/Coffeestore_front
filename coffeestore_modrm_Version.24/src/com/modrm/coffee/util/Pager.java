package com.modrm.coffee.util;

public class Pager {
	private int currentPage;  // 当前是第几页       前台传来的    已知的
	private int pageSize=3;    // 每页放置三条记录    自己定义的
	private int totalSize;     //  总的记录数 ，需要访问数据库来获得   未知的
	private int totalPage;     // 总的页数      总的记录数/每页记录数    判断余数是否为0 ，不为0则页数要加1
	
	private boolean hasFist;     // 是否有第一页  首页     当前页是1的时候  没有首页
	private boolean hasPrevious;  // 是否有上一页
	private boolean hasNext;      // 是否有下一页
	private boolean hasLast;      // 是否有最后一页     当前页=总页数的时候  没有尾页
	
	//构造方法  初始化相关参数
	public Pager(int currentPage,int totalSize){
		this.currentPage=currentPage;
		this.totalSize=totalSize;
	}
	
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}
	// 修改    算法前面讲了   100/3    33  100%3  1   33+1   99/3 33  余数为0  33 
	public int getTotalPage() {
		totalPage = totalSize/pageSize;
		if(totalSize%pageSize!=0){
			totalPage++;
		}
		return totalPage;
	}
	
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	//判断当前页是否为1   如果是，则没有首页， 返回false    有返回true
	public boolean isHasFist() {
		if(currentPage==1){
			return false;
		}
		return true;
	}
	public void setHasFist(boolean hasFist) {
		this.hasFist = hasFist;
	}
	
	// 判断是否有“上一页”    如果 首页存在，就一定有上一页
	public boolean isHasPrevious() {
		if(isHasFist()){
			return true;
		}else{
			return false;
		}
	}
	public void setHasPrevious(boolean hasPrevious) {
		this.hasPrevious = hasPrevious;
	}
	// 判断是否有尾页，有尾页，就有下一页
	public boolean isHasNext() {
		if(isHasLast())
			return true;
		else
			return false;
	}
	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}
	//判断是否有尾页   ，  当前页=总页数，则是最后一页，没有尾页
	public boolean isHasLast() {
		if(currentPage==getTotalPage()){
			return false;
		}else{
			return true;
		}
	}
	public void setHasLast(boolean hasLast) {
		this.hasLast = hasLast;
	}
	
	
}
