package vendingmachine;

import java.util.regex.Pattern;


public class Validater {
	static String errorMassage;
	static String[] beveragesValid(String readString) {
		isBracket(readString);
		readString = readString.replaceAll("\\[", "");
		readString = readString.replaceAll("\\]", "");

		isMatchRegex(readString);

		String[] beverageInfo = readString.split(",");
		isDivideTen(beverageInfo[1]);
		isZeroCheck(beverageInfo[2]);

		return beverageInfo;
	}

	// ; 유무 체크
	public static void isSemicolon(String goodsInput) {
		if (!goodsInput.matches("[[a-zA-Z0-9가-힣];+]")) {
			errorMassage ="[ERROR] 옳바른 입력값이 아닙니다.";
			throw new IllegalArgumentException("[ERROR] 옳바른 입력값이 아닙니다.");
			
		}
	}

	// [] 유무체크
	public static void isBracket(String readString) {
		if (readString.charAt(0) != '[' || readString.charAt(readString.length() - 1) != ']') {
			errorMassage ="[ERROR] 옳바른 입력값이 아닙니다.";
			throw new IllegalArgumentException("[ERROR] 옳바른 값을 입력해 주세요.");
		}
	}

	// 상품 입력 체크
	public static void isMatchRegex(String removedString) {
		if (!Pattern.matches("[a-zA-Z0-9가-힣]+,\\d{3,}+,\\d+", removedString)) {
			errorMassage ="[ERROR] 옳바른 입력값이 아닙니다.";
			throw new IllegalArgumentException("[ERROR] 옳바른 값을 입력해 주세요.");
		}
	}

	// 10으로 나눠지는지 체크
	public static void isDivideTen(String price) {
		if (!(Integer.parseInt(price)%10 == 0)) {
			errorMassage ="[ERROR] 옳바른 입력값이 아닙니다.";
			throw new IllegalArgumentException("[ERROR] 옳바른 값을 입력해 주세요.");
		}
	}

	// 0 보다 큰지 체크
	public static void isZeroCheck(String notZero) {
		if (Integer.parseInt(notZero) <= 0) {
			errorMassage ="[ERROR] 옳바른 입력값이 아닙니다.";
			throw new IllegalArgumentException("[ERROR] 옳바른 값을 입력해 주세요.");
		}
	}

	// 숫자인지 체크
	public static void isNumberCheck(String number) {
		if (!number.chars().allMatch(Character::isDigit)) {
			errorMassage ="[ERROR] 옳바른 입력값이 아닙니다.";
			throw new IllegalArgumentException("[ERROR] 금액은 숫자여야 합니다.");
		}
	}




}
