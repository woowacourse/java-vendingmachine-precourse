package vendingmachine;

public class OutputView {

    private static String PRINT_MACHINE_COIN_MESSAGE = "\n자판기가 보유한 동전";
    private static String CHANGES_MESSAGE = "잔돈";
    private static String AMOUNT_UNIT_MESSAGE = "원";
    private static String COUNT_UNIT_MESSAGE = "개";
    private static String PRINT_MONEY_MESSAGE = "\n투입 금액: ";
    private static String DASH = " - ";

    public static void printMachineCoin() {
        System.out.println(PRINT_MACHINE_COIN_MESSAGE);
        for (Coin coin : Coin.values()) {
            System.out.println(coin.getAmount() + AMOUNT_UNIT_MESSAGE + DASH + coin.getCount() + COUNT_UNIT_MESSAGE);
        }
    }

    public static void printMoney(int money) {
        System.out.print(PRINT_MONEY_MESSAGE + money + AMOUNT_UNIT_MESSAGE);
    }

    public static void printChanges() {
        System.out.println(CHANGES_MESSAGE);
        for (Coin coin : Coin.values()) {
            int changes = Machine.makeChanges(coin);
            if (changes != 0) {
                System.out.println(coin.getAmount() + AMOUNT_UNIT_MESSAGE + DASH + changes + COUNT_UNIT_MESSAGE);
            }
        }

    }
}
