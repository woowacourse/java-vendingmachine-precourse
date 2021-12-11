package vendingmachine.Service;

import vendingmachine.Model.*;
import vendingmachine.SystemMessage.NoticeMessage;
import vendingmachine.View.*;

public class ReturnChange {
    private static User user;
    private static VendingMachine vendingMachine;
    private static OutputView outputView;

    public ReturnChange(User user, VendingMachine vendingMachine, OutputView outputView) {
        this.user = user;
        this.vendingMachine = vendingMachine;
        this.outputView = outputView;
    }

    public static void execute() {
        outputView.print(NoticeMessage.CHANGE_MESSAGE);
        vendingMachine.calculateChange(user, outputView);
    }
}
