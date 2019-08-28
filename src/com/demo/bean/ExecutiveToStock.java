package com.demo.bean;

public class ExecutiveToStock {

	private long id;
	private String executiveId;
	private String stockId;
	private String relation;
	
	public ExecutiveToStock() {}

	public ExecutiveToStock(long id, String executiveId, String stockId,
			String relation) {
		this.id = id;
		this.executiveId = executiveId;
		this.stockId = stockId;
		this.relation = relation;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getExecutiveId() {
		return executiveId;
	}

	public void setExecutiveId(String executiveId) {
		this.executiveId = executiveId;
	}

	public String getStockId() {
		return stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	@Override
	public String toString() {
		return "ExecutiveToStock [id=" + id + ", executiveId=" + executiveId
				+ ", stockId=" + stockId + ", relation=" + relation + "]";
	}
}
