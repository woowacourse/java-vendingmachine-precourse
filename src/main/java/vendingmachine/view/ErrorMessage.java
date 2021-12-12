package vendingmachine.view;

public class ErrorMessage {
	public static final String WRONG_ITEM_INPUT = "[ERROR] 상품명은 문자, 가격과 수량 형식을 지켜주세요.";
	public static final String WRONG_MONEY_INPUT = "[ERROR] 금액은 10단위의 숫자로 입력해주세요.";
	public static final String CANNOT_FIND_ITEM = "[ERROR] 해당 상품을 찾을 수 없습니다.";
	public static final String SOLD_OUT = "[ERROR] 해당 상품이 매진되었습니다.";
	public static final String NOT_ENOUGH_MONEY = "[ERROR] 투입 금액이 부족합니다";
	public static final String INVALID_COIN_AMOUNT = "[ERROR] 존재하지 않는 동전입니다.";
	public static final String CANNOT_FIND_MINIMUM_ITEM_PRICE = "[ERROR] 상품 목록에서 가격의 최소값을 찾을 수 없습니다.";
}
