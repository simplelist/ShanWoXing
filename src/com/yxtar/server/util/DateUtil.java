package com.yxtar.server.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.yxtar.app.base.utility.ValidationUtil;

public class DateUtil {
	private DateUtil() {
	}

	private static DateUtil util;

	public static DateUtil getInstance() {
		if (util == null) {
			util = new DateUtil();
		}
		return util;
	}

	SimpleDateFormat sdf;

	public Date parseDate(String str, String format) {
		Date date = null;
		sdf = new SimpleDateFormat(format);
		if (ValidationUtil.getInstance().StrisNull(str)) {
			return null;
		}
		try {
			date = sdf.parse(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 2015-09-28 00:00:00
	 * parse date to longTime 1443369600000
	 * @param today
	 * @return 当天的零点
	 */
	public Long DateToZeroLongTime(Date today) {
		String todayString = (1900 + today.getYear()) + "-" + (today.getMonth() + 1) + "-" + today.getDate() + "";
		return parseDate(todayString, "yyyy-MM-dd").getTime();
	}
}
