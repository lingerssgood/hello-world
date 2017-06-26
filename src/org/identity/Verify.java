package org.identity;

public class Verify {

	public static void main(String[] args) {
		// 数据一
		System.out.println(transIDCard15to18("370986890623212"));
		// 数据二
		System.out.println(transIDCard15to18("370725881105149"));
	}

	private static String transIDCard15to18(String idCardNo) {
		String cardNo = null;
		if (idCardNo != null & idCardNo.trim().length() == 15) {
			idCardNo = idCardNo.trim();
			StringBuffer sb = new StringBuffer(idCardNo);
			sb.insert(6, "19");
			sb.append(transIDCardLastNo(sb.toString()));
			cardNo = sb.toString();
		}
		return cardNo;
	}

	private static Object transIDCardLastNo(String newCardId) {
		char[] ch = newCardId.toCharArray();
		int m = 0;
		int[] co = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };
		char[] verCode = new char[] { '1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2' };
		for(int i=0;i<newCardId.length();i++){
			m+=(ch[i]-'0')*co[i];
		}
		int reside=m%11;
		return String.valueOf(verCode[reside]);
	}

}
