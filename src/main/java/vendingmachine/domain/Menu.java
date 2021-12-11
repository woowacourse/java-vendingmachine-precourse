package vendingmachine.domain;

public class Menu {
	private static final String ERROR_SQUARE_BRACKETS = "[ERROR] 대괄호 사이에 메뉴정보를 입력해야 합니다.";

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
}
