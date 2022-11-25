package vendingmachine;

public enum MessageUtils {
    // 출력 메세지
    INPUT_MACHINE_MONEY("자판기가 보유하고 있는 금액을 입력해 주세요."),
    MACHINE_COIN_INFO("자판기가 보유한 동전"),

    // 에러 관련 메세지
    MONEY_INPUT_ERROR("올바른 형식의 금액을 입력해주세요.");

    private final String msg;

    MessageUtils(String msg) {
        this.msg = msg;
    }

    public String msg() {
        return msg;
    }
}
