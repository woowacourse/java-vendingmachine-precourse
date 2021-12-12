package vendingmachine.model;
import java.util.HashMap;
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

    private void generateCoinCount(int amount) {
        int remainder = amount;
        for (Coin coin : Coin.values()) {
            if (coin == Coin.COIN_10) {
                coinCount.replace(coin, remainder / coin.getAmount());
                break;
            }
            int minCoinCount = 0;
            int maxCoinCount = remainder / coin.getAmount();
            int pickCount = Randoms.pickNumberInRange(minCoinCount, maxCoinCount);
            coinCount.replace(coin, pickCount);
            remainder -= coin.getAmount() * pickCount;
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
