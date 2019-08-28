package com.demo.bean;

public class Industry {
	
	private long id;
	private String industryName;
	private String label;
	private String industryId;
	
	public Industry() {}

	public Industry(long id, String industryName, String label,
			String industryId) {
		this.id = id;
		this.industryName = industryName;
		this.label = label;
		this.industryId = industryId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIndustryName() {
		return industryName;
	}

	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getIndustryId() {
		return industryId;
	}

	public void setIndustryId(String industryId) {
		this.industryId = industryId;
	}

	@Override
	public String toString() {
		return "Industry [id=" + id + ", industryName=" + industryName
				+ ", label=" + label + ", industryId=" + industryId + "]";
	}
}
