/**
 * created by 2010-7-2
 */
package com.nju.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * ���ڹ�����
 * 
 * 
 */
/**
 * @author wangy
 *
 */
public class DateUtil {
	public final static String shortFormat = "yyyyMMdd";
	public final static String longFormat = "yyyyMMddHHmmss";
	public final static String webFormat = "yyyy-MM-dd";
	public final static String timeFormat = "HHmmss";
	public final static String monthFormat = "yyyyMM";
	public final static String chineseDtFormat = "yyyy��MM��dd��";
	public final static String chineseFullFormat = "yyyy��MM��dd�� HHʱmm��";
	public final static String chineseMDFormat = "MM��dd��";
	/**
	 * ���Ժʹ�����ڸ�ʽYYYY-MM-DD
	 */
	public final static String newFormat = "yyyy-MM-dd";
	public final static String zbFormat = "yyyy/MM/dd";
	public final static String tsfxFormat = "yyyy.MM.dd";
	public final static String noSecondFormat = "yyyy-MM-dd HH:mm";
	
	public final static String noYSFormat = "MM-dd HH:mm";

	public final static String datetimeFormat = "yyyy-MM-dd HH:mm:ss";
	
	public final static String sqlFormat = "yyyy/MM/dd HH:mm:ss";

	public final static long ONE_DAY_MILL_SECONDS = 86400000;
	private static final Logger logger = Logger.getLogger(DateUtil.class);

	/**
	 * ���һ�����ڵ�ȥ���ͬһʱ��
	 * 
	 * @param date ����
	 * @return
	 */
	public static Date getLastYear(Date date) {
		if (date == null) {
			return null;
		}

		int year = getYear(date);
		int month = getMonth(date);
		int day = getDayOfMonth(date);
		
		StringBuffer sb = new StringBuffer();
		sb.append(year-1).append("-").append(month).append("-").append(day);
		return parse(sb.toString(), webFormat);
	}
	
	public static String getLastYearByDate(Date date) {
		if (date == null) {
			return null;
		}

		int year = getYear(date);
		int month = getMonth(date);
		int day = getDayOfMonth(date);
		
		StringBuffer sb = new StringBuffer();
		sb.append(year-1).append("-").append(month).append("-").append(day);
		return sb.toString();
	}
	// -----------------------------------------------------------------------
	/**
	 * Adds to a date returning a new object. The original date object is
	 * unchanged.
	 * 
	 * @param date
	 *            the date, not null
	 * @param calendarField
	 *            the calendar field to add to
	 * @param amount
	 *            the amount to add, may be negative
	 * @return the new date object with the amount added
	 * @throws IllegalArgumentException
	 *             if the date is null
	 */
	public static Date add(Date date, int calendarField, int amount) {
		if (date == null) {
			throw new IllegalArgumentException("The date must not be null");
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(calendarField, amount);
		return c.getTime();
	}

	public static Date addYears(Date date, int amount) {
		return add(date, Calendar.YEAR, amount);
	}

	public static Date addMonths(Date date, int amount) {
		return add(date, Calendar.MONTH, amount);
	}

	public static Date addWeeks(Date date, int amount) {
		return add(date, Calendar.WEEK_OF_YEAR, amount);
	}

	public static Date addDays(Date date, int amount) {
		return add(date, Calendar.DAY_OF_MONTH, amount);
	}

	public static Date addHours(Date date, int amount) {
		return add(date, Calendar.HOUR_OF_DAY, amount);
	}

	/**
	 * ��׼�����
	 * 
	 * @param date
	 *            ���ڶ���
	 * @param format
	 *            ���������ʽ
	 * @return ����ָ����ʽ������ַ�
	 */
	public static String format(Date date, String format) {
		if (date == null) {
			return null;
		}

		return new SimpleDateFormat(format).format(date);
	}

	/**
	 * ���һ��ʱ��������
	 * 
	 * @param date
	 * @return
	 */
	public static int getYear(Date date) {
		if (date == null) {
			return -1;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.YEAR);
	}

	/**
	 * ���һ��ʱ����·���
	 * 
	 * @param date
	 * @return
	 */
	public static int getMonth(Date date) {
		if (date == null) {
			return -1;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.MONTH) + 1;
	}

	/**
	 * ���һ��ʱ����һ�����е�����
	 * 
	 * @param date
	 * @return
	 */
	public static int getDayOfMonth(Date date) {
		if (date == null) {
			return -1;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * ��׼�����
	 * 
	 * @param s_date
	 * @param format
	 * @return
	 */
	public static Date parse(String s_date, String format) {
		if (s_date == null)
			return null;
		try {
			return new SimpleDateFormat(format).parse(s_date);
		} catch (ParseException e) {

			logger.error("Wrong parse", e);
		}
		return null;
	}
	
	public static Timestamp getTime(String time) {
		if(time.equals("")) return null;
		Date outDate = parse(time, noSecondFormat);
		return new Timestamp(outDate.getTime());
	}

	/**
	 * ȡ���������ڼ����������1-����2��
	 * 
	 * @param one
	 *            ����1
	 * @param two
	 *            ����2
	 * 
	 * @return �������
	 */
	public static long getDiffSeconds(Date one, Date two) {
		Calendar sysDate = new GregorianCalendar();

		sysDate.setTime(one);

		Calendar failDate = new GregorianCalendar();

		failDate.setTime(two);
		return (sysDate.getTimeInMillis() - failDate.getTimeInMillis()) / 1000;
	}

	/**
	 * ȡ���������ڼ������������1-����2��
	 * 
	 * @param one
	 * @param two
	 * @return
	 */
	public static long getDiffMinutes(Date one, Date two) {
		Calendar sysDate = new GregorianCalendar();

		sysDate.setTime(one);

		Calendar failDate = new GregorianCalendar();

		failDate.setTime(two);
		return (sysDate.getTimeInMillis() - failDate.getTimeInMillis())
				/ (60 * 1000);
	}

	/**
	 * ȡ���������ڵļ������
	 * 
	 * @param one
	 * @param two
	 * 
	 * @return �������
	 */
	public static long getDiffDays(Date one, Date two) {
		Calendar sysDate = new GregorianCalendar();

		sysDate.setTime(one);

		Calendar failDate = new GregorianCalendar();

		failDate.setTime(two);
		return (sysDate.getTimeInMillis() - failDate.getTimeInMillis())
				/ (24 * 60 * 60 * 1000);
	}

	/**
	 * �ж��Ƿ�����ȷ�����ڸ�ʽ
	 * 
	 * @param str_date
	 *            �����ַ�
	 * @param format
	 *            ���ڸ�ʽ
	 * @return
	 */
	public static boolean isValidDateFormat(String strDate, String format) {
		// ��鳤��
		if (strDate.length() != format.length()) {
			return false;
		}

		// ����ʽ�Ƿ���ȷ
		DateFormat df = new SimpleDateFormat(format);
		df.setLenient(false);
		try {
			df.parse(strDate);
		} catch (ParseException e) {
			return false;
		}
		return true;
	}

	/**
	 * ��õ���Ŀ�ʼʱ��
	 * 
	 * @return
	 */
	public static Date today() {
		return parse(format(new Date(), webFormat), webFormat);
	}

	/**
	 * �Ƚ��������ڵ��Ⱥ��ϵ
	 * 
	 * @param one
	 *            ����1
	 * @param two
	 *            ����2
	 * @return 0 �� ��ʾ��� 1 �� one����two -1 �� two����one
	 */
	public static int compareDate(Date one, Date two) {
		// �Ϸ����ж�
		if (one == null && two != null)
			return -1;
		else if (one != null && two == null)
			return 1;
		else if (one == null && two == null)
			return 0;
		else {
			if (one.getTime() > two.getTime())
				return 1;
			if (one.getTime() == two.getTime())
				return 0;
			return -1;
		}
	}

	/**
	 * @param date
	 * @return
	 */
	public static String formatToFullChinese(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String sdate = sdf.format(date);
		String newsdate[] = new String[8];
		// ȫ��ת��Ϊ����
		for (int i = 0; i < sdate.length(); i++) {
			int k = Integer.parseInt(Character.toString(sdate.charAt(i)));
			switch (k) {
			case 0:
				newsdate[i] = "��";
				break;
			case 1:
				newsdate[i] = "һ";
				break;
			case 2:
				newsdate[i] = "��";
				break;
			case 3:
				newsdate[i] = "��";
				break;
			case 4:
				newsdate[i] = "��";
				break;
			case 5:
				newsdate[i] = "��";
				break;
			case 6:
				newsdate[i] = "��";
				break;
			case 7:
				newsdate[i] = "��";
				break;
			case 8:
				newsdate[i] = "��";
				break;
			case 9:
				newsdate[i] = "��";
				break;
			}
		}
		// ����������
		List<String> s1 = new ArrayList<String>();
		for (int i = 0; i < 8; i++) {
			if (i < 4) {
				s1.add(newsdate[i]);
			} else if (i == 4) {
				s1.add("��");
				s1.add(newsdate[i]);
			} else if (i == 5) {
				s1.add(newsdate[i]);
			} else if (i == 6) {
				s1.add("��");
				s1.add(newsdate[i]);
			} else if (i == 7) {
				s1.add(newsdate[i]);
				s1.add("��");
			}

		}

		String newstr = "";
		for (String s : s1) {
			newstr += s;
		}
		/*
		 * ��ȡ�·ݡ�����
		 */
		int i = newstr.indexOf("��");
		int j = newstr.indexOf("��");
		String month = newstr.substring(i + 1, j);
		String day = newstr.substring(j + 1, newstr.length() - 1);
		/*
		 * �����·�
		 */
		String str1 = month.substring(0, 1);
		String str2 = month.substring(1);
		String newmonth = "";
		if ("��".equals(str1)) {
			newmonth = str2;
		} else if ("һ".equals(str1) && "��".equals(str2)) {
			newmonth = "ʮ";
		} else if ("һ".equals(str1) && !"��".equals(str2)) {
			newmonth = "ʮ" + str2;
		}

		/*
		 * ��������
		 */
		String st1 = day.substring(0, 1);
		String st2 = day.substring(1);
		String newday = "";
		if ("��".equals(st1)) {
			newday = st2;
		} else if ("һ".equals(st1) && "��".equals(st2)) {
			newday = "ʮ";
		} else if ("һ".equals(st1) && !"��".equals(st2)) {
			newday = "ʮ" + st2;
		} else if ("��".equals(st1) && "��".equals(st2)) {
			newday = st1 + "ʮ";
		} else if ("��".equals(st1) && !"��".equals(st2)) {
			newday = st1 + "ʮ" + st2;
		} else if ("��".equals(st1) && "��".equals(st2)) {
			newday = st1 + "ʮ";
		} else if ("��".equals(st1) && !"��".equals(st2)) {
			newday = st1 + "ʮ" + st2;
		}
		String newstring = newstr.substring(0, i) + "��" + newmonth + "��"
				+ newday + "��";
		return newstring;
	}
}