package vendingmachine.machine;

public class MachineReturnChange {
    public static Coin[] coins = Coin.values();

    public static int[] coinNumber = {0, 0, 0, 0};

    public static int reduceUserMoney(Coin coin, int userMoney, int i) {
        int number = coin.getNumber();

        while (number > 0) {
            if ((coin.getCoinAmount() * number) <= userMoney) {
                coin.minusCoinNumber(number);
                coinNumber[i] = number;
                break;
            }
            number--;
        }
        return userMoney - coin.getCoinAmount() * number;
    }

    public static void makeChanges(int userMoney) {
        int i = 0;

        for (Coin coin : coins) {
            userMoney = reduceUserMoney(coin, userMoney, i);
            i += 1;
        }
    }

    public static boolean isThisCoinZero(int index) {
        return coinNumber[index] == 0;
    }

    public static int getCoinNumber(int i) {
        return coinNumber[i];
    }
}
