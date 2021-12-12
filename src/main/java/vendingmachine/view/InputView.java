package vendingmachine.view;

import java.util.Arrays;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static final String PRODUCTS_INPUT_SPLIT = ";";
	private static final int PRODUCTS_INPUT_SPLIT_LIMIT = -1;
	private static final String PRODUCT_INPUT_PATTERN = "\\[[a-zA-Z0-9가-힣]+,\\d{3,},\\d+]";
	private static final String PRODUCT_INPUT_FROM_REPLACE_PATTERN = "[\\[\\]]";
	private static final String PRODUCT_INPUT_TO_REPLACE_PATTERN = "";

	private static final String COINS_INPUT_HAS_VENDING_MACHINE = "자판기가 보유하고 있는 금액을 입력해 주세요";
	private static final String ERROR_NOT_NUMBER_MESSAGE = "숫자의 입력이 아닙니다.";
	private static final String PRODUCTS_INPUT_HAS_VENDING_MACHINE = "상품명과 가격, 수량을 입력해주세요.";
	private static final String ERROR_PRODUCT_INPUT_NOT_PATTERN = "상품 입력의 패턴이 아닙니다.";

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

	public static String[] getInputProducts() {
		System.out.println(PRODUCTS_INPUT_HAS_VENDING_MACHINE);
		return getConvertArrayString();
	}

	private static String[] getConvertArrayString() {
		return Arrays.stream(Console.readLine().split(PRODUCTS_INPUT_SPLIT, PRODUCTS_INPUT_SPLIT_LIMIT))
			.filter(inputProduct -> isValidateInputProductPattern(inputProduct))
			.map(inputProduct -> inputProduct.replaceAll(
				PRODUCT_INPUT_FROM_REPLACE_PATTERN,
				PRODUCT_INPUT_TO_REPLACE_PATTERN))
			.toArray(String[]::new);
	}

	private static boolean isValidateInputProductPattern(String inputProduct) {
		if (!inputProduct.matches(PRODUCT_INPUT_PATTERN)) {
			throw new IllegalArgumentException(ERROR_PRODUCT_INPUT_NOT_PATTERN);
		}

		return true;
	}
}
