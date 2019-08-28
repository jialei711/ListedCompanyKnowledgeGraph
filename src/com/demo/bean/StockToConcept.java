package com.demo.bean;

public class StockToConcept {
	
	private long id;
	private String stockId;
	private String conceptId;
	private String relation;
	
	public StockToConcept() {}

	public StockToConcept(long id, String stockId, String conceptId,
			String relation) {
		this.id = id;
		this.stockId = stockId;
		this.conceptId = conceptId;
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

	public String getConceptId() {
		return conceptId;
	}

	public void setConceptId(String conceptId) {
		this.conceptId = conceptId;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	@Override
	public String toString() {
		return "StockToConcept [id=" + id + ", stockId=" + stockId
				+ ", conceptId=" + conceptId + ", relation=" + relation + "]";
	}
}
