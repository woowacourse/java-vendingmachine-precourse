package vendingmachine.Model;

import vendingmachine.SystemMessage.NoticeMessage;
import vendingmachine.View.OutputView;

public class User {
    private static int inputMoney;

    public User(int inputMoney) {
        this.inputMoney = inputMoney;
    }

    public void pay(Drink drink) {
        inputMoney = drink.isPaid(inputMoney);
    }

    public void requestChange(Coins coins, OutputView outputView) {
        coins.expend(inputMoney, outputView);
    }

    public void showRemainMoney(OutputView outputView) {
        outputView.print(NoticeMessage.INPUT_MONEY_MESSAGE + inputMoney + NoticeMessage.WON_MESSAGE);
    }

    public boolean canPurchase(VendingMachine vendingMachine) {
        return vendingMachine.isExistDrinkBelow(inputMoney);
    }
}
