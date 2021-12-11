package vendingmachine.Model;

import vendingmachine.Constant.Constant;
import vendingmachine.SystemMessage.NoticeMessage;
import vendingmachine.View.OutputView;

public class CoinPair {
    private Coin coin;
    private int number;

    public CoinPair(Coin coin, int number) {
        this.coin = coin;
        this.number = number;
    }

    public void addCoinNumber() {
        number++;
    }

    public void showCoin(OutputView outputView) {
        String coinName = coin.name().substring(5) + NoticeMessage.WON_MESSAGE;
        ;
        outputView.print(coinName + NoticeMessage.BAR_SEPARATOR_MESSAGE + number + NoticeMessage.EA_MESSAGE);
    }

    public int expendCoin(int remainMoney, OutputView outputView) {
        String coinName = coin.name().substring(5) + NoticeMessage.WON_MESSAGE;
        int requiredNumber = coin.requiredNumber(remainMoney);
        if (number == Constant.ZERO || requiredNumber == Constant.ZERO) {
            return Constant.ZERO;
        }
        if (requiredNumber >= number) {
            outputView.print(coinName + NoticeMessage.BAR_SEPARATOR_MESSAGE + number + NoticeMessage.EA_MESSAGE);
            return coin.totalAmount(number);
        }
        outputView.print(coinName + NoticeMessage.BAR_SEPARATOR_MESSAGE + requiredNumber + NoticeMessage.EA_MESSAGE);
        return coin.totalAmount(requiredNumber);
    }
}
