package com.yxtar.app.shared.enums;
/**
 * PhotoType
 * @author jackshi
 *
 */
public enum PhotoType {
	JPG(0),
	PNG(1),
	JPEG(2),
	TIF(3)
	;
	
	
	private Integer type;

	public Integer getType() {
		return type;
	}

	private PhotoType(Integer type) {
		this.type = type;
	}

}
