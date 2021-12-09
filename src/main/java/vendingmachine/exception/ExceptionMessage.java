package vendingmachine.exception;

public class ExceptionMessage {
    private ExceptionMessage() {
    }

    // Location : model/money/Money
    public static final String NOT_POSITIVE_INTEGER_EXCEPTION_MESSAGE = "금액은 양의 정수여야 합니다.";
    public static final String NOT_MULTIPLE_OF_TEN_EXCEPTION_MESSAGE = "금액의 최소 단위는 10원입니다.";

    // Location : model/item/vo/Quantity
    public static final String NOT_POSITIVE_INTEGER_QUANTITY_EXCEPTION_MESSAGE = "상품 수량은 양의 정수여야 합니다.";

    // Location : model/item/vo/Price
    public static final String NOT_POSITIVE_INTEGER_PRICE_EXCEPTION_MESSAGE = "상품 가격은 양의 정수여야 합니다.";
    public static final String PRICE_MIN_VALUE_EXCEPTION_MESSAGE = "상품 가격은 최소 100원이여야 합니다.";
    public static final String NOT_MULTIPLE_OF_TEN_PRICE_EXCEPTION_MESSAGE = "상품 가격의 최소 단위는 10원입니다.";

    // Location : model/item/Item
    public static final String ITEM_INFO_BRACKET_EXCEPTION_MESSAGE = "상품 정보를 [ ] 괄호에 담아 입력하셔야 합니다.";
}