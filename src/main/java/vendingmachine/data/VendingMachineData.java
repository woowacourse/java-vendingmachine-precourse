package vendingmachine.data;

public class VendingMachineData {

	public static final int PRODUCT_MINIMUM_PRICE = 100;
	public static final int PRODUCT_MINIMUM_UNIT = 10;

	public static final String INPUT_VENDING_MACHINE_MONEY_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	public static final String COIN_STATUS_MESSAGE = "자판기가 보유한 동전";
	public static final String INPUT_PRODUCT_INFO_MESSAGE = "상품명과 가격, 수량을 입력해 주세요.";
	public static final String INPUT_MONEY_MESSAGE = "투입 금액을 입력해 주세요.";
	public static final String MONEY_STATUS_MESSAGE = "투입 금액: %d원";
	public static final String INPUT_PRODUCT_NAME_MESSAGE = "구매할 상품명을 입력해 주세요.";
	public static final String CHANGE_STATUS_MESSAGE = "잔돈";
	public static final String CHANGE_STATUS_FORMAT = "%d원 - %d개";
	public static final String BALANCE_NOT_ENOUGH_MESSAGE = "잔액이 부족합니다.";

	public static final String INPUT_VALUE_NOT_INTEGER_ERROR = "[ERROR] 금액은 숫자여야 합니다.";
	public static final String INPUT_VALUE_TOO_SMALL_ERROR = "[ERROR] 금액이 너무 작습니다.";
	public static final String PRODUCT_INFO_FORM_NOT_MATCH_ERROR = "[ERROR] 상품 입력 양식이 잘못되었습니다.";
	public static final String PRODUCT_NAME_DUPLICATED_ERROR = "[ERROR] 중복되는 상품명이 존재합니다.";
	public static final String PRODUCT_QUANTITY_TOO_SMALL = "[ERROR] 수량이 너무 작습니다.";
	public static final String PRODUCT_NOT_FOUND_ERROR = "[ERROR] 해당 상품은 존재하지 않습니다. 다른 상품을 골라주세요.";
	public static final String PRODUCT_SOLDOUT_ERROR = "[ERROR] 해당 상품은 매진되었습니다. 다른 상품을 골라주세요.";
	public static final String PRODUCT_PRICE_UNIT_ERROR = String.format("[ERROR] 상품의 최소 금액 단위는 %d원 입니다.",
		PRODUCT_MINIMUM_UNIT);

	public static final String PRODUCT_REGEX = "\\[([\\w 가-힣]+),(\\d+),(\\d+)\\]";
	public static final String PRODUCT_SEPARATOR = ";";
}
