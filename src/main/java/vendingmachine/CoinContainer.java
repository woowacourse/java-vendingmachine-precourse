package vendingmachine;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CoinContainer {

    private Coins coins = new Coins();

    public CoinContainer() {};

    public void init(int insertedAmount) {
        int holdingAmount = insertedAmount;
        Coin pickedCoin;
        List<Integer> pickableCoinAmountList = Coin.coinAmountList;

        while (holdingAmount > 0) {
            pickableCoinAmountList = updatePickableCoinAmountList(pickableCoinAmountList, holdingAmount);

            pickedCoin = pickCoin(pickableCoinAmountList);
            coins.addCoin(pickedCoin, 1);
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
        coins.addCoin(coin, 1);
    }

    public int getTotalAmount() {
        return coins.getTotalAmount();
    }
}
