package com.demo.bean;

public class Stock {
	
	private long id;
	private String stockId;
	private String stockName;
	private String label;
	
	public Stock() {}

	public Stock(long id, String stockId, String stockName, String label) {
		this.id = id;
		this.stockId = stockId;
		this.stockName = stockName;
		this.label = label;
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

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return "Stock [id=" + id + ", stockId=" + stockId + ", stockName="
				+ stockName + ", label=" + label + "]";
	}

}
