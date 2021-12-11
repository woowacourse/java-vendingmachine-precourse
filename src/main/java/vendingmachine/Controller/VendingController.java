package vendingmachine.Controller;

import vendingmachine.Service.*;
import vendingmachine.View.*;
import vendingmachine.Model.*;
import vendingmachine.SystemMessage.*;

public class VendingController {

    private static InputView inputView;
    private static OutputView outputView;
    private static VendingMachine vendingMachine;
    private static User user;

    public VendingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public static void start() {
        MachineSetting machineSetting = new MachineSetting(inputView, outputView);
        vendingMachine = machineSetting.execute();
        UserSetting userSetting = new UserSetting(inputView, outputView);
        user = userSetting.execute();
        outputView.print(NoticeMessage.INPUT_MONEY_MESSAGE + user.getRemainMoney() + NoticeMessage.WON_MESSAGE);
        Transaction transaction = new Transaction(user, vendingMachine, inputView, outputView);
        user = transaction.execute();
        ReturnChange returnChange = new ReturnChange(user, vendingMachine, inputView, outputView);
        returnChange.execute();
    }
}
