package vendingmachine;

public abstract class ErrorMessage {
    public static String PRICE_UNIT_ERROR_MESSAGE = "해당 금액은 동전으로 만들 수 없는 단위의 숫자입니다.";
    public static String PRICE_RANGE_ERROR_MESSAGE = "0 이상의 금액을 입력해주세요.";
    public static String PRICE_NOT_NUMBER_ERROR_MESSAGE = "금액은 숫자여야 합니다.";
    public static String QUANTITY_RANGE_ERROR_MESSAGE = "상품의 수량은 0 이상이어야 합니다.";
    public static String QUANTITY_NOT_NUMBER_ERROR_MESSAGE = "상품의 수량은 숫자여야 합니다.";
    public static String HAVE_SAME_PRODUCT_ERROR_MESSAGE = "같은 상품을 여러 번 입력할 수 없습니다.";
    public static String NO_STOCK_ERROR_MESSAGE = "해당 상품은 재고가 남아있지 않습니다.";
    public static String NO_PRODUCT_ERROR_MESSAGE = "해당 상품은 존재하지 않습니다.";
    public static String MONEY_LACK_ERROR_MESSAGE = "이 금액으로는 해당 제품을 구매할 수 없습니다.";
    public static String VENDING_MACHINE_NO_INITIAL_ERROR_MESSAGE = "자판기에는 최소 한 개의 물건은 들어가야 합니다.";
    public static String NO_BLANK_ERROR_MESSAGE = "공백은 입력될 수 없습니다.";
    public static String NO_WRAP_ERROR_MESSAGE = "상품의 상태는 []로 감싸져야 합니다.";
    public static String INVALID_PRODUCT_INFO_CNT_ERROR_MESSAGE = "상품명, 가격, 수량이 제대로 입력되지 않았습니다.";
    public static String NAME_EMPTY_ERROR_MESSAGE = "이름이 제대로 입력되지 않은 상품이 있습니다.";
    public static String NOT_NUMBER_ERROR_MESSAGE = "숫자를 입력해주세요.";
    public static String LOGIC_ERROR_MESSAGE = "로직 오류";
    public static String PRODUCT_PRICE_LACK_ERROR_MESSAGE = "상품의 가격이 100원 미만인 값이 있습니다.";

}
