package com.yxtar.app.base.utility;

/**
 * this util was used to convert number to display
 * 
 * @author jackshi
 * 
 */
public class DisplayUtil {

	/**
	 * convert the id to the length
	 * 
	 * @param numOfDigit
	 * @param id
	 * @return
	 */
	public static String convertDisplayId(int numOfDigit, int id) {
		return convertDisplayId(numOfDigit, id + "");
	}

	public static String convertDisplayId(int numOfDigit, Long id) {
		return convertDisplayId(numOfDigit, id + "");
	}

	public static String convertDisplayId(int numOfDigit, String id) {
		if (id == null) {
			id = "";
		}
		String zero = "";
		for (int i = 0; i < numOfDigit - id.length(); i++) {
			zero += "0";
		}
		return zero + id;
	}

	/**
	 * convert the file size to General format
	 * 
	 * @param file
	 *            size
	 * @return
	 */
	public static String convertDisplaySize(String psize) {
		String displaySize = "0MB";
		if (!psize.equals("0") || psize != "0") {
			Integer sum = Integer.valueOf(psize);
			int avg = sum / 1000000;
			if (avg > 0) {
				displaySize = avg + "MB";
			}
			if (avg == 0) {
				avg = sum / 1000;
				if (avg > 0) {
					displaySize = avg + "KB";
				}
				if (avg == 0) {
					displaySize = sum + "B";
				}
			}
		}
		return displaySize;
	}
}
