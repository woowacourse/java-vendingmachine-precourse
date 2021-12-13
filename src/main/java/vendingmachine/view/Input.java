package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.model.coin.MachineMoney;
import vendingmachine.model.drink.DrinkMapper;
import vendingmachine.model.drink.Drinks;
import vendingmachine.model.user.ChoiceDrink;
import vendingmachine.model.user.UserMoney;
import vendingmachine.util.Message;

public class Input {
    public MachineMoney inputMachineMoney() {
        try {
            Output.printGuideMessage(Message.INPUT_MACHINE_MONEY_GUIDE);
            return new MachineMoney(Console.readLine());
        } catch (IllegalArgumentException e) {
            Output.printErrorMessage(e.getMessage());
            return inputMachineMoney();
        }
    }

    public Drinks inputDrinks(DrinkMapper mapper) {
        try {
            Output.printGuideMessage(Message.INPUT_DRINKS_GUIDE);
            return new Drinks(Console.readLine(), mapper);
        } catch (IllegalArgumentException e) {
            Output.printErrorMessage(e.getMessage());
            return inputDrinks(mapper);
        }
    }

    public UserMoney inputUserMoney(Drinks drinks) {
        try {
            Output.printGuideMessage(Message.INPUT_USER_MONEY_GUIDE);
            return new UserMoney(Console.readLine(), drinks);
        } catch (IllegalArgumentException e) {
            Output.printErrorMessage(e.getMessage());
            return inputUserMoney(drinks);
        }
    }

    public ChoiceDrink inputChoiceDrink(Drinks drinks) {
        try {
            Output.printGuideMessage(Message.INPUT_CHOICE_DRINK);
            return new ChoiceDrink(Console.readLine(), drinks);
        } catch (IllegalArgumentException e) {
            Output.printErrorMessage(e.getMessage());
            return inputChoiceDrink(drinks);
        }
    }
}
