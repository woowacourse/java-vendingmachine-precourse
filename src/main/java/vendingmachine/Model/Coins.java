package vendingmachine.Model;

import vendingmachine.SystemMessage.NoticeMessage;
import vendingmachine.View.OutputView;

import java.util.List;

public class Coins {
    private static List<CoinPair> coins;

    public Coins(List<CoinPair> coinPairs) {
        this.coins = coinPairs;
    }

    public static void showCoins(OutputView outputView) {
        outputView.print(NoticeMessage.BALANCE_COIN_MESSAGE);
        for (CoinPair coin : coins) {
            coin.showCoin(outputView);
        }
    }

    public static void expend(int remainMoney, OutputView outputView) {
        for (CoinPair coinPair : coins) {
            remainMoney -= coinPair.expendCoin(remainMoney, outputView);
        }
    }
}
