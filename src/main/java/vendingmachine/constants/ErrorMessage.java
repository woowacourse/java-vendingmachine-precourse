package vendingmachine.constants;

public class ErrorMessage {
	public static final String ERROR = "[ERROR]";

	public static final String NOT_NUMBER_MONEY__MESSAGE = " 금액은 숫자만 입력할 수 있습니다.";
	public static final String NOT_POSITIVE_NUMBER_MONEY_MESSAGE = " 금액은 0보다 큰 숫자만 입력할 수 있습니다.";
	public static final String NOT_DIVIDED_TEN_NUMBER_MESSAGE = " 1 단위의 금액은 투입할 수 없습니다.";

	public static final String INSERTED_PRODUCT_IS_WRONG = " 입력받은 상품 정보의 형식이 잘못되었습니다.";
	public static final String ARRAY_SIZE_MESSAGE = " 상품 정보를 모두 입력해주십시오.";
	public static final String REDUPLICATION_NAME_MESSAGE = " 상품 이름이 중복입니다.";

	public static final String SPACE_IN_PRODUCT_NAME_MESSAGE = " 상품 이름에 공백이 있으면 안됩니다.";
	public static final String TAB_IN_PRODUCT_NAME_MESSAGE = " 상품 이름에 탭이 있으면 안됩니다.";
	public static final String BLANK_PRODUCT_NAME_MESSAGE = " 상품 이름은 필수입니다.";

	public static final String UNDER_THAN_PRICE_LIMIT_MESSAGE = " 상품의 가격은 100원을 넘어야합니다.";

	public static final String NOT_NUMBER_QUANTITY_MESSAGE = " 수량은 숫자만 입력할 수 있습니다.";
	public static final String NOT_POSITIVE_NUMBER_QUANTITY_MESSAGE = " 수량은 0보다 큰 숫자만 입력할 수 있습니다.";

	public static final String NO_NAME_IN_MENU_MESSAGE = " 주문하신 상품은 메뉴에 없습니다.";
	public static final String NO_QUANTITY_MESSAGE = " 주문하신 상품은 품절입니다.";
	public static final String CANNOT_BUY_WITH_REMAIN_MESSAGE = " 잔액이 모자랍니다.";
}
