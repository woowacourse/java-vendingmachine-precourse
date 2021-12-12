package vendingmachine.Service;

import vendingmachine.Model.*;
import vendingmachine.SystemMessage.NoticeMessage;
import vendingmachine.Validator.*;
import vendingmachine.View.*;

public class Transaction {
    private static User user;
    private static VendingMachine vendingMachine;
    private static InputView inputView;
    private static OutputView outputView;

    public Transaction(User user, VendingMachine vendingMachine, InputView inputView, OutputView outputView) {
        this.user = user;
        this.vendingMachine = vendingMachine;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public static User execute() {
        while (!isEnd()) {
            tryPurchase();
            outputView.print(user.toString());
        }
        return user;
    }

    private static void tryPurchase() {
        Drink selectedDrink;
        System.out.println(NoticeMessage.ASK_DRINK_NAME_MESSAGE);
        do {
            selectedDrink = getUserChoice();
        } while (!TransactionValidator.isRemained(selectedDrink));

        selectedDrink.subtractStock();
        user.pay(selectedDrink);
    }

    private static Drink getUserChoice() {
        String userChoice;
        do {
            userChoice = inputView.getInput();
        } while (!TransactionValidator.isValidateChoice(userChoice, vendingMachine));
        return vendingMachine.findDrinkWithName(userChoice);
    }

    private static boolean isEnd() {
        if (vendingMachine.isEmpty() || !user.canPurchase(vendingMachine)) {
            return true;
        }
        return false;
    }
}
