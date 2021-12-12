package vendingmachine.model;
import java.util.HashMap;
import java.util.Arrays;
import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.model.Coin;

public class VendingMachine {
    private HashMap<Coin, Integer> coinCount = new HashMap<Coin, Integer>();
    private int remainderMoney;

    private void initCoinCount() {
        for (Coin coin: Coin.values()) {
            coinCount.put(coin, 0);
        }
    }

    private Coin getCoinByValue(int value) {
        for (Coin coin : Coin.values()) {
            if (coin.isEqual(value)) {
                return coin;
            }
        }
        return null;
    }

    private void generateCoinCount(int amount) {
        while(true) {
            int pickedCoin = Randoms.pickNumberInList(Arrays.asList(10, 50, 100, 500));
            Coin coin = getCoinByValue(pickedCoin);
            if (amount >= pickedCoin) {
                amount -= pickedCoin;
                coinCount.replace(coin, coinCount.get(coin) + 1);
            }
            if (amount == 0) {
                break;
            }
        }
    }

    public HashMap<Coin, Integer> getRemainderByCoin() {
        HashMap<Coin, Integer> remainderCoinCount = new HashMap<Coin, Integer>();
        int remainder = remainderMoney;
        for (Coin coin : Coin.values()) {
            int count = Math.min(coinCount.get(coin), remainder / coin.getAmount());
            remainderCoinCount.put(coin, count);
            remainder -= coin.getAmount() * count;
        }

        return remainderCoinCount;
    }

    public int getCoinCount(Coin coin) {
        return coinCount.get(coin);
    }

    public void setRemainderMoney(int money) {
        remainderMoney = money;
    }

    public int getRemainderMoney() {
        return remainderMoney;
    }

    public void decreaseMoney(int money) {
        remainderMoney -= money;
    }

    public VendingMachine(int amount) {
        initCoinCount();
        generateCoinCount(amount);
    }
}
