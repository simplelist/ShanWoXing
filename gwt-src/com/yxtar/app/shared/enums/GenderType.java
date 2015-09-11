package com.yxtar.app.shared.enums;

/**
 * GenderType
 * 
 * @author jackshi
 *
 */
public enum GenderType {
	male("m"), famale("f"), secret("n");

	private String type;

	public String getType() {
		return type;
	}

	private GenderType(String type) {
		this.type = type;
	}

}
