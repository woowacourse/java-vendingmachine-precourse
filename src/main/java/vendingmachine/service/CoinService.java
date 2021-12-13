package vendingmachine.service;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.domain.enums.Coin;
import vendingmachine.view.OutputView;

import java.util.HashMap;

import static vendingmachine.constants.SystemConstants.NO_TOTAL_MONEY_LEFT;
import static vendingmachine.constants.SystemConstants.ZERO_COINS;

public class CoinService {

    private final HashMap<Coin, Integer> coins = new HashMap<>();

    public HashMap<Coin, Integer> getCoins() {
        return coins;
    }

    public void initializeCoins(int totalMoney) {
        for (Coin coin : Coin.values()) {
            this.coins.put(coin, ZERO_COINS);
        }
        generateCoins(totalMoney);

        OutputView.printCoinsInfo(this.coins);
    }

    private void generateCoins(int totalMoney) {
        while (totalMoney > NO_TOTAL_MONEY_LEFT) {
            int randomCoinAmount = Randoms.pickNumberInList(Coin.getCoinsAmountDesc());
            if (totalMoney >= randomCoinAmount) {
                Coin newCoin = Coin.getCoinByAmount(randomCoinAmount);
                coins.put(newCoin, coins.get(newCoin) + 1);
                totalMoney -= randomCoinAmount;
            }
        }
    }
}
