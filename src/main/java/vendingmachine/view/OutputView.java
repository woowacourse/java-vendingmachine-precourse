package vendingmachine.view;

public class OutputView {

    private static final String NEW_LINE = "\n";
    private static final String HOLDING_COIN_INFO_MESSAGE = "자판기가 보유한 동전";
    private static final String NUMBER_UNIT = "개";
    private static final String INSERT_AMOUNT_INFO_MESSAGE = "투입 금액: ";
    private static final String WON_UNIT = "원";
    private static final String CHANGE_INFO_MESSAGE = "잔돈";
    private static final String ERROR_SYMBOL = "[ERROR] ";

    public static void printNewLine() {
        System.out.print(NEW_LINE);
    }

    public static void printHoldingCoinsInfoMessage() {
        System.out.println(HOLDING_COIN_INFO_MESSAGE);
    }

    public static void printHoldingCoins(final String coinUnit, final int amountOfCoin) {
        System.out.println(coinUnit + amountOfCoin + NUMBER_UNIT);
    }

    public static void printInsertAmount(final int insertAmount) {
        System.out.print(INSERT_AMOUNT_INFO_MESSAGE);
        System.out.println(insertAmount + WON_UNIT);
    }

    public static void printChangeInfoMessage() {
        System.out.println(CHANGE_INFO_MESSAGE);
    }

    public static void printChangeCoins(final String coinUnit, final int numberOfChangeCoins) {
        if (numberOfChangeCoins > 0) {
            System.out.println(coinUnit + numberOfChangeCoins + NUMBER_UNIT);
        }
    }

    public static void printErrorMessage(final String errorMessage) {
        System.out.println(ERROR_SYMBOL + errorMessage);
    }

}
