package vendingmachine;

public class Application {
    public static int getInitCoin() {
        while (true) {
            String input = camp.nextstep.edu.missionutils.Console.readLine();

            if (true) {
                return Integer.parseInt(input);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Constants.coinInitMsg);
        int initCoin = getInitCoin();
    }
}
