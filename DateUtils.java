package test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	/**
	 * 将格式转换为字符串格式'yyyy-MM-dd HH:mm:ss'(24小时制)
	 * 
	 * @param time日期
	 * @return String 字符串
	 */
	public static String dateToString(Date time) {
		SimpleDateFormat formatter;
		formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String ctime = formatter.format(time);
		return ctime;
	}

	/**
	 * 将格式转换为字符串格式'yyyy-MM-dd HH:mm:ss a'(12小时制)
	 * 
	 * @param time
	 *            日期
	 * @param 任意整数如
	 *            ：1
	 * @return String 字符串
	 */
	public static String dateToString(Date time, int x) {
		SimpleDateFormat formatter;
		formatter = new SimpleDateFormat("yyyy-MM-dd KK:mm:ss a");
		String ctime = formatter.format(time);
		return ctime;
	}

	/**
	 * 将返回自定义格式的日期
	 * 
	 * @param time
	 * @param dateFormatter
	 * @return
	 */
	public static String dateToString(Date time, String dateFormatter) {
		SimpleDateFormat formatter;
		formatter = new SimpleDateFormat(dateFormatter);
		String ctime = formatter.format(time);
		return ctime;
	}

	public static String getHour(Date time) {
		SimpleDateFormat formatter;
		formatter = new SimpleDateFormat("H");
		String ctime = formatter.format(time);
		return ctime;
	}

	public static String getDay(Date time) {
		SimpleDateFormat formatter;
		formatter = new SimpleDateFormat("d");
		String ctime = formatter.format(time);
		return ctime;
	}

	public static String getMonth(Date time) {
		SimpleDateFormat formatter;
		formatter = new SimpleDateFormat("M");
		String ctime = formatter.format(time);
		return ctime;
	}

	public static String getYear(Date time) {
		SimpleDateFormat formatter;
		formatter = new SimpleDateFormat("yyyy");
		String ctime = formatter.format(time);
		return ctime;
	}

	public static String getWeek(Date time) {
		SimpleDateFormat formatter;
		formatter = new SimpleDateFormat("E");
		String ctime = formatter.format(time);
		return ctime;
	}

	public static String getAmOrPm(Date time) {
		SimpleDateFormat formatter;
		formatter = new SimpleDateFormat("a");
		String ctime = formatter.format(time);
		return ctime;
	}

	public static String getAmOrPmChinese(Date time) {
		SimpleDateFormat formatter;
		formatter = new SimpleDateFormat("a");
		String ctime = formatter.format(time);
		if (ctime != null && "AM".equals(ctime)) {
			return "上午";
		}
		if (ctime != null && "PM".equals(ctime)) {
			return "下午";
		}
		return ctime;
	}

	/**
	 * 返回2012年11月1 日下午16点30分格式
	 * 
	 * @param date
	 * @return
	 */
	public static String getDateToChineseUnit(Date date) {
		StringBuilder sb = new StringBuilder(200);
		sb.append(DateUtils.dateToString(date, "yyyy年MM月dd日"));
		sb.append(DateUtils.getAmOrPmChinese(date));
		sb.append(DateUtils.dateToString(date, "hh点mm分"));
		return sb.toString();
	}

	/**
	 * 将日期yyyy-MM-dd转换为指定格式字符串
	 * 
	 * @param date
	 *            日期
	 * @return
	 */
	public static String getDateStr(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String datestr = sdf.format(date);
		return datestr;
	}

	/**
	 * 取出日期字符串中的年份字符串
	 * 
	 * @param str
	 *            日期字符串
	 * @return
	 */
	public static String getYearStr(String str) {
		String yearStr = "";
		yearStr = str.substring(0, 4);
		return yearStr;
	}

	/**
	 * 取出日期字符串中的月份字符串
	 * 
	 * @param str
	 *            日期字符串
	 * @return
	 */
	public static String getMonthStr(String str) {
		String monthStr;
		int startIndex = str.indexOf("年");
		int endIndex = str.indexOf("月");
		monthStr = str.substring(startIndex + 1, endIndex);
		return monthStr;
	}

	/**
	 * 将源字符串中的阿拉伯数字格式化为汉字
	 * 
	 * @param sign
	 *            源字符串中的字符
	 * @return
	 */
	public static char formatDigit(char sign) {
		if (sign == '0')
			sign = '0';
		if (sign == '1')
			sign = '一';
		if (sign == '2')
			sign = '二';
		if (sign == '3')
			sign = '三';
		if (sign == '4')
			sign = '四';
		if (sign == '5')
			sign = '五';
		if (sign == '6')
			sign = '六';
		if (sign == '7')
			sign = '七';
		if (sign == '8')
			sign = '八';
		if (sign == '9')
			sign = '九';
		return sign;
	}

	/**
	 * 获得月份字符串的长度
	 * 
	 * @param str
	 *            待转换的源字符串
	 * @param pos1
	 *            第一个'-'的位置
	 * @param pos2
	 *            第二个'-'的位置
	 * @return
	 */
	public static int getMidLen(String str, int pos1, int pos2) {
		return str.substring(pos1 + 1, pos2).length();
	}

	/**
	 * 获得日期字符串的长度
	 * 
	 * @param str
	 *            待转换的源字符串
	 * @param pos2
	 *            第二个'-'的位置
	 * @return
	 */
	public static int getLastLen(String str, int pos2) {
		return str.substring(pos2 + 1).length();
	}

	/**
	 * 取出日期字符串中的日字符串
	 * 
	 * @param str
	 *            日期字符串
	 * @return
	 */
	public static String getDayStr(String str) {
		String dayStr = "";
		int startIndex = str.indexOf("月");
		int endIndex = str.indexOf("日");
		dayStr = str.substring(startIndex + 1, endIndex);
		return dayStr;
	}

	/**
	 * yyyy-MM-dd格式化日期转换全中文
	 * 
	 * @param str
	 *            源字符串中的字符
	 * @return
	 */
	public static String dateToChinese(String str) {
		StringBuffer sb = new StringBuffer();
		int pos1 = str.indexOf("-");
		int pos2 = str.lastIndexOf("-");
		for (int i = 0; i < 4; i++) {
			sb.append(formatDigit(str.charAt(i)));
		}
		sb.append('年');
		if (getMidLen(str, pos1, pos2) == 1) {
			sb.append(formatDigit(str.charAt(5)) + "月");
			if (str.charAt(7) != '0') {
				if (getLastLen(str, pos2) == 1) {
					sb.append(formatDigit(str.charAt(7)) + "日");
				}
				if (getLastLen(str, pos2) == 2) {
					if (str.charAt(7) != '1' && str.charAt(8) != '0') {
						sb.append(formatDigit(str.charAt(7)) + "十" + formatDigit(str.charAt(8)) + "日");
					} else if (str.charAt(7) != '1' && str.charAt(8) == '0') {
						sb.append(formatDigit(str.charAt(7)) + "十日");
					} else if (str.charAt(7) == '1' && str.charAt(8) != '0') {
						sb.append("十" + formatDigit(str.charAt(8)) + "日");
					} else {
						sb.append("十日");
					}
				}
			} else {
				sb.append(formatDigit(str.charAt(8)) + "日");
			}
		}
		if (getMidLen(str, pos1, pos2) == 2) {
			if (str.charAt(5) != '0' && str.charAt(6) != '0') {
				sb.append("十" + formatDigit(str.charAt(6)) + "月");
				if (getLastLen(str, pos2) == 1) {
					sb.append(formatDigit(str.charAt(8)) + "日");
				}
				if (getLastLen(str, pos2) == 2) {
					if (str.charAt(8) != '0') {
						if (str.charAt(8) != '1' && str.charAt(9) != '0') {
							sb.append(formatDigit(str.charAt(8)) + "十" + formatDigit(str.charAt(9)) + "日");
						} else if (str.charAt(8) != '1' && str.charAt(9) == '0') {
							sb.append(formatDigit(str.charAt(8)) + "十日");
						} else if (str.charAt(8) == '1' && str.charAt(9) != '0') {
							sb.append("十" + formatDigit(str.charAt(9)) + "日");
						} else {
							sb.append("十日");
						}
					} else {
						sb.append(formatDigit(str.charAt(9)) + "日");
					}
				}
			} else if (str.charAt(5) != '0' && str.charAt(6) == '0') {
				sb.append("十月");
				if (getLastLen(str, pos2) == 1) {
					sb.append(formatDigit(str.charAt(8)) + "日");
				}
				if (getLastLen(str, pos2) == 2) {
					if (str.charAt(8) != '0') {
						if (str.charAt(8) != '1' && str.charAt(9) != '0') {
							sb.append(formatDigit(str.charAt(8)) + "十" + formatDigit(str.charAt(9)) + "日");
						} else if (str.charAt(8) != '1' && str.charAt(9) == '0') {
							sb.append(formatDigit(str.charAt(8)) + "十日");
						} else if (str.charAt(8) == '1' && str.charAt(9) != '0') {
							sb.append("十" + formatDigit(str.charAt(9)) + "日");
						} else {
							sb.append("十日");
						}
					} else {
						sb.append(formatDigit(str.charAt(9)) + "日");
					}
				}
			} else {
				sb.append(formatDigit(str.charAt(6)) + "月");
				if (getLastLen(str, pos2) == 1) {
					sb.append(formatDigit(str.charAt(8)) + "日");
				}
				if (getLastLen(str, pos2) == 2) {
					if (str.charAt(8) != '0') {
						if (str.charAt(8) != '1' && str.charAt(9) != '0') {
							sb.append(formatDigit(str.charAt(8)) + "十" + formatDigit(str.charAt(9)) + "日");
						} else if (str.charAt(8) != '1' && str.charAt(9) == '0') {
							sb.append(formatDigit(str.charAt(8)) + "十日");
						} else if (str.charAt(8) == '1' && str.charAt(9) != '0') {
							sb.append("十" + formatDigit(str.charAt(9)) + "日");
						} else {
							sb.append("十日");
						}
					} else {
						sb.append(formatDigit(str.charAt(9)) + "日");
					}
				}
			}
		}
		return sb.toString();
	}

	/**
	 * Java Calender类获得指定yyyy-MM-dd格式日期的前i天
	 * 
	 * @param specifiedDay
	 * @param i
	 * @return
	 * @throws Exception
	 */
	public static String getSpecifiedDayBefore(String specifiedDay, int i) {
		// SimpleDateFormat simpleDateFormat = new
		// SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		Date date = null;
		try {
			date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day - i);

		String dayBefore = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
		return dayBefore;
	}

	/**
	 * yyyy-MM-dd Calender类获得指定日期的后i天
	 * 
	 * @param specifiedDay
	 * @param i
	 * @return
	 */
	public static String getSpecifiedDayAfter(String specifiedDay, int i) {
		Calendar c = Calendar.getInstance();
		Date date = null;
		try {
			date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day + i);

		String dayAfter = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
		return dayAfter;
	}

	/**
	 * 判断用户输入的数据是否合法，用户只能输入大于零的数字，不能输入其它字符
	 * 
	 * @param s
	 *            String
	 * @return 如果用户输入数据合法，返回 true，否则返回 false
	 */
	private static boolean checkNum(String s) {
		// 如果用户输入的数里有非数字字符，则视为非法数据，返回 false
		try {
			float f = Float.valueOf(s);
			// 如果这个数小于零则视为非法数据，返回 false
			if (f < 0) {
				System.out.println("非法数据，请检查！");
				return false;
			} else {
				return true;
			}
		} catch (NumberFormatException e) {
			System.out.println("非法数据，请检查！");
			return false;
		}
	}

	/**
	 * 把用户输入的数以小数点为界分割开来，并调用 numFormat() 方法 进行相应的中文金额大写形式的转换 注：传入的这个数应该是经过
	 * roundString() 方法进行了四舍五入操作的
	 * 
	 * @param s
	 *            String
	 * @return 转换好的中文金额大写形式的字符串
	 */
	private static String splitNum(String s) {
		// 如果传入的是空串则继续返回空串
		if ("".equals(s)) {
			return "";
		}
		// 以小数点为界分割这个字符串
		int index = s.indexOf(".");
		// 截取并转换这个数的整数部分
		String intOnly = s.substring(0, index);
		String part1 = numFormat(1, intOnly);
		// 截取并转换这个数的小数部分
		String smallOnly = s.substring(index + 1);
		String part2 = numFormat(2, smallOnly);
		// 把转换好了的整数部分和小数部分重新拼凑一个新的字符串
		String newS = part1 + part2;
		return newS;
	}

	/**
	 * 对传入的数进行四舍五入操作
	 * 
	 * @param s
	 *            String 从命令行输入的那个数
	 * @return 四舍五入后的新值
	 */
	private static String roundString(String s) {
		// 如果传入的是空串则继续返回空串
		if ("".equals(s)) {
			return "";
		}
		// 将这个数转换成 double 类型，并对其进行四舍五入操作
		double d = Double.parseDouble(s);
		// 此操作作用在小数点后两位上
		d = (d * 100 + 0.5) / 100;
		// 将 d 进行格式化
		s = new java.text.DecimalFormat("##0.000").format(d);
		// 以小数点为界分割这个字符串
		int index = s.indexOf(".");
		// 这个数的整数部分
		String intOnly = s.substring(0, index);
		// 规定数值的最大长度只能到万亿单位，否则返回 "0"
		if (intOnly.length() > 13) {
			System.out.println("输入数据过大！（整数部分最多13位！）");
			return "";
		}
		// 这个数的小数部分
		String smallOnly = s.substring(index + 1);
		// 如果小数部分大于两位，只截取小数点后两位
		if (smallOnly.length() > 2) {
			String roundSmall = smallOnly.substring(0, 2);
			// 把整数部分和新截取的小数部分重新拼凑这个字符串
			s = intOnly + "." + roundSmall;
		}
		return s;
	}

	/**
	 * 把传入的数转换为中文金额大写形式
	 * 
	 * @param flag
	 *            int 标志位，1 表示转换整数部分，0 表示转换小数部分
	 * @param s
	 *            String 要转换的字符串
	 * @return 转换好的带单位的中文金额大写形式
	 */
	private static String numFormat(int flag, String s) {
		int sLength = s.length();
		// 货币大写形式
		String bigLetter[] = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
		// 货币单位
		String unit[] = { "元", "拾", "佰", "仟", "万",
				// 拾万位到仟万位
				"拾", "佰", "仟",
				// 亿位到万亿位
				"亿", "拾", "佰", "仟", "万" };
		String small[] = { "分", "角" };
		// 用来存放转换后的新字符串
		String newS = "";
		// 逐位替换为中文大写形式
		for (int i = 0; i < sLength; i++) {
			if (flag == 1) {
				// 转换整数部分为中文大写形式（带单位）
				newS = newS + bigLetter[s.charAt(i) - 48] + unit[sLength - i - 1];
			} else if (flag == 2) {
				// 转换小数部分（带单位）
				newS = newS + bigLetter[s.charAt(i) - 48] + small[sLength - i - 1];
			}
		}
		return newS;
	}

	/**
	 * 把已经转换好的中文金额大写形式加以改进，清理这个字 符串里面多余的零，让这个字符串变得更加可观 注：传入的这个数应该是经过 splitNum()
	 * 方法进行处理，这个字 符串应该已经是用中文金额大写形式表示的
	 * 
	 * @param s
	 *            String 已经转换好的字符串
	 * @return 改进后的字符串
	 */
	private static String cleanZero(String s) {
		// 如果传入的是空串则继续返回空串
		if ("".equals(s)) {
			return "";
		}
		// 如果用户开始输入了很多 0 去掉字符串前面多余的'零'，使其看上去更符合习惯
		while (s.charAt(0) == '零') {
			// 将字符串中的 "零" 和它对应的单位去掉
			s = s.substring(2);
			// 如果用户当初输入的时候只输入了 0，则只返回一个 "零"
			if (s.length() == 0) {
				return "零";
			}
		}
		// 字符串中存在多个'零'在一起的时候只读出一个'零'，并省略多余的单位
		/* 由于本人对算法的研究太菜了，只能用4个正则表达式去转换了，各位大虾别介意哈... */
		String regex1[] = { "零仟", "零佰", "零拾" };
		String regex2[] = { "零亿", "零万", "零元" };
		String regex3[] = { "亿", "万", "元" };
		String regex4[] = { "零角", "零分" };
		// 第一轮转换把 "零仟", 零佰","零拾"等字符串替换成一个"零"
		for (int i = 0; i < 3; i++) {
			s = s.replaceAll(regex1[i], "零");
		}
		// 第二轮转换考虑 "零亿","零万","零元"等情况
		// "亿","万","元"这些单位有些情况是不能省的，需要保留下来
		for (int i = 0; i < 3; i++) {
			// 当第一轮转换过后有可能有很多个零叠在一起
			// 要把很多个重复的零变成一个零
			s = s.replaceAll("零零零", "零");
			s = s.replaceAll("零零", "零");
			s = s.replaceAll(regex2[i], regex3[i]);
		}
		// 第三轮转换把"零角","零分"字符串省略
		for (int i = 0; i < 2; i++) {
			s = s.replaceAll(regex4[i], "");
		}
		// 当"万"到"亿"之间全部是"零"的时候，忽略"亿万"单位，只保留一个"亿"
		s = s.replaceAll("亿万", "亿");
		return s;
	}

	/**
	 * 返回中文金额（最大只能输入整数13位，加小数2位）
	 * 
	 * @param money
	 *            （最大只能输入整数13位，加小数2位）
	 * @return
	 */
	public static String moneyChangeRMB(String money) {
		if (checkNum(money)) {
			return cleanZero(splitNum(roundString(money)));
		} else {
			return money;
		}
	}

	/**
	 * 计算两个日期相差的年月日 返回格式:9年7月3天
	 * 
	 * @param startDate
	 * @param endDate
	 * @throws ParseException
	 */
	public static String compareYMD(Date startDate, Date endDate) {
		if (startDate == null || endDate == null)
			return null;
		if (endDate.before(startDate)) {
			throw new RuntimeException("开始日期必须早于结束日期！");
		}
		Calendar srcCal = Calendar.getInstance();
		srcCal.setTime(startDate);
		Calendar dstCal = Calendar.getInstance();
		dstCal.setTime(endDate);
		dstCal.add(Calendar.DAY_OF_MONTH, 1);// 因为结束时间是23点59分59秒,所以结束时间要加一天

		// 比较年月日
		int year = dstCal.get(Calendar.YEAR) - srcCal.get(Calendar.YEAR);
		int month = dstCal.get(Calendar.MONTH) - srcCal.get(Calendar.MONTH);
		int day = dstCal.get(Calendar.DAY_OF_MONTH) - srcCal.get(Calendar.DAY_OF_MONTH);
		// 实际年份差：
		year = year - ((month > 0) ? 0 : ((month < 0) ? 1 : ((day >= 0 ? 0 : 1))));
		// 实际月份差：
		month = (day < 0) ? (month > 0 ? month - 1 : 12 + month - 1) : (month < 0 ? 12 + month : month);

		// 实际天数差：
		if (day < 0) {
			day = perMonthDays(endDate) + day;
		}
		String result = "";
		if (year > 0) {
			result += year + "年";
		}
		if (month > 0) {
			result += month + "月";
		}
		if (day > 0) {
			result += day + "日";
		}
		return result;
	}

	/**
	 * 判断一个日期所在月有多少天
	 * 
	 * @param Calendar
	 *            具体时间的日历对象
	 * @throws ParseException
	 */
	private static int perMonthDays(Date srcCal) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(srcCal);
		int maxDays = 0;
		int month = cal.get(Calendar.MONTH);
		switch (month) {
		case Calendar.JANUARY:
		case Calendar.MARCH:
		case Calendar.MAY:
		case Calendar.JULY:
		case Calendar.AUGUST:
		case Calendar.OCTOBER:
		case Calendar.DECEMBER:
			maxDays = 31;
			break;
		case Calendar.APRIL:
		case Calendar.JUNE:
		case Calendar.SEPTEMBER:
		case Calendar.NOVEMBER:
			maxDays = 30;
			break;
		case Calendar.FEBRUARY:
			if (isLeap(cal.get(Calendar.YEAR))) {
				maxDays = 29;
			} else {
				maxDays = 28;
			}
			break;
		}
		return maxDays;
	}

	/**
	 * 判断某年是否是闰年
	 * 
	 * @param year
	 *            年份
	 * @throws ParseException
	 */
	public static boolean isLeap(int year) {
		boolean leap = false;
		if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
			leap = true;
		}
		return leap;
	}

	/**
	 * 计算年限 修改时保证和立项页面年限算法相同 by gxy
	 * 
	 * @param beginDate
	 *            开始日期
	 * @param endDate
	 *            结束日期
	 * @return 年限小数
	 */
	public static BigDecimal monthGapNumber(Date beginDate, Date endDate) {
		String usefulLife = DateUtils.compareYMD(beginDate, endDate);
		if (usefulLife == null || usefulLife == "")
			return null;
		double year = 0, month = 0, day = 0;
		if (usefulLife.indexOf("年") != -1) {
			year = Double.valueOf(usefulLife.substring(0, usefulLife.indexOf("年")));
			usefulLife = usefulLife.substring(usefulLife.indexOf("年") + 1);
		}
		if (usefulLife.indexOf("月") != -1) {
			month = Double.valueOf(usefulLife.substring(0, usefulLife.indexOf("月")));
			usefulLife = usefulLife.substring(usefulLife.indexOf("月") + 1);
		}
		if (usefulLife.indexOf("日") != -1) {
			day = Double.valueOf(usefulLife.substring(0, usefulLife.indexOf("日")));
		}
		int days = perMonthDays(endDate);
		return new BigDecimal(year + (month / 12) + (day / days / 12)).setScale(7, BigDecimal.ROUND_HALF_DOWN);
	}

}
