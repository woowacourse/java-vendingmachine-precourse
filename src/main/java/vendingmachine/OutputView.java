package vendingmachine;

public class OutputView {
    private static final String CHANGE = "잔돈";
    private static final String HOLDING_COINS = "자판기가 보유한 동전";

    public static void printHoldingCoins(VendingMachine vendingMachine) {
        System.out.println(HOLDING_COINS);
        System.out.println(vendingMachine.toStringHoldingCoins());
    }

    public static void printInputAmount(VendingMachine vendingMachine) {
        System.out.println(vendingMachine.toStringInputAmount());
    }

    public static void printChanges(VendingMachine vendingMachine) {
        System.out.println(CHANGE);
        System.out.println(vendingMachine.toStringChanges());
    }
}
