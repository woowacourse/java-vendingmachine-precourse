package vendingmachine;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CoinContainer {

    int totalAmount = 0;

    private Map<Coin, Integer> remainingCoin = new HashMap<Coin, Integer>(){{
        put(Coin.COIN_10, 0);
        put(Coin.COIN_50, 0);
        put(Coin.COIN_100, 0);
        put(Coin.COIN_500, 0);
    }};

    public CoinContainer() {};

    public void init(int insertedAmount) {
        int holdingAmount = insertedAmount;
        Coin pickedCoin;
        List<Integer> pickableCoinAmountList = Coin.coinAmountList;

        while (holdingAmount > 0) {
            pickableCoinAmountList = updatePickableCoinAmountList(pickableCoinAmountList, holdingAmount);

            pickedCoin = pickCoin(pickableCoinAmountList);
            addRemainingCoin(pickedCoin);
            holdingAmount -= pickedCoin.getAmount();
        }
    }

    private List<Integer> updatePickableCoinAmountList(List<Integer> pickableCoinAmountList, int upperBoundAmount) {
        return pickableCoinAmountList.stream()
                .filter(amount -> amount <= upperBoundAmount)
                .collect(Collectors.toList());
    }

    private Coin pickCoin(List<Integer> pickableCoinAmountList) {
        int pickedAmount = Randoms.pickNumberInList(pickableCoinAmountList);

        return Coin.of(pickedAmount);
    }

    private void addRemainingCoin(Coin coin) {
        int remainingStock = remainingCoin.get(coin);
        totalAmount += coin.getAmount();
        remainingCoin.put(coin, remainingStock + 1);
    }

    public int getTotalAmount() {
        return totalAmount;
    }
}
