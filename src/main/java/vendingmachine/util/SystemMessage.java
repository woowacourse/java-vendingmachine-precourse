package vendingmachine.util;

public class SystemMessage {
	private static final String ERROR = "[ERROR]";

	public static final String INPUT_FIRST_MONEY = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	public static final String ERROR_IS_NOT_INTEGER = ERROR + " 숫자를 입력해야 합니다.";
	public static final String ERROR_IS_NOT_POSITIVE = ERROR + " 양수를 입력해야 합니다.";
	public static final String ERROR_IS_NOT_MULTIPLE_OF_10 = ERROR + " 10의 배수를 입력해야 합니다.";
	public static final String SHOW_FIRST_MONEY = "자판기가 보유한 동전";
	public static final String INPUT_ITEM_INFO = "상품명과 가격, 수량을 입력해 주세요.";
	public static final String ERROR_IS_NOT_WRAPPED = ERROR + " []로 상품을 감싸서 입력해야 합니다.";
	public static final String ERROR_ITEM_DELIMITER = ERROR + " 상품명, 가격, 수량을 ','로 구분해야 합니다.";
	public static final String ERROR_ITEM_NAME_DUPLICATE = ERROR + " 상품명이 중복일 수 없습니다.";
	public static final String ERROR_PRICE_IS_NOT_INTEGER = ERROR + " 상품가격은 숫자로 입력해야 합니다.";
	public static final String ERROR_PRICE_MIN = ERROR + " 상품가격은 최소 100 이상을 입력해야 합니다.";
	public static final String ERROR_PRICE_IS_NOT_MULTIPLE_OF_10 = ERROR + " 상품가격은 10의 배수를 입력해야 합니다.";
	public static final String ERROR_AMOUNT_IS_NOT_INTEGER = ERROR + " 상품 수량은 숫자로 입력해야 합니다.";
	public static final String ERROR_AMOUNT_IS_NOT_POSITIVE = ERROR + " 상품 수량은 양수를 입력해야 합니다.";
	public static final String INPUT_MONEY = "투입 금액을 입력해 주세요.";
	public static final String SHOW_INPUT_MONEY = "투입 금액: ";
	public static final String ERROR_TOO_LOW_INPUT_MONEY = ERROR + " 너무 낮은 금액을 투입하여 구매할 수 있는 상품이 없습니다. 투입금을 반환합니다.";
	public static final String INPUT_ITEM_NAME = "구매할 상품명을 입력해 주세요.";
	public static final String ERROR_NOT_EXIST_ITEM = ERROR + " 존재하지 않는 상품명입니다.";
	public static final String ERROR_IS_NOT_IN_STOCK = ERROR + " 상품 재고가 남아있지 않습니다.";
	public static final String RETURN_CHANGES = "잔돈";
	public static final String CAN_PURCHASE_LIST = "구매 가능한 상품: ";
	public static final String ERROR_TOO_EXPENSIVE = ERROR + " 남은 금액으로 구매할 수 없는 가격의 상품입니다.";
}
