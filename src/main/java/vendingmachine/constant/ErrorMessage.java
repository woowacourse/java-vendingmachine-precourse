package vendingmachine.constant;

public class ErrorMessage {
	public static final String NUMBER_EMPTY_MSG = "[ERROR] 금액이 입력되지 않았습니다!";
	public static final String NUMBER_NOT_INTEGER_MSG = "[ERROR] 숫자가 아닌 값이 입력되었습니다!";
	public static final String NUMBER_NOT_DIVIDE_MINIMUM_COIN_AMOUNT_MSG = "[ERROR] 가장 작은 동전보다 작은 금액이 있습니다!";
	public static final String PRODUCT_QUANTITY_NEGATIVE_MSG = "[ERROR] 상품의 수량이 음수입니다!";
	public static final String PRODUCT_QUANTITY_NOT_INTEGER_MSG = "[ERROR] 상품의 수량이 숫자가 아닙니다!";
	public static final String PRODUCT_QUANTITY_EMPTY_MSG = "[ERROR] 상품의 수량이 입력되지 않았습니다!";
	public static final String PRODUCT_PRICE_UNIT_ERROR_MSG = "[ERROR] 상품의 가격은 10원 단위여야합니다!";
	public static final String PRODUCT_PRICE_RANGE_ERROR_MSG = "[ERROR] 상품의 가격은 100원보다 커야합니다!";
	public static final String PRODUCT_PRICE_NOT_INTEGER_MSG = "[ERROR] 상품의 가격이 숫자가 아닙니다!";
	public static final String PRODUCT_PRICE_EMPTY_MSG = "[ERROR] 상품의 가격이 입력되지 않았습니다!";
	public static final String PRODUCT_NAME_EMPTY_MSG = "[ERROR] 상품명이 입력되지 않았습니다!";
	public static final String PRODUCT_PARENTHESIS_FORMAT_MSG = "[ERROR] []로 상품을 분리해야 합니다!";
	public static final String PRODUCT_SEME_COLON_FORMAT_MSG = "[ERROR] ;으로 상품을 분리해야 합니다!";
	public static final String PRODUCT_COMMA_FORMAT_MSG = "[ERROR] ,으로 상품명과 가격, 수량을 구분해야합니다!";
	public static final String PRODUCT_NOT_EXIST_MSG = "[ERROR] 입력한 상품이 존재하지 않습니다!";
	public static final String PRODUCT_NOT_BUY_MSG = "[ERROR] 상품을 판매할 수 없습니다!";
}
