package vendingmachine.Service;

import vendingmachine.Model.User;
import vendingmachine.SystemMessage.NoticeMessage;
import vendingmachine.Validator.*;
import vendingmachine.View.*;

public class UserSetting {
    private static InputView inputView;
    private static OutputView outputView;

    public UserSetting(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public static User execute() {
        return new User(getUserMoneyInput());
    }

    private static int getUserMoneyInput() {
        String input;
        outputView.print(NoticeMessage.ASK_MONEY_INPUT_MESSAGE);
        do {
            input = inputView.getInput();
        } while (!MoneyValidator.isValidateMoney(input));
        return Integer.parseInt(input);
    }
}
