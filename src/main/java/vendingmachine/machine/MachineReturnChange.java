package vendingmachine.machine;

public class MachineReturnChange {
    public static Coin[] coins = Coin.values();

    public static int[] coinNumber = new int[4];

    public static int reduceUserMoney(Coin coin, int userMoney, int i) {
        int number = coin.getNumber();

        while (true) {
            if (coin.getCoinAmount() * number < userMoney) {
                coin.minusCoinNumber(number);
                coinNumber[i] = number;
                return userMoney - coin.getCoinAmount() * number;
            }
            number--;
        }
    }

    public static void makeChanges(int userMoney) {
        int i = 0;

        for (Coin coin : coins) {
            userMoney -= reduceUserMoney(coin, userMoney, i);
            i += 1;
        }
    }

    public static boolean isThisCoinZero(Coin coin) {
        return coin.getNumber() == 0;
    }

    public static int getCoinNumber(int i) {
        return coinNumber[i];
    }
}
