package vendingmachine.exception;

public enum VendingMachineException {

    INVALID_COIN_PRICE("잘못된 코인 금액입니다."),
    MONEY_MUST_NOT_NEGATIVE("금액은 0 이상이어야 합니다."),
    INVALID_MONEY_UNIT("금액은 %d원 단위로 입력해 주세요."),
    PRICE_SMALL_THAN_MIN("가격은 %d원 이상이어야 합니다."),
    NOT_ENOUGH_MONEY("잔액이 부족합니다."),

    MENU_NAME_BLANK("이름은 공백일 수 없습니다."),
    MENU_AMOUNT_MUST_POSITIVE("상품 수량은 양수여야 합니다."),
    SOLD_OUT_MENU("품절 상품입니다."),
    NO_SUCH_MENU("존재하지 않는 메뉴입니다."),
    DUPLICATED_MENU("중복된 메뉴가 존재합니다."),
    EMPTY_MENU("메뉴를 입력해 주세요"),

    //IO
    INVALID_INPUT_FORMAT("잘못된 입력 형식입니다."),
    INVALID_NUMBER_FORMAT("숫자를 입력해 주세요"),

    ;

    private final String message;

    VendingMachineException(String message) {
        this.message = message;
    }

    public IllegalArgumentException makeException(){
        return new IllegalArgumentException(message);
    }

    public IllegalArgumentException makeException(Object... args){
        return new IllegalArgumentException(message.formatted(args));
    }
}
