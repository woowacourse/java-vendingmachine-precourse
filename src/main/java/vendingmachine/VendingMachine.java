package vendingmachine;
import java.util.HashMap;
import camp.nextstep.edu.missionutils.Randoms;

public class VendingMachine {
    HashMap<Integer, Coin> coinCount = new HashMap<Integer, Coin>();

    private void initCoinCount() {
        for (Coin coin: Coin.values()) {
            coinCount.put(coin.getAmount(), coin);
        }
    }

    private void generateCoinCount(int amount) {
        int remainder = amount;
        for (Coin coin : Coin.values()) {
            if (coin == Coin.COIN_10) {
                coin.setCount(remainder / coin.getAmount());
                break;
            }
            int minCoinCount = 0;
            int maxCoinCount = remainder / coin.getAmount();
            int pickCount = Randoms.pickNumberInRange(minCoinCount, maxCoinCount);
            coin.setCount(pickCount);
            remainder -= coin.getAmount() * pickCount;
        }
    }

    public VendingMachine(int amount) {
        initCoinCount();
        generateCoinCount(amount);
    }
}
