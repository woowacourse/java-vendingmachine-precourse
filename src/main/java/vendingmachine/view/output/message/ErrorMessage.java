package vendingmachine.view.output.message;

public class ErrorMessage {

	public static final String TAG = "[ERROR] ";

	public static final String COIN_NOT_FOUND_MESSAGE = "동전을 찾을 수 없습니다.";

	public static final String FORMAT_IS_NOT_CORRECT_MESSAGE = "형식이 맞지 않습니다.";

	public static final String MONEY_IS_NOT_ENOUGH_MESSAGE = "보유하신 금액이 부족합니다.";
	public static final String MONEY_NOT_MULTIPLE_OF_TEN_MESSAGE = "금액은 10의 배수여야 합니다.";
	public static final String MONEY_NOT_NUMERIC_MESSAGE = "금액은 숫자여야 합니다.";
	public static final String MONEY_NOT_POSITIVE_MESSAGE = "금액은 양수여야 합니다.";

	public static final String PRICE_NOT_MORE_THAN_MINIMUM_AMOUNT_MESSAGE = "금액은 100원 이상이어야 합니다.";
	public static final String PRICE_NOT_MULTIPLE_OF_TEN_MESSAGE = "금액은 10원으로 나누어 떨어져야 합니다.";

	public static final String PRODUCT_INPUT_NOT_EXIST_MESSAGE = "등록할 상품 정보가 없습니다.";
	public static final String PRODUCT_NAME_DUPLICATED_MESSAGE = "상품 이름이 중복됩니다.";
	public static final String PRODUCT_NOT_FOUNT_MESSAGE = "상품을 찾을 수 없습니다.";
	public static final String PRODUCT_SOLD_OUT_MESSAGE = "상품이 매진 되었습니다.";

	public static final String QUANTITY_NOT_NUMERIC_MESSAGE = "수량은 숫자여야 합니다.";
	public static final String QUANTITY_NOT_POSITIVE_MESSAGE = "수량은 양수여야 합니다.";

}
