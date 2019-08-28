package com.demo.bean;

public class Concept {
	
	private long id;
	private String conceptName;
	private String conceptId;
	private String label;
	
	public Concept() {}

	public Concept(long id, String conceptName, String conceptId, String label) {
		this.id = id;
		this.conceptName = conceptName;
		this.conceptId = conceptId;
		this.label = label;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getConceptName() {
		return conceptName;
	}

	public void setConceptName(String conceptName) {
		this.conceptName = conceptName;
	}

	public String getConceptId() {
		return conceptId;
	}

	public void setConceptId(String conceptId) {
		this.conceptId = conceptId;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return "Concept [id=" + id + ", conceptName=" + conceptName
				+ ", conceptId=" + conceptId + ", label=" + label + "]";
	}

}
