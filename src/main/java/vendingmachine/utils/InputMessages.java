package vendingmachine.utils;

public enum InputMessages {

    INPUT_MACHINE_HAVE_MONEY_MESSAGE("자판기가 보유하고 있는 금액을 입력해 주세요.");

    private final String inputMessage;

    InputMessages(final String inputMessage) {
        this.inputMessage = inputMessage;
    }

    public String getInputMessage() {
        return inputMessage;
    }

}
