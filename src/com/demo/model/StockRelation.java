package com.demo.model;

import org.neo4j.graphdb.RelationshipType;

public enum StockRelation implements RelationshipType {

	WORKIN, BELONGTO;
	
}
