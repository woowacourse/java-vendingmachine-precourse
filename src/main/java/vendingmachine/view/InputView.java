package vendingmachine.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static final String PRODUCTS_INPUT_SPLIT = ";";
	private static final int PRODUCTS_INPUT_SPLIT_LIMIT = -1;
	private static final String PRODUCT_INPUT_PATTERN = "\\[[a-zA-Z0-9가-힣]+,\\d{3,},\\d+]";
	private static final String PRODUCT_INPUT_FROM_REPLACE_PATTERN = "[\\[\\]]";
	private static final String PRODUCT_INPUT_TO_REPLACE_PATTERN = "";
	private static final String PRODUCT_NAME_INPUT_PATTERN = "^[a-zA-Z0-9가-힣]*$";

	private static final String COINS_INPUT_HAS_VENDING_MACHINE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	private static final String ERROR_NOT_NUMBER_MESSAGE = "숫자의 입력이 아닙니다.";
	private static final String PRODUCTS_INPUT_HAS_VENDING_MACHINE = "상품명과 가격, 수량을 입력해주세요.";
	private static final String ERROR_PRODUCT_INPUT_NOT_PATTERN = "상품 입력의 패턴이 아닙니다.";
	private static final String BALANCE_INPUT_VENDING_MACHINE = "투입 금액을 입력해 주세요.";
	private static final String PRODUCT_NAME_INPUT_PURCHASE = "구매할 상품명을 입력해주세요.";
	private static final String ERROR_PRODUCT_NAME_INPUT_NOT_PATTERN = "상품명 입력 패턴이 잘못되었습니다.";

	public static int getInputCoins() {
		System.out.println(COINS_INPUT_HAS_VENDING_MACHINE);
		return getConvertInt();
	}

	private static int getConvertInt() {
		try {
			final String inputCoins = Console.readLine();
			return Integer.parseInt(inputCoins);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ERROR_NOT_NUMBER_MESSAGE);
		}
	}

	public static List<String> getInputProducts() {
		System.out.println(PRODUCTS_INPUT_HAS_VENDING_MACHINE);
		return getConvertListString();
	}

	private static List<String> getConvertListString() {
		return Arrays.stream(Console.readLine().split(PRODUCTS_INPUT_SPLIT, PRODUCTS_INPUT_SPLIT_LIMIT))
			.filter(inputProduct -> isValidateInputProductPattern(inputProduct))
			.map(inputProduct -> inputProduct.replaceAll(
				PRODUCT_INPUT_FROM_REPLACE_PATTERN,
				PRODUCT_INPUT_TO_REPLACE_PATTERN))
			.collect(Collectors.toList());
	}

	private static boolean isValidateInputProductPattern(String inputProduct) {
		if (!inputProduct.matches(PRODUCT_INPUT_PATTERN)) {
			throw new IllegalArgumentException(ERROR_PRODUCT_INPUT_NOT_PATTERN);
		}

		return true;
	}

	public static int getInputBalance() {
		System.out.println(BALANCE_INPUT_VENDING_MACHINE);
		return getConvertInt();
	}

	public static String getInputProductName() {
		System.out.println(PRODUCT_NAME_INPUT_PURCHASE);
		final String inputProductName = Console.readLine();
		isValidateInputProductNamePattern(inputProductName);
		return inputProductName;
	}

	private static void isValidateInputProductNamePattern(String inputProductName) {
		if (!inputProductName.matches(PRODUCT_NAME_INPUT_PATTERN)) {
			throw new IllegalArgumentException(ERROR_PRODUCT_NAME_INPUT_NOT_PATTERN);
		}
	}
}
