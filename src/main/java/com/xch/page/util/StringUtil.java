package com.xch.page.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
	/**
	 * 检验字符串是否是大于0的数字
	 * @param string
	 * @return
	 */
	public static boolean isNum(String string){
		//第一位是1-9的数字，其余都是随意数字
		Pattern pattern = Pattern.compile("[1-9]{1}\\d*");
		Matcher matcher = pattern.matcher(string);
		return matcher.matches();
	}

}
