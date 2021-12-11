package vendingmachine;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;
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

    public Coins returnBalance(int balance) {
        if (balance >= coins.getTotalAmount()) {
            return coins.getAllCoin();
        }

        return getChangeCoins(balance);
    }

    private Coins getChangeCoins(int balance) {
        Coins changes = new Coins();
        Coin changedCoin;

        while (true) {
            changedCoin = getMaximumChangeableRemainingCoin(balance);
            if (changedCoin == null) {
                break;
            }

            balance -= changedCoin.getAmount();
            coins.moveCoin(changedCoin, 1, changes);
        }

        return changes;
    }

    private Coin getMaximumChangeableRemainingCoin(int amount) {
        return Arrays.stream(Coin.values())
                        .filter(coin -> coins.getCoinCount(coin) != 0)
                        .filter(coin -> amount >= coin.getAmount())
                        .findFirst()
                        .orElse(null);

    }

    public int getTotalAmount() {
        return coins.getTotalAmount();
    }
}
