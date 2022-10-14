package com.chaOreum.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Paging {
	private int endPage;  // 마지막 페이지
	private int block_firstPage;  // 현재 블럭의 첫 페이지
	private int block_endPage;  // 현재 블럭의 마지막 페이지
	private int block_per_page;  // 블럭 당 페이지 수
	private int endBlock_firstPage;  // 마지막 블럭의 첫번째 페이지
	
	public Paging() {}

	public Paging(int endPage, int block_firstPage, int block_endPage, int block_per_page, int endBlock_firstPage) {
		super();
		this.endPage = endPage;
		this.block_firstPage = block_firstPage;
		this.block_endPage = block_endPage;
		this.block_per_page = block_per_page;
		this.endBlock_firstPage = endBlock_firstPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getBlock_firstPage() {
		return block_firstPage;
	}

	public void setBlock_firstPage(int block_firstPage) {
		this.block_firstPage = block_firstPage;
	}

	public int getBlock_endPage() {
		return block_endPage;
	}

	public void setBlock_endPage(int block_endPage) {
		this.block_endPage = block_endPage;
	}

	public int getBlock_per_page() {
		return block_per_page;
	}

	public void setBlock_per_page(int block_per_page) {
		this.block_per_page = block_per_page;
	}

	public int getEndBlock_firstPage() {
		return endBlock_firstPage;
	}

	public void setEndBlock_firstPage(int endBlock_firstPage) {
		this.endBlock_firstPage = endBlock_firstPage;
	}
}