package com.retail.rewards.util;

public class StringUtil {

	public static String getMaskedData(String strData) {
		String strMaskedData = strData;
		char ch = 'X';
		if (!strData.isEmpty()) {
			StringBuilder sbMaskedData = new StringBuilder(strData);
			char[] arrData = strData.toCharArray();
			for (int nIndex = 0; nIndex < arrData.length-3; nIndex++) {
				sbMaskedData.setCharAt(nIndex, ch);
			}
			strMaskedData = sbMaskedData.toString();
		}
		return strMaskedData;
	}

}
