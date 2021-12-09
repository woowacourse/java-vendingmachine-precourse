package vendingmachine.view;

public class ErrorMessage {
	public static final String ONLY_INTEGER = "[ERROR] 금액은 숫자로만 입력 가능합니다.";
	public static final String START_WITH_ZERO = "[ERROR] 금액은 0으로 시작할 수 없습니다.";
	public static final String BALANCE_THRESHOLD = "[ERROR] 금액은 최소 10원 이상 입력해야 합니다.";
	public static final String BALANCE_UNIT = "[ERROR] 금액은 10원 단위로 입력해야 합니다.";
	public static final String WRONG_ITEM_INPUT = "[ERROR] 상품명은 문자, 가격과 수량 형식을 지켜주세요.";
}
