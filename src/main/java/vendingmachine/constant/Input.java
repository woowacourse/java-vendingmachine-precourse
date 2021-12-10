package vendingmachine.constant;

public enum Input {
    SEMICOLON(";"),
    OPEN_BRACKET("["),
    CLOSE_BRACKET("]"),
    COMMA(","),

    MONEY_GUIDE_MESSAGE("자판기가 보유하고 있는 금액을 입력해 주세요."),
    MONEY_DIGIT_ERROR_MESSAGE("[ERROR] 금액은 숫자만 입력하실 수 있습니다."),
    MONEY_LENGTH_0_ERROR_MESSAGE("[ERROR] 1자리 이상의 숫자를 입력해주세요."),

    PRODUCT_GUIDE_MESSAGE("상품명과 가격, 수량을 입력해 주세요."),
    ONLY_SEMICOLON_ERROR_MESSAGE("[ERROR] 세미콜론(;)만 입력하실 수 없습니다. 상품을 추가해주세요."),
    PRODUCT_BRACKETS_ERROR_MESSAGE("[ERROR] 상품 정보를 [상품명, 가격, 수량] 형식으로 입력해주세요."),
    PRODUCTS_BLANK_ERROR_MESSAGE("[ERROR] 추가할 상품을 입력해주세요."),
    PRODUCTS_INFORMATION_NUMBER_ERROR_MESSAGE("[ERROR] [상품명, 가격, 수량] 3가지 정보를 모두 채워 입력해주세요."),
    PRODUCT_NAME_BLANK_ERROR_MESSAGE("[ERROR] 상품명을 입력해주세요."),
    PRODUCTS_SAME_NAME_ERROR_MESSAGE("[ERROR] 중복된 상품명이 존재합니다."),
    PRODUCT_COST_BLANK_ERROR_MESSAGE("[ERROR] 상품가격을 입력해주세요."),
    PRODUCT_COST_DIGIT_ERROR_MESSAGE("[ERROR] 상품가격은 숫자만 입력하셔야 합니다."),
    PRODUCT_COST_DIVIDE_ERROR_MESSAGE("[ERROR] 상품가격은 10의 배수이어야 합니다."),
    PRODUCT_MINIMUM_COST_ERROR_MESSAGE("[ERROR] 상품가격은 10의 배수이어야 합니다."),
    PRODUCTS_SEMICOLON_ERROR_MESSAGE("[ERROR] 각 상품은 세미콜론(;)으로 구분해서 입력해주세요."),
    PRODUCT_AMOUNT_BLANK_ERROR_MESSAGE("[ERROR] 상품 가격을 입력해주세요."),
    PRODUCT_AMOUNT_DIGIT_ERROR_MESSAGE("[ERROR] 상품가격은 숫자만 입력하셔야 합니다.");

    private final String text;

    Input(final String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}