package vendingmachine;

public class StringConstants {
    public static final String PREFIX_OF_ERROR_MESSAGE = "[ERROR] ";
    public static final String ERROR_MESSAGE_ABOUT_WRONG_CURRENT_BALANCE_INPUT = "보유 금액은 0원 이상이어야 하며 10원으로 나누어 떨어지는 정수만 가능합니다";
    public static final String ERROR_MESSAGE_ABOUT_DUPLICATED_ITEM_NAMES_IN = "상품명은 중복될 수 없습니다";
    public static final String ERROR_MESSAGE_ABOUT_WRONG_ITEM_INVENTORY_INPUT = "상품에 대한 정보를 쉼표(,)로 상품명,가격,수량을 구분하고 개별 상품은 대괄호([])로 묶어 세미콜론(;)으로 구분해 작성해 주세요. 예) [상품명,가격,수량];[상품명,가격,수량]";
    public static final String ERROR_MESSAGE_ABOUT_WRONG_ITEM_QUANTITY_INPUT = "수량은 정수로 변환할 수 있어야 하며 1보다 크거나 같아야 합니다";
    public static final String ERROR_MESSAGE_ABOUT_WRONG_ITEM_PRICE_INPUT = "상품 가격은 100원 이상의 정수이며 10원 단위로 나눠 떨어져야 합니다";
    public static final String ERROR_MESSAGE_ABOUT_WRONG_ITEM_NAME_INPUT = "상품 명은 최소 한 글자 이상이어야 합니다";
    public static final String ERROR_MESSAGE_ABOUT_WRONG_MONEY_TO_INSERT_INPUT = "투입금액은 0이상의 정수여야 합니다";
    public static final String ERROR_MESSAGE_ABOUT_EMPTY_ITEM_TO_PURCHASE_INPUT = "상품명을 한 글자 이상 입력해 주세요";
    public static final String ERROR_MESSAGE_ABOUT_NOT_EXIST_ITEM_TO_PURCHASE = "등록된 상품이 아닙니다";
    public static final String ERROR_MESSAGE_ABOUT_TOO_EXPENSIVE_ITEM_TO_PURCHASE = "구매하려는 상품이 잔액보다 비쌉니다";
    public static final String ERROR_MESSAGE_ABOUT_OUT_OF_STOCK = "구매하시려는 상품의 재고가 없습니다";

    public static final String REQUEST_MESSAGE_ABOUT_COIN_BALANCE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    public static final String NOTICE_PHRASE_FOR_COIN_BALANCE = "자판기가 보유한 동전";
    public static final String REQUEST_MESSAGE_ABOUT_ITEM_INVENTORY_INFO = "상품명과 가격, 수량을 입력해 주세요.";
    public static final String REQUEST_MESSAGE_ABOUT_AVAILABLE_MONEY = "투입 금액을 입력해 주세요.";
    public static final String REQUEST_MESSAGE_ABOUT_PURCHASING_ITEM = "구매할 상품명을 입력해 주세요.";
    public static final String NOTICE_PHRASE_FOR_CHANGE = "잔돈";

    public static final String NEW_LINE = System.lineSeparator();

    private StringConstants() {
    }
}
