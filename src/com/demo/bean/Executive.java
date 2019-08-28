package com.demo.bean;

public class Executive {
	
	private long id;
	private String name;
	private String gender;
	private String age;
	private String stockId;
	private String position;
	private String label;
	private String personId;
	
	public Executive() {}

	public Executive(long id, String name, String gender, String age,
			String stockId, String position, String label, String personId) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.stockId = stockId;
		this.position = position;
		this.label = label;
		this.personId = personId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getStockId() {
		return stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	@Override
	public String toString() {
		return "Executive [id=" + id + ", name=" + name + ", gender=" + gender
				+ ", age=" + age + ", stockId=" + stockId + ", position="
				+ position + ", label=" + label + ", personId=" + personId
				+ "]";
	}

}
