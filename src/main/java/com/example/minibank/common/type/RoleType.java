package com.example.minibank.common.type;

public enum RoleType {

	ADMIN("1"), USER("2");
	
	private String value;
	
	private RoleType(String value) {
		
		this.value = value;
		
	}
	
	public String getValue() {
		
		return this.value;
		
		
	}
	
	
	
}
