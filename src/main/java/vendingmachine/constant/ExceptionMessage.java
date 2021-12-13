package vendingmachine.constant;

import static vendingmachine.constant.Symbol.*;

public enum ExceptionMessage {
	PRODUCT_FORMAT(String.format("상품은 '%s' 과 '%s'로 묶어주시고 '%s'로 구분해주세요.", BRACKET_OPEN.getSymbol(), BRACKET_CLOSE.getSymbol(), PRODUCT_DELIMITER.getSymbol())),
	PRODUCT_FORMAT_EACH(String.format("상품의 정보는 '%s'로 구분해주시고 [이름,가격,수량]으로 입력해주세요", PRODUCT_INFO_DELIMITER.getSymbol())),
	PRODUCT_FORMAT_INFO_EACH("상품의 이름은 1글자 이상이며, 가격과 수량은 숫자여야 합니다"),
	INVALID_PRICE("가격은 100원 이상, 10원으로 나누어 떨어져야 합니다"),
	INVALID_QUANTITY("수량은 1개 이상이어야 합니다"),
	MONEY_NOT_INTEGER("금액은 음수가 아닌 정수이어야 합니다"),
	NO_SUCH_PRODUCT("그런 상품은 존재하지 않습니다"),
	NOT_ENOUGH_MONEY("투입 금액이 부족합니다")
	;

	private static final String prefix = "[ERROR] ";
	private final String message;

	ExceptionMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return prefix + message;
	}
}
