package vendingmachine.domain.menu;

import static vendingmachine.utils.ArithmeticValidator.*;
import static vendingmachine.utils.StringValidator.*;

public class Menu {

	private static final String ERROR_SQUARE_BRACKETS = "[ERROR] 대괄호 사이에 상품정보를 입력해야 합니다.";
	private static final String ERROR_DELIMITERS = "[ERROR] 상품 정보는 [상품명,가격,수량] 형태로 입력해야 합니다.";

	private static final String ERROR_PRICE_NUMBER = "[ERROR] 상품 가격은 정수입니다.";
	private static final String ERROR_LESS_THAN_MIN_PRICE = "[ERROR] 상품 가격은 100원 이상입니다.";
	private static final String ERROR_PRICE_NOT_DIVISIBLE_BY_MIN_PRICE_COIN =
		"[ERROR] 상품 가격은 10원으로 나누어 떨어져야 합니다.";

	private static final String ERROR_COUNT_NUMBER = "[ERROR] 상품 수량은 정수입니다.";

	private static final String DELIMITER = ",";
	private static final int NAME_INDEX = 0;
	private static final int PRICE_INDEX = 1;
	private static final int COUNT_INDEX = 2;

	private static final int MIN_MENU_PRICE = 100;

	private String name;
	private int price;
	private int count;

	public Menu(String name, int price, int count) {
		this.name = name;
		this.price = price;
		this.count = count;
	}

	public static Menu from(String menuInfo) {
		String[] infoArray = parseMenuInfo(menuInfo);

		String name = infoArray[NAME_INDEX];
		int price = Integer.parseInt(infoArray[PRICE_INDEX]);
		int count = Integer.parseInt(infoArray[COUNT_INDEX]);

		return new Menu(name, price, count);
	}

	private static String[] parseMenuInfo(String menuInfo) {
		menuInfo = removeBrackets(menuInfo);
		String[] infoArray = splitMenuInfo(menuInfo);

		validateName(infoArray[NAME_INDEX]);
		validatePrice(infoArray[PRICE_INDEX]);
		validateCount(infoArray[COUNT_INDEX]);

		return infoArray;
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
		if (!menuInfo.matches("[^,]+,[^,]+,[^,]+")) {
			throw new IllegalArgumentException(ERROR_DELIMITERS);
		}
	}

	private static void validateName(String name) {
		// 메뉴명은 공백만 아니면 특별한 제한을 두지 않는다.
	}

	private static void validatePrice(String price) {
		validateNumber(price, ERROR_PRICE_NUMBER);
		validateMinPrice(price);
		validateDividingByMinPriceCoin(price, ERROR_PRICE_NOT_DIVISIBLE_BY_MIN_PRICE_COIN);
	}

	private static void validateCount(String count) {
		validateNumber(count, ERROR_COUNT_NUMBER);
	}

	private static void validateMinPrice(String price) {
		if (!isGreaterThanOrEqualToMinMenuPrice(price)) {
			throw new IllegalArgumentException(ERROR_LESS_THAN_MIN_PRICE);
		}
	}

	private static boolean isGreaterThanOrEqualToMinMenuPrice(String price) {
		return Integer.parseInt(price) >= MIN_MENU_PRICE;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getCount() {
		return count;
	}

	public void sold() {
		if (isSoldOut()) {
			throw new IllegalArgumentException("[ERROR] 품절 상품입니다.");
		}
		count--;
	}

	public boolean isSoldOut() {
		return count == 0;
	}
}
