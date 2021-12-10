package vendingmachine.controller;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.domain.Coin;
import vendingmachine.domain.VendingMachineMoney;

import java.util.ArrayList;
import java.util.List;

public class CoinController {
    public static void makeCoin(VendingMachineMoney vendingMachineMoney) {
        int remainChange = vendingMachineMoney.getTotalMoney();
        List<Integer> coinList = new ArrayList<>();
        coinList.add(Coin.COIN_500.getAmount());
        coinList.add(Coin.COIN_100.getAmount());
        coinList.add(Coin.COIN_50.getAmount());
        coinList.add(Coin.COIN_10.getAmount());

        while (remainChange > 0) {
            int randomCoin = Randoms.pickNumberInList(coinList);

            if (remainChange - randomCoin >= 0) {
                remainChange -= randomCoin;
                vendingMachineMoney.coinUpdate(randomCoin);
            }
        }
    }
}
