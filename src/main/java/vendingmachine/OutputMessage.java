package vendingmachine;

public class OutputMessage {
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    private static final String PRINT_MONEY_PREFIX = "투입 금액 : ";
    private static final String PRINT_MONEY_SUFFIX = "원";

    public void printInputMoney(int customerMoney) {
        System.out.println(PRINT_MONEY_PREFIX + customerMoney + PRINT_MONEY_SUFFIX);
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(ERROR_MESSAGE_PREFIX + errorMessage);
    }
}
