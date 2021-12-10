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
    public static final String ITEM_INFO_FORMAT_EXCEPTION_MESSAGE = "상품 정보가 잘못되었습니다. Format : [상품명,가격,수량]";
    public static final String ITEM_INFO_NOT_ENOUGH_EXCEPTION_MESSAGE = "상품 정보에 누락이 있습니다.";

    // Location : model/item/Items
    public static final String WRONG_ITEM_DELIMITER_EXCEPTION_MESSAGE = "상품을 구분하는 구분자(;) 앞 뒤에 상품 정보가 없습니다.";
    public static final String ITEMS_OVERLAP_EXCEPTION_MESSAGE = "상품에 중복이 있습니다.";
}