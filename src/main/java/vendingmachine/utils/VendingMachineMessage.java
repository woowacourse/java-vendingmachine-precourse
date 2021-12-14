package vendingmachine.utils;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * <h1>자판기 구동시 출력해야하는 메시지</h1>
 * 사용자가 자판기를 사용하게 하기 위해 출력해야 하는
 * 메시지
 *
 * @author yunki kim
 * @version 2.0
 * @since 2021-12-11(V1.0)
 */

public class VendingMachineMessage {

	/* input 관련 메시지*/
	public static final String INPUT_AMOUNT_MONEY_IN_MACHINE = "자판기가 보유하고 있는 금액을 입력해 주세요.";

	public static final String INPUT_PRODUCTS_INFORMATION = "상품명과 가격, 수량을 입력해 주세요.";

	public static final String INPUT_MONEY = "투입 금액을 입력해 주세요.";

	public static final String SELECT_PRODUCT_TO_PURCHASE = "구매할 상품명을 입력해 주세요.";

	/* output 관련 메시지 */
	private static final String COIN_TYPES_AMOUNT = "자판기가 보유한 동전";

	private static final String USER_INPUTTED_MONEY = "투입 금액: ";

	private static final String CHANGE = "잔돈";

	/* 에러 관련 메시지 */
	private static final String ERROR_MESSAGE_PREFIX = "[ERROR]: ";

	private static final String INVALID_NUMBER_LENGTH = " 길이가 너무 짧습니다";

	private static final String INVALID_NUMBER = " 1의자리가 0인 정수여야 합니다";

	private static final String NOT_INTEGER = " 정수만 입력되야 합니다";

	private static final String INVOLVE_BLANK = " 공백이 포함되면 안됩니다";

	private static final String WRONG_BRACKET = " 괄호 쌍이 맞지 않습니다";

	private static final String PRODUCTS_DISTINGUISHING = " 서로 다른 제품은 ;로 구분되야 합니다";

	private static final String PRODUCT_INFORMATION = " 제품의 정보는 이름,가격,수량 순으로 되있어야 하며 ,로 구분되야 합니다";

	/* 결과 출력과 관련된 메서드 */
	public static void printCoinTypesAmount(final HashMap<Integer, Integer> coinTypesAmount) {
		final ArrayList<Integer> coinTypes = CoinTypeGenerator.getCoinTypes();
		System.out.println(COIN_TYPES_AMOUNT);
		coinTypes.forEach(coinType -> {
			System.out.println(coinType + "원" + " - " + coinTypesAmount.get(coinType) + "개");
		});
	}

	public static void printUserInputtedMoney(final int money) {
		System.out.println(USER_INPUTTED_MONEY + money + "원");
	}

	public static void printChange(final HashMap<Integer, Integer> changes) {
		final ArrayList<Integer> coinTypes = CoinTypeGenerator.getCoinTypes();
		System.out.println(CHANGE);
		coinTypes.forEach(coinType -> {
			if(changes.containsKey(coinType)) {
				System.out.println(coinType + "원" + " - " + changes.get(coinType) + "개");
			}
		});
	}

	/* 에러 출력과 관련된 메서드 */
	public static String invalidLengthError(final String inputtedData) {
		System.out.println(ERROR_MESSAGE_PREFIX + inputtedData + INVALID_NUMBER_LENGTH);
		return ERROR_MESSAGE_PREFIX + inputtedData + INVALID_NUMBER_LENGTH;
	}

	public static String invalidNumberError(final String inputtedData) {
		return ERROR_MESSAGE_PREFIX + inputtedData + INVALID_NUMBER;
	}

	public static String notNumberError(final String inputtedData) {
		return ERROR_MESSAGE_PREFIX + inputtedData + NOT_INTEGER;
	}

	public static String involveBlankError(final String inputtedData) {
		return ERROR_MESSAGE_PREFIX + inputtedData + INVOLVE_BLANK;
	}

	public static String bracketsDontMatch(final String inputtedData) {
		return ERROR_MESSAGE_PREFIX + inputtedData + WRONG_BRACKET;
	}

	public static String distinguishProductsError(final String inputtedData) {
		return ERROR_MESSAGE_PREFIX + inputtedData + PRODUCTS_DISTINGUISHING;
	}

	public static String productInformationIsntEnough(final String inputtedData) {
		return ERROR_MESSAGE_PREFIX + inputtedData + PRODUCT_INFORMATION;
	}
}
