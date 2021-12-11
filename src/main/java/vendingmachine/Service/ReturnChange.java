package vendingmachine.Service;

import vendingmachine.Model.*;
import vendingmachine.SystemMessage.NoticeMessage;
import vendingmachine.View.*;

import java.util.List;

public class ReturnChange {
    private static User user;
    private static VendingMachine vendingMachine;
    private static InputView inputView;
    private static OutputView outputView;

    public ReturnChange(User user, VendingMachine vendingMachine, InputView inputView, OutputView outputView) {
        this.user = user;
        this.vendingMachine = vendingMachine;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public static void execute() {
        outputView.print(NoticeMessage.CHANGE_MESSAGE);
        calculateChange(vendingMachine.getCoins().getCoins(), user.getRemainMoney());
    }

    public static void calculateChange(List<CoinPair> coins, int remainMoney) {
        for (CoinPair coinPair : coins) {
            remainMoney -= payCoin(coinPair, remainMoney);
        }
    }

    private static int payCoin(CoinPair coinPair, int remainMoney) {
        String coinName = coinPair.getCoin().name();
        coinName = coinName.substring(5) + NoticeMessage.WON_MESSAGE;
        int requiredCoins = remainMoney / coinPair.getCoin().getAmount();
        if (coinPair.getNumber() == 0 || requiredCoins == 0) {
            return 0;
        }
        if (requiredCoins >= coinPair.getNumber()) {
            outputView.print(coinName + " - " + coinPair.getNumber() + NoticeMessage.EA_MESSAGE);
            return coinPair.getNumber() * coinPair.getCoin().getAmount();
        }
        outputView.print(coinName + " - " + requiredCoins + NoticeMessage.EA_MESSAGE);
        return requiredCoins * coinPair.getCoin().getAmount();
    }
}
