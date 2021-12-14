package vendingmachine.utils;

public enum InputOutputMessages {

    INPUT_MACHINE_HAVE_MONEY_MESSAGE("자판기가 보유하고 있는 금액을 입력해 주세요."),
    INPUT_PRODUCT_INFORMATION_MESSAGE("상품명과 가격, 수량을 입력해 주세요."),
    INPUT_PURCHASING_COST_MESSAGE("투입 금액을 입력해 주세요."),
    OUTPUT_MACHINE_HAVE_COINS("자판기가 보유한 동전"),
    OUTPUT_PURCHASING_COST_MESSAGE("투입 금액: "),
    INPUT_PURCHASING_PRODUCT_NAME("구입할 상품명을 입력해 주세요.");

    private final String inputMessage;

    InputOutputMessages(final String inputMessage) {
        this.inputMessage = inputMessage;
    }

    public String getInputMessage() {
        return inputMessage;
    }

}
