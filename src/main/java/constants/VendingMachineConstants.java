package constants;

import java.util.Arrays;
import java.util.List;

public class VendingMachineConstants {
	public static String VENDING_MACHINE_MONEY_INPUT_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	public static String VENDING_MACHINE_MONEY_OUTPUT_MESSAGE = "자판기가 보유한 동전";
	public static String PRODUCTS_INPUT_MESSAGE = "상품명과 가격, 수량을 입력해 주세요.";
	public static String USER_MONEY_MESSAGE = "투입 금액을 입력해 주세요.";
	public static String USER_INPUT_MONEY_MESSAGE = "투입 금액: ";
	public static String BUY_PRODUCT_NAME_MESSAGE = "구매할 상품명을 입력해 주세요.";
	public static String CHANGES_MESSAGE = "잔돈";
	public static String HAVE_NO_CHANGE_MESSAGE = "잔돈이 없습니다";

	public static String ERROR_PREFIX = "[ERROR] ";
	public static String MONEY_NOT_DIGIT_ERROR = "금액은 숫자여야 합니다.";
	public static String MONEY_NEGATIVE_NUM_ERROR = "금액은 양수여야 합니다.";
	public static String PRODUCT_FORMAT_ERROR = "개별 상품은 [상품명, 100원 이상의 가격, 수량]의 형태로 입력되어야 합니다.";
	public static String PRODUCT_PRICE_ERROR = "금액은 10원으로 나누어떨어져야 합니다.";
	public static String PRODUCT_AMOUNT_ERROR = "상품의 수량은 1이상이어야 합니다.";
	public static String PRODUCT_EMPTY_ERROR = "상품의 내용을 입력하여야 합니다";
	public static String DUPLICATE_PRODUCT_ERROR = "중복된 상품입니다.";
	public static String PRODUCT_NAME_NOT_EXIST_ERROR = "자판기에 없는 상품명입니다.";
	public static String PRODUCT_NOT_EXIST_ERROR = "이미 모두 팔린 제품입니다.";
	public static String PRODUCT_EXPENSIVE_ERROR = "투입한 금액보다 높은 가격의 제품은 구매할 수 없습니다.";
	public static String COIN_NOT_FOUND_ERROR = "코인을 찾을 수 없습니다.";
	public static String USER_MONEY_NOT_ENOUGH_ERROR = "투입 금액이 최저 가격보다 낮습니다.";
	public static String PRODUCT_LOWEST_PRICE_NOT_FOUND_ERROR = "제품의 최저 가격을 찾을 수 없습니다.";

	public static List<Integer> COIN_VALUES = Arrays.asList(500, 100, 50, 10);

	public static String KOR_MONETARY_UNIT = "원";
	public static String DASH_WITH_SPACE = " - ";
	public static String KOR_ITEM_UNIT = "개";
}
