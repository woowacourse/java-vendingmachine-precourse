package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.model.coin.MachineMoney;
import vendingmachine.model.drink.DrinkMapper;
import vendingmachine.model.drink.Drinks;
import vendingmachine.model.user.ChoiceDrink;
import vendingmachine.model.user.UserMoney;
import vendingmachine.util.Message;

public class Input {

    private Input() {
    }

    public static MachineMoney machineMoney() {
        try {
            Output.guideMessage(Message.INPUT_MACHINE_MONEY_GUIDE);
            return new MachineMoney(Console.readLine());
        } catch (IllegalArgumentException e) {
            Output.errorMessage(e.getMessage());
            return machineMoney();
        }
    }

    public static Drinks drinks(DrinkMapper mapper) {
        try {
            Output.guideMessage(Message.INPUT_DRINKS_GUIDE);
            return new Drinks(Console.readLine(), mapper);
        } catch (IllegalArgumentException e) {
            Output.errorMessage(e.getMessage());
            return drinks(mapper);
        }
    }

    public static UserMoney userMoney() {
        try {
            Output.guideMessage(Message.INPUT_USER_MONEY_GUIDE);
            return new UserMoney(Console.readLine());
        } catch (IllegalArgumentException e) {
            Output.errorMessage(e.getMessage());
            return userMoney();
        }
    }

    public static ChoiceDrink choiceDrink() {
        Output.guideMessage(Message.INPUT_CHOICE_DRINK);
        return new ChoiceDrink(Console.readLine());
    }
}
