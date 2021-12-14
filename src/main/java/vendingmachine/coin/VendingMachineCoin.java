package vendingmachine.coin;

import java.util.Map;

public class VendingMachineCoin {

    private Map<Coin, Integer> coinCount;
    private Integer totalNonRefundableAmount = 0;

    private VendingMachineCoin() {}

    public static VendingMachineCoin fromInitialAmount(int initialAmount) {
        VendingMachineCoin vendingMachineCoin = new VendingMachineCoin();
        vendingMachineCoin.coinCount = Coin.createRandomCoin(initialAmount);
        return vendingMachineCoin;
    }

    public void addNonRefundableAmount(int nonRefundableAmount) {
        totalNonRefundableAmount += nonRefundableAmount;
    }

    public Integer getCoinCount(Integer coinAmount) {
        Coin coinName = Coin.findCoinName(coinAmount);
        return coinCount.get(coinName);
    }

    public void reduceCoinCount(Integer coinAmount, int count) {
        Coin coinName = Coin.findCoinName(coinAmount);
        coinCount.computeIfPresent(coinName, (K, V) -> V -= count);
    }
}