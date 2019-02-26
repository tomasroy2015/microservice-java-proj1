package jp.co.linkstaff.iis.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.text.ParseException;

/**
 * 
 * @author Roy
 *
 */
public class Util {
	static String datePattern1 = "yyyy-MM-dd";
	static String datePattern2 = "yyyy/MM/dd";
	public static Date getFormatedDate(String input) {
		String pattern = input.contains("/") ? datePattern2 : datePattern1;
		DateFormat dateFormat = new SimpleDateFormat(pattern,Locale.JAPAN);
		Date date = null;
		try {
			date = dateFormat.parse(input);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	public static String formatedDate(Date input) {
		SimpleDateFormat ymd = new SimpleDateFormat("yyyy-MM-dd");
		// Format the date to Strings
		String formatString = ymd.format(input);
		return formatString;
	}
	public enum JobType {
		FULLTIME, PARTTIME, MEDICHECK, SPOT;
	}

	public enum JobStatus {
		PUBLISHED, ACCEPTED, CANCELLED, DELETED;
	}

	public enum DisplayType {
		有, // yes
		無, // no
		仮,// temporary
	}

	public enum Days {
		日, 月, 火, 水, 木, 金, 土
	}

	public enum AmPm {
		AM, PM
	}
}
