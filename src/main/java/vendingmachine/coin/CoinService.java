package vendingmachine.coin;

import vendingmachine.coin.dto.CoinDto;

import java.util.*;

public class CoinService {

    private VendingMachineCoin vendingMachineCoin;

    private static class InnerInstanceClazz {
        private static final CoinService instance = new CoinService();
    }

    public static CoinService getInstance() {
        return InnerInstanceClazz.instance;
    }

    public void convertToCoin(int initialAmount) {
        vendingMachineCoin = VendingMachineCoin.fromInitialAmount(initialAmount);
    }

    public List<CoinDto> createChange(int remainingAmount) {
        List<CoinDto> change = new ArrayList<>();
        List<Integer> coinAmounts  = getDescendingOrderCoinAmount();

        for(Integer coinAmount : coinAmounts) {
            int totalCount = vendingMachineCoin.getCoinCount(coinAmount);
            int requiredCount = remainingAmount / coinAmount;

            int minCount = Math.min(totalCount, requiredCount);
            if(minCount > 0) {
                vendingMachineCoin.reduceCoinCount(coinAmount, minCount);
                change.add(new CoinDto(coinAmount, minCount));
                remainingAmount -= coinAmount * minCount;
            }
        }
        if(remainingAmount > 0) {
            vendingMachineCoin.addNonRefundableAmount(remainingAmount);
        }
        return change;
    }

    public List<CoinDto> getAllCoin() {
        List<CoinDto> coins = new ArrayList<>();
        List<Integer> coinAmounts  = getDescendingOrderCoinAmount();

        for(Integer coinAmount : coinAmounts) {
            Integer count = vendingMachineCoin.getCoinCount(coinAmount);
            coins.add(new CoinDto(coinAmount, count));
        }
        return coins;
    }

    private List<Integer> getDescendingOrderCoinAmount() {
        List<Integer> coinAmounts  = Coin.getCoinAmountList();
        coinAmounts.sort(Comparator.reverseOrder());
        return coinAmounts;
    }
}