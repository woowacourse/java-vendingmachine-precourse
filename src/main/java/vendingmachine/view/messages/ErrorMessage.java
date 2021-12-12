package vendingmachine.view.messages;

public class ErrorMessage {
	public static final String START_BRACKET_EXCEPTION = "각 상품의 입력은 대괄호로 시작해야 합니다.";
	public static final String END_BRACKET_EXCEPTION = "각 상품의 입력은 대괄호로 끝나야 합니다.";
	public static final String ITEM_INFO_EXCEPTION = "상품의 정보는 [상품,가격,수량]으로 입력해야 합니다.";
	public static final String ITEM_PRICE_CHARACTER_EXCEPTION = "상품의 가격은 숫자로 입력되어야 합니다.";
	public static final String ITEM_PRICE_DIVISIBLE_EXCEPTION = "상품의 가격은 10으로 나누어 떨어져야 합니다.";
	public static final String ITEM_PRICE_MINIMUM_EXCEPTION = "상품의 가격은 100원 이상이어야 합니다.";
	public static final String ITEM_QUANTITY_CHARACTER_EXCEPTION = "상품의 수량은 숫자로 입력되어야 합니다.";
	public static final String ITEM_QUANTITY_MINIMUM_EXCEPTION = "상품의 수량은 1 이상이어야 합니다.";
	public static final String SAVED_MONEY_CHARACTER_EXCEPTION = "보유 금액 입력은 숫자여야 합니다.";
	public static final String SAVED_MONEY_MINIMUM_EXCEPTION = "보유 금액은 0원 이상이어야 합니다.";
	public static final String CUSTOMER_MONEY_MINIMUM_EXCEPTION = "투입 금액은 0원 초과이어야 합니다.";
	public static final String ITEM_NOT_EXIST_EXCEPTION = "존재하지 않는 상품명입니다.";
	public static final String ITEM_EMPTY_QUANTITY_EXCEPTION = "상품의 재고가 부족합니다.";
	public static final String PURCHASE_NOT_ENOUGH_MONEY_EXCEPTION = "이 상품을 사기에는 금액이 부족합니다.";
}
