package vendingmachine.service.exception;

import java.util.List;

import vendingmachine.domain.Catalog;
import vendingmachine.repository.UserAccount;

public class InputExceptionService {
	private static final int MONEY_MINIMUM_UNIT = 10;
	private static final int NUMBER_OF_CATALOG_MEMBER_VARIABLES = 3;
	private static final int CATALOG_MINIMUM_PRICE = 100;
	private static final String SEMI_COLON = ";";
	private static final String NOT_MONEY_ERROR_MESSAGE = "돈을 입력하려면 10으로 나누어 떨어지는 0 이상의 정수여야 합니다.";
	private static final String NEGATIVE_NUMBER_ERROR_MESSAGE = "0 이상의 정수여야 합니다.";
	private static final String NOT_INTEGER_ERROR_MESSAGE = "정수로 입력 받아야 할 특정 값을 정수로 변환하는 데 실패했습니다.";
	private static final String BLANK_STRING_ERROR_MESSAGE = "빈 입력이 포함되었는지 확인하십시오.";
	private static final String CATALOG_INPUT_ERROR_MESSAGE = "각 상품은 [상품명,가격,수량] 형식으로 입력되어야 하고, 각 상품은 ';' 로 구분되어야 합니다.";
	private static final String CATALOG_DUPLICATE_ERROR_MESSAGE = "중복되는 상품명이 포함되어 있습니다.";
	private static final String CATALOG_MINIMUM_PRICE_ERROR_MESSAGE = "상품 가격은 최소 100원 이상이어야 합니다";
	private static final String NO_SUCH_CATALOG = "존재하지 않는 상품명 입니다.";
	private static final String NOT_ENOUGH_MONEY = "상품을 살 돈이 부족합니다.";
	private static final String NOT_ENOUGH_CATALOG = "상품의 개수가 부족합니다.";
	private static final String BRACED_FORMAT = "\\[(.*)]";

	public static void checkZeroOrPositiveInt(int input) {
		if (input < 0) {
			throw new IllegalArgumentException(NEGATIVE_NUMBER_ERROR_MESSAGE);
		}
	}

	public static void checkModTen(int input) {
		if (input % MONEY_MINIMUM_UNIT != 0) {
			throw new IllegalArgumentException(NOT_MONEY_ERROR_MESSAGE);
		}
	}

	public static int parseToInt(String input) {
		try {
			return Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(NOT_INTEGER_ERROR_MESSAGE);
		}
	}

	public static void checkBraced(String input) {
		if (!input.matches(BRACED_FORMAT)) {
			throw new IllegalArgumentException(CATALOG_INPUT_ERROR_MESSAGE);
		}
	}

	public static void checkEmptyString(String input) {
		if (input.isEmpty()) {
			throw new IllegalArgumentException(BLANK_STRING_ERROR_MESSAGE);
		}
	}

	public static void checkCatalogSize(int size) {
		if (size != NUMBER_OF_CATALOG_MEMBER_VARIABLES) {
			throw new IllegalArgumentException(CATALOG_INPUT_ERROR_MESSAGE);
		}
	}

	public static void checkCatalogAlreadyExist(List<Catalog> catalogList, Catalog catalog) {
		if (catalogList.contains(catalog)) {
			throw new IllegalArgumentException(CATALOG_DUPLICATE_ERROR_MESSAGE);
		}
	}

	public static void checkMinimumPrice(int price) {
		if (price < CATALOG_MINIMUM_PRICE) {
			throw new IllegalArgumentException(CATALOG_MINIMUM_PRICE_ERROR_MESSAGE);
		}
	}

	public static void checkExistCatalog(Catalog catalog) {
		if (catalog == null) {
			throw new IllegalArgumentException(NO_SUCH_CATALOG);
		}
	}

	public static void checkCanPurchase(Catalog catalog) {
		if (!UserAccount.canBuy(catalog)) {
			throw new IllegalArgumentException(NOT_ENOUGH_MONEY);
		}
		if (!catalog.isExist()) {
			throw new IllegalArgumentException(NOT_ENOUGH_CATALOG);
		}
	}

	public static void checkEndWithSemiColon(String inputString) {
		if (inputString.endsWith(SEMI_COLON)) {
			throw new IllegalArgumentException(CATALOG_INPUT_ERROR_MESSAGE);
		}
	}
}
