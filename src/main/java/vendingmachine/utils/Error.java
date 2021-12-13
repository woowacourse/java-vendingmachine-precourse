package vendingmachine.utils;

public class Error {

	public static String NUMBER_FORMAT_ERROR = "[ERROR] 숫자를 입력하세요.";
	public static String AMOUNT_NOT_POSITIVE_ERROR = "[ERROR] 0 또는 음수가 입력되었습니다. 양수를 입력하세요.";
	public static String AMOUNT_NOT_DIVIDE_ERROR = "[ERROR] 10원으로 나누어떨어지는 금액을 입력하세요.";
	public static String AMOUNT_MINIMUM_ERROR = "[ERROR] 상품 가격은 100원부터 시작합니다. 100원 이상의 가격을 입력하세요.";

	public static String ITEM_NOT_FORMAT_ERROR = "[ERROR] 상품 입력 형식이 다릅니다. [상품명1, 가격, 수량];[상품명2, 가격, 수량] 과 같은 형식으로 입력하세요.";
	public static String ITEM_DUPLICATE_ERROR = "[ERROR] 중복된 상품명이 존재합니다. 다시 입력하세요.";
	public static String ZERO_QUANTITY_ERROR = "[ERROR] 1개 이상의 수량을 입력하세요.";

	public static String ITEM_NOT_EXIST_ERROR = "[ERROR] 해당 상품이 존재하지 않습니다. 다시 입력하세요.";
	public static String ITEM_NOT_PURCHASE_ERROR = "[ERROR] 잔액이 부족하여 해당 상품을 구매할 수 없습니다. 다시 입력하세요.";
}
