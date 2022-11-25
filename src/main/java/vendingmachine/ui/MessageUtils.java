package vendingmachine.ui;

public enum MessageUtils {
    // 출력 메세지
    INPUT_MACHINE_MONEY("자판기가 보유하고 있는 금액을 입력해 주세요."),
    MACHINE_COIN_INFO("자판기가 보유한 동전"),
    INPUT_MERCHANDISE_INFO("상품명과 가격, 수량을 입력해 주세요."),
    INPUT_USERS_MONEY("투입 금액을 입력해 주세요."),
    INPUT_USERS_STOCK_CHOICE("구매할 상품명을 입력해 주세요."),
    MONEY_REMAINING("투입 금액: "),

    // 에러 관련 메세지
    INVALID_STOCKS_INPUT("올바른 형식의 상품을 입력해주세요"),
    MONEY_INPUT_ERROR("올바른 형식의 금액을 입력해주세요."),
    INVALID_STOCK_INFO("존재하는 상품인지 확인해주세요");

    private final String msg;

    MessageUtils(String msg) {
        this.msg = msg;
    }

    public String msg() {
        return msg;
    }
}
