package vendingmachine.utils.message;

public class ItemErrorMessage {

    public static final String PRICE_RANGE = "가격은 min 원 이상만 가능합니다.";
    public static final String PRICE_DIV = "가격은 div 원으로 나누어 떨어져야 합니다.";
    public static final String NOT_EXIST_ITEM = "아이템이 존재하지 않습니다.";
    public static final String EXIST_SAME_NAME = "같은 이름이 존재합니다.";
    public static final String NOT_STOCK = "재고가 없습니다.";
    public static final String NOT_ENOUGH_STOCK = "재고가 부족합니다.";
    public static final String INPUT_DATA_COUNT = "count 개의 입력만 가능합니다.";
    public static final String NUMBER_FORMAT = "숫자만 입력가능합니다.";
    public static final String ITEM_INPUT_FORMAT = "[상품명,가격,수량];[상품명,가격,수량]... 형식으로 입력해주세요";
}