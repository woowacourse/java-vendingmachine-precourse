package vendingmachine;

public class OutputView {

    public static void printMachineCoin() {
        System.out.println("\n자판기가 보유한 동전");
        for (Coin coin : Coin.values()) {
            System.out.println(coin.getAmount() + "원 - " + coin.getCount() + "개");
        }
    }

    public static void printMoney(int money) {
        System.out.println("\n투입 금액: " + money + "원");
    }

    public static void printChanges() {
        System.out.println("잔돈");
        for (Coin coin : Coin.values()) {
            int changes = Machine.makeChanges(coin);
            if (changes != 0) {
                System.out.println(coin.getAmount() + "원 - " + changes + "개");
            }
        }

    }
}
