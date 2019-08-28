package com.demo.bean;

public class StockToIndustry {

	private long id;
	private String stockId;
	private String industryId;
	private String relation;
	
	public StockToIndustry() {}

	public StockToIndustry(long id, String stockId, String industryId,
			String relation) {
		this.id = id;
		this.stockId = stockId;
		this.industryId = industryId;
		this.relation = relation;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStockId() {
		return stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}

	public String getIndustryId() {
		return industryId;
	}

	public void setIndustryId(String industryId) {
		this.industryId = industryId;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	@Override
	public String toString() {
		return "StockToIndustry [id=" + id + ", stockId=" + stockId
				+ ", industryId=" + industryId + ", relation=" + relation + "]";
	}
	
}
