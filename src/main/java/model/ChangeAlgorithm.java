package model;

public class ChangeAlgorithm {

    public static void proceed(Money inputMoney, Money change) {

        for (Coin value : Coin.values()) {
            if (inputMoney.getAmount() >= value.getAmount()) {
                int count = inputMoney.getAmount() / value.getAmount();
                remove(inputMoney, value, count);
            }
        }
    }

    private static void remove(Money inputMoney, Coin value, int count) {
        if (value.getNum() >= count) {
            removeCoin(inputMoney, value, count);
        }
        if (value.getNum() < count) {
            removeCoin(inputMoney, value, value.getNum());
        }
    }

    private static void removeCoin(Money inputMoney, Coin value, int count) {
        Coin.decreaseCoinCount(value.getAmount(), count);
        inputMoney.removeMoney(value.getAmount() * count);
    }


}
