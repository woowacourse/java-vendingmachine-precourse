package vendingmachine.utils;

import static vendingmachine.domain.Coin.*;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public final class Constant {
	public static final String LINE_SEPARATOR = System.lineSeparator();
	public static final String SEMICOLON = ";";
	public static final String COMMA = ",";

	public static final String INPUT_MACHINE_AMOUNT = "자판기가 보유하고 있는 금액 입력해주세요.";
	public static final String INPUT_PRODUCTS = "상품명과 가격" + COMMA + " 수량을 입력해 주세요.";
	public static final String INPUT_CUSTOMER_AMOUNT = "투입 금액을 입력해 주세요.";
	public static final String INPUT_CUSTOMER_BUY_PRODUCT = "구매할 상품명을 입력해 주세요.";

	public static final String OUTPUT_MACHINE_NUM_OF_COINS = "자판기가 보유한 동전";
	public static final String OUTPUT_CUSTOMER_AMOUNT = "투입 금액: %d원";
	public static final String OUTPUT_CUSTOMER_CHANGE = "잔돈";
	public static final String OUTPUT_CUSTOMER_NUN_OF_CHANGES = "%d원 - %d개";

	public static final List<Integer> COIN_LIST = getCoinStream().map(c -> c.getValue()).collect(Collectors.toList());
	public static final int COIN_MIN = getCoinStream().mapToInt(c -> c.getValue())
		.min()
		.orElseThrow(NumberFormatException::new);

	public static final Pattern NUMBER_FORMAT = Pattern.compile("[0-9]+");
	public static final Pattern PRODUCT_INPUT_SEMICOLON_FRAME_FORMAT = Pattern.compile("\\](.*?)\\[");
	public static final String PRODUCT_INPUT_SEMICOLON_FORMAT = SEMICOLON + "+";
	public static final Pattern PRODUCT_INPUT_FRAME_FORMAT = Pattern.compile("\\[(.*?)\\]");
	public static final String PRODUCT_INPUT_FORMAT = "^[가-힣A-z0-9]+" + COMMA + "[1-9]\\d*0+" + COMMA + "[1-9]\\d*$";

	public static final String AMOUNT_IS_NOT_RANGED_EXCEPTION_MESSAGE =
		"[ERROR] 금액의 최소 단위는 " + COIN_MIN + "원 이상이어야 합니다.";
	public static final String AMOUNT_NUMBER_FORMAT_EXCEPTION_MESSAGE = "[ERROR] 금액은 숫자여야 합니다.";
	public static final String PRODUCT_INPUT_FORMAT_EXCEPTION =
		"[ERROR] 상품 입력이 올바르지 않습니다. ex) [상품이름" + COMMA + "가격(" + COIN_MIN + "원 이상)" + COMMA + "수량(1개 이상)]";
	public static final String PRODUCT_INPUT_SEMICOLON_EXCEPTION_MESSAGE =
		"[ERROR] 상품 입력 사이에 '" + SEMICOLON + "'가 존재해야 합니다.";
}
