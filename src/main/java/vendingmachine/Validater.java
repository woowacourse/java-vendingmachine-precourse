package vendingmachine;

import java.util.regex.Pattern;

public class BeverageValidter {

		
		static String[]  readValidter(String readString) {
			isBracket(readString);
			readString = readString.replaceAll("\\[","");
			readString = readString.replaceAll("\\]","");
		
			isMatchRegex(readString);
			
			String[] beverageInfo = readString.split(",");
			isDivideTen(beverageInfo[1]);
			isZeroCheck(beverageInfo[2]);
			
			return beverageInfo;
		}

		private static void isBracket(String readString) {
			if(readString.charAt(0) != '[' || readString.charAt(readString.length() - 1) != ']') {
				throw new IllegalArgumentException("옳바른 값을 입력해 주세요.");
			}
		}

		private static void isMatchRegex(String removedString) {
			if (!Pattern.matches("[a-zA-Z0-9가-힣]+,\\d{3,}+,\\d+", removedString)) {
				throw new IllegalArgumentException("옳바른 값을 입력해 주세요.");
			}
		}
		private static void isDivideTen(String price) {
			if(Integer.parseInt(price)%10 ==0) {
				throw new IllegalArgumentException("옳바른 값을 입력해 주세요.");
			}
		}
		private static void isZeroCheck(String count) {
			if(Integer.parseInt(count) <=0) {
				throw new IllegalArgumentException("옳바른 값을 입력해 주세요.");
			}
		}
			
}

