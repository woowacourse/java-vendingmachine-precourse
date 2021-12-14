package vendingmachine;

public class Application {
    public static int getInitCoin() {
        while (true) {
            try {
                String input = camp.nextstep.edu.missionutils.Console.readLine();

                InputChecker.checkNumber(input);

                return Integer.parseInt(input);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
                continue;
            }
        }
    }

    public static void printCoinStatus() {
        System.out.println();
        System.out.println(Constants.coinStatusMsg);
        for (Coin c: Coin.values()) {
            System.out.println(c.getAmount() + "원 - " + c.getCount() + "개");
        }
    }

    public static void main(String[] args) {
        System.out.println(Constants.coinInitMsg);
        int initCoin = getInitCoin();
        VendingMachine vm = new VendingMachine(initCoin);
        printCoinStatus();
    }
}
