package vendingmachine;

public enum ErrorMessage {
    NO_COIN_MATCH("해당 금액에 해당하는 동전이 없습니다."),
    NO_PRODUCT_MATCH("해당 이름의 상품이 없습니다."),
    NOT_ENOUGH_BALANCE("잔액이 부족합니다."),
    NOT_ENOUGH_STOCK("수량이 부족합니다."),
    NOT_ENOUGH_COIN("동전 수량이 부족합니다."),
    INVALID_INSERTED_AMOUNT("입력한 보유금액이 정수가 아닙니다"),
    NOT_DIVIDED_BY_10("입력한 값은 10원 단위여야 합니다.")
    ;

    public static final String ERROR_PREFIX = "[ERROR]";

    private String text;

    ErrorMessage(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public String getCompleteMessage() {
        return ERROR_PREFIX + getText();
    }

}
