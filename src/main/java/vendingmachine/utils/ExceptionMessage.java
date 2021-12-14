package vendingmachine.utils;

public class ExceptionMessage {
	public static final String ERROR_MESSAGE = "\n[ERROR] ";

	public static final String NULL_VALUE = ERROR_MESSAGE + "공백이 입력될 수 없습니다.";
	public static final String NOT_EXIST_BRACKETS = ERROR_MESSAGE + "개별 상품은 대괄호[]로 묶어서 입력되어야 합니다.";
	public static final String MISMATCH_FORMAT = ERROR_MESSAGE + "개별 상품은 ,로 구분하여 상품이름,가격,개수 순서로 입력되어야 합니다.";
	public static final String DUPLICATE_PRODUCT = ERROR_MESSAGE + "이미 등록된 상품입니다.";

	public static final String NOT_POSITIVE = ERROR_MESSAGE + "양수만 입력될 수 있습니다.";
	public static final String UNDER_LIMIT_PAY = ERROR_MESSAGE + "금액은 " + Constant.LIMIT_PAY + "원 이상이어야 합니다.";
	public static final String NOT_MOD = ERROR_MESSAGE + "금액은 " + Constant.UNIT_MOD + "로 나누어 떨어져야 합니다.";

	public static final String NOT_ENOUGH_MONEY = ERROR_MESSAGE + "투입 금액이 부족합니다.";
	public static final String NOT_EXIST_PRODUCT = ERROR_MESSAGE + "입력하신 상품은 판매하고 있지 않습니다.";
	public static final String SOLD_OUT_PRODUCT = ERROR_MESSAGE + "입력하신 상품의 재고가 없습니다.";

}
