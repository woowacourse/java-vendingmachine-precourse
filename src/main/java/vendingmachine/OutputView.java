package vendingmachine;

public class OutputView {
    private static final String CHANGE = "잔돈";
    private static final String HOLDING_COINS = "자판기가 보유한 동전";
    private static final String ERROR_PREFIX = "[ERROR] ";

    public static void printHoldingCoins(HoldingCoins holdingCoins) {
        System.out.println(HOLDING_COINS);
        System.out.println(holdingCoins);
    }

    public static void printInputAmount(VendingMachine vendingMachine) {
        System.out.println(vendingMachine.toStringInputAmount());
    }

    public static void printChanges(VendingMachine vendingMachine) {
        System.out.println(CHANGE);
        System.out.println(vendingMachine.toStringChanges());
    }

    public static void printError(Exception e) {
        System.out.println(ERROR_PREFIX + e.getMessage());
    }
}
