package vendingmachine;

public class OutputMessage {
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    private static final String PRINT_MONEY_PREFIX = "투입 금액: ";
    private static final String PRINT_MONEY_SUFFIX = "원";
    private static final String HAVE_COIN_MESSAGE = "자판기가 보유한 동전";
    private static final String CHANGE_MESSAGE = "잔돈";

    public void printInputMoney(int customerMoney) {
        System.out.println(PRINT_MONEY_PREFIX + customerMoney + PRINT_MONEY_SUFFIX);
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(ERROR_MESSAGE_PREFIX + errorMessage);
    }

    public void printChangeMessage() {
        System.out.println(CHANGE_MESSAGE);
    }

    public void printHaveCoinMessage() {
        System.out.println(HAVE_COIN_MESSAGE);
    }
}
