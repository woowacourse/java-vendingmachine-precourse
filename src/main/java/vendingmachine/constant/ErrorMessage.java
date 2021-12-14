package vendingmachine.constant;

public class ErrorMessage {
	public static final String INPUT_IS_NOT_INTEGER_ERROR_MESSAGE = "[ERROR] 입력되는 수는 2,147,483,647이하의 정수여야합니다.\n";
	public static final String LESS_THAN_CERTAIN_COIN_ERROR = "[ERROR] 금액은 %d원보다 커야 합니다.\n";
	public static final String NOT_DIVISIBLE_BY_SMALLEST_COIN_ERROR_MESSAGE = "[ERROR] 입력받은 금액이 %d원으로 나누어지떨어지지 않습니다.\n";
	public static final String PRODUCT_IS_NOT_MATCHED_REGEX_ERROR_MESSAGE = "[ERROR] 상품은 [상품명,가격,수량]의 형식으로 입력하세요.\n";
	public static final String DUPLICATE_NAME_EXIST_ERROR_MESSAGE = "[ERROR] 중복된 이름의 상품이 존재합니다.\n";
	public static final String BLANK_NAME_ERROR_MESSAGE = "[ERROR] 이름은 공백일 수 없습니다.\n";
	public static final String OUT_OF_STOCK_ERROR_MESSAGE = "[ERROR] 재고가 없는 상품은 등록할 수 없습니다.\n";
	public static final String PRODUCT_IS_NOT_EXISTENT_ERROR_MESSAGE = "[ERROR] 해당 상품은 존재하지 않습니다.";
	public static final String PRODUCT_IS_EXPENSIVE_ERROR_MESSAGE = "[ERROR] 투입 금액 부족으로 해당 상품을 살 수 없습니다.";
	public static final String SOLD_OUT_ERROR_MESSAGE = "[ERROR] 구매할 수 있는 상품이 없습니다.\n";
	public static final String COIN_IS_NOT_EXISTENT_ERROR_MESSAGE = "[ERROR] 없는 동전입니다.\n";
}
