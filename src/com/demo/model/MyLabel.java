package com.demo.model;

import org.neo4j.graphdb.Label;

public class MyLabel implements Label {

	private String name;
	
	public MyLabel(String name) {
		this.name = name;
	}

	@Override
	public String name() {
		return this.name;
	}

}
