package vendingmachine.domain;

public class Menu {

	private static final String ERROR_SQUARE_BRACKETS = "[ERROR] 대괄호 사이에 상품정보를 입력해야 합니다.";
	private static final String ERROR_DELIMITERS = "[ERROR] 상품 정보는 [상품명,가격,수량] 형태로 입력해야 합니다.";

	private static final String DELIMITER = ",";

	private String name;
	private int price;
	private int count;

	public Menu(String name, int price, int count) {
		this.name = name;
		this.price = price;
		this.count = count;
	}

	public static Menu from(String menuInfo) {
		parseMenuInfo(menuInfo);
		return null;
	}

	private static void parseMenuInfo(String menuInfo) {
		menuInfo = removeBrackets(menuInfo);
		String[] infoArray = splitMenuInfo(menuInfo);
	}

	private static String removeBrackets(String menuInfo) {
		validateBrackets(menuInfo);
		return menuInfo.substring(1, menuInfo.length() - 1);
	}

	private static void validateBrackets(String menuInfo) {
		if (!menuInfo.matches("\\[.*\\]")) {
			throw new IllegalArgumentException(ERROR_SQUARE_BRACKETS);
		}
	}

	private static String[] splitMenuInfo(String menuInfo) {
		validateDelimiters(menuInfo);
		return menuInfo.split(DELIMITER);
	}

	private static void validateDelimiters(String menuInfo) {
		if (!menuInfo.matches(".+[,(.*)]{2}")) {
			// regex: 공백이 아닌 문자열 & 콤마 정확히 두 개
			throw new IllegalArgumentException(ERROR_DELIMITERS);
		}
	}
}
