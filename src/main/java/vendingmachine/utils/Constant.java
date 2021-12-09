package vendingmachine.utils;

import static vendingmachine.domain.Coin.*;

import java.util.List;
import java.util.stream.Collectors;

public final class Constant {
	public static final String LINE_SEPARATOR = System.lineSeparator();

	public static final String INPUT_MACHINE_AMOUNT = "자판기가 보유하고 있는 금액 입력해주세요.";
	public static final String INPUT_PRODUCTS = "상품명과 가격, 수량을 입력해 주세요.";
	public static final String INPUT_CUSTOMER_AMOUNT = LINE_SEPARATOR + "투입 금액을 입력해 주세요.";
	public static final String INPUT_CUSTOMER_BUY_PRODUCT = "구매할 상품명을 입력해 주세요.";

	public static final String OUTPUT_MACHINE_NUM_OF_COINS = LINE_SEPARATOR + "자판기가 보유한 동전";
	public static final String OUTPUT_CUSTOMER_AMOUNT = LINE_SEPARATOR + "투입 금액: %d 원" + LINE_SEPARATOR;
	public static final String OUTPUT_CUSTOMER_CHANGE = "잔돈";

	public static final List<Integer> COIN_LIST = getCoinStream().map(c-> c.getValue()).collect(Collectors.toList());

}
