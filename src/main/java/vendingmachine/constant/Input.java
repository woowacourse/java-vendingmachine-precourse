package vendingmachine.constant;

public enum Input {
    MONEY_GUIDE_MESSAGE("자판기가 보유하고 있는 금액을 입력해 주세요."),
    MONEY_DIGIT_ERROR_MESSAGE("[ERROR] 금액은 숫자만 입력하실 수 있습니다."),
    MONEY_LENGTH_0_ERROR_MESSAGE("[ERROR] 1자리 이상의 숫자를 입력해주세요.");

    private final String text;

    Input(final String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}