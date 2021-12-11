package vendingmachine.constant;

public enum ErrorMessage {
    NULL("[ERROR] 입력값이 비어있습니다."),
    BIGGER_THAN_MIN_COIN_UNIT("[ERROR] 입력값은 10으로 나누어 떨어져야 합니다."),
    NOT_DIGIT("[ERROR] 입력값은 숫자로만 이루어져야 합니다."),
    NOT_CORRECT_BRACKET("[ERROR] 상품 정보는 대괄호로 묶어주어야 합니다."),
    NULL_IN_LIST("[ERROR] 상품의 정보 중 누락된 값이 있습니다."),
    DUPLICATE_MERCHANDISE_EXIST("[ERROR] 중복된 상품명이 존재합니다."),
    LACK_MONEY("[ERROR] 입력한 상품을 구매하기 위한 금액이 부족합니다."),
    NOT_EXIST_MERCHANDISE("[ERROR] 존재하지 않는 상품명입니다."),
    SOLD_OUT("[ERROR] 해당 상품은 매진되었습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String print() {
        return message;
    }
}
