package vendingmachine.view;

import vendingmachine.domain.coin.CoinCombination;
import vendingmachine.domain.user.UserMoney;
import static vendingmachine.constant.OutputViewMessage.*;

public class OutputView {

    public static void printCoinCount(CoinCombination coinCombination) {
        System.out.println(GUIDE_VENDING_MACHINE_COIN_COMBINATION_MESSAGE);
        coinCombination.getCoinCombination()
                .forEach(
                        (coin, count) -> System.out.println(coin + HYPHEN_MINUS + count + COUNT_MESSAGE)
                );
    }

    public static void printChangeCoinCount(CoinCombination coinCombination) {
        System.out.println(CHANGE);
        coinCombination.getCoinCombination()
                .forEach(
                        (coin, count) -> {
                            if (count > 0) {
                                System.out.println(coin + HYPHEN_MINUS + count + COUNT_MESSAGE);
                            }}
                );
    }

    public static void printUserMoney(UserMoney userMoney) {
        System.out.println(GUIDE_USER_MONEY_MESSAGE + userMoney.getMoney() + WON);
    }
}