package vendingmachine.Service;

import vendingmachine.Model.*;
import vendingmachine.SystemMessage.NoticeMessage;
import vendingmachine.Validator.Validator;
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
            outputView.print(NoticeMessage.INPUT_MONEY_MESSAGE + user.getRemainMoney() + NoticeMessage.WON_MESSAGE);
        }
        return user;
    }

    private static void tryPurchase() {
        Drink chosenDrink;
        System.out.println(NoticeMessage.ASK_DRINK_NAME_MESSAGE);
        do {
            chosenDrink = getUserChoice();
        } while (!Validator.isRemained(chosenDrink));

        chosenDrink.subtractStock();
        user.pay(chosenDrink);
    }

    private static Drink getUserChoice() {
        String userChoice;
        do {
            userChoice = inputView.getInput();
        } while (!Validator.isValidateChoice(userChoice, vendingMachine));
        return vendingMachine.findDrinkWithName(userChoice);
    }

    private static boolean isEnd() {
        if (vendingMachine.isEmpty() || !user.isPurchasable(vendingMachine.getMinimumPrice())) {
            return true;
        }
        return false;
    }
}
