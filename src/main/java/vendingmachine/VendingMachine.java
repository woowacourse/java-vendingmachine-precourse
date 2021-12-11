package vendingmachine;
import java.util.HashMap;
import camp.nextstep.edu.missionutils.Randoms;

public class VendingMachine {
    private HashMap<Coin, Integer> coinCount = new HashMap<Coin, Integer>();

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

    public VendingMachine(int amount) {
        initCoinCount();
        generateCoinCount(amount);
    }
}
