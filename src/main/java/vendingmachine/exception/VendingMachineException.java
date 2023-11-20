package vendingmachine.exception;

public enum VendingMachineException {
    INVALID_NUMBER_FORMAT("숫자를 입력해 주세요"),
    INVALID_MONEY_VALUE("입력 가격이 잘못되었습니다."),
    INVALID_STRING_FORMAT("입력 형식이 잘못되었습니다."),
    END_WITH_DELIMITER("입력의 마지막이 구분자로 끝났습니다."),

    INVALID_COIN_AMOUNT("해당 금액의 동전을 찾을 수 없습니다."),
    EMPTY_MENU_LIST("메뉴가 입력되지 않았습니다."),
    NO_MENU_FOUNDED("해당 메뉴를 찾을 수 없습니다."),

    CANT_PURCHASE("구매할 수 없는 상품입니다."),
    MENU_AMOUNT_MUST_POSITIVE("메뉴의 수량은 0보다 큰 값이어야 합니다."),
    NO_INPUT_FOUNDED("입력이 존재하지 않습니다."),
    ;

    private static final String PREFIX = "[ERROR] ";
    private final String messsage;

    VendingMachineException(String messsage) {
        this.messsage = messsage;
    }

    public String getMesssage() {
        return PREFIX + messsage;
    }

    public IllegalArgumentException makeException(){
        return new IllegalArgumentException(getMesssage());
    }
}
