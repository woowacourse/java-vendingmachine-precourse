package vendingmachine;

public class OutputView {
    public static void printHoldingCoins(VendingMachine vendingMachine) {
        System.out.println(vendingMachine.toStringHoldingCoins());
    }
}
