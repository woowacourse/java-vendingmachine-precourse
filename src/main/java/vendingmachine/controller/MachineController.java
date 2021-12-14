package vendingmachine.controller;

import vendingmachine.model.Machine;
import vendingmachine.model.coin.Change;
import vendingmachine.model.coin.MachineMoney;
import vendingmachine.model.drink.DrinkMapper;
import vendingmachine.model.drink.Drinks;
import vendingmachine.model.user.ChoiceDrink;
import vendingmachine.model.user.UserMoney;
import vendingmachine.util.Message;
import vendingmachine.view.Input;
import vendingmachine.view.Output;

public class MachineController {
    private Change change;

    public void run() {
        initChange();
        Drinks drinks = Input.drinks(new DrinkMapper());
        UserMoney userMoney = createUserMoney(drinks);
        Machine machine = new Machine(drinks, userMoney);
        buyCycle(machine);
        Output.changeStatus(change.createChange(userMoney));
    }

    private void buyCycle(Machine machine) {
        while (machine.isContinue()) {
            buy(machine);
        }
        Output.joinMessage(Message.USER_MONEY_STATUS, machine.toMoney());
        Output.guideMessage(Message.CHANGE_STATUS);
    }

    private void buy(Machine machine) {
        try {
            Output.joinMessage(Message.USER_MONEY_STATUS, machine.toMoney());
            ChoiceDrink buyItem = Input.choiceDrink();
            machine.buy(buyItem);
        } catch (IllegalArgumentException e) {
            Output.errorMessage(e.getMessage());
            buy(machine);
        }
    }

    private void initChange() {
        MachineMoney machineMoney = Input.machineMoney();
        this.change = new Change(machineMoney);
        Output.guideMessage(Message.COIN_STATUS);
        Output.changeStatus(change.getCoins());
    }

    private UserMoney createUserMoney(Drinks drinks) {
        UserMoney userMoney = Input.userMoney();
        try {
            drinks.moneyOverMinPriceDrink(userMoney);
        } catch (IllegalArgumentException e) {
            Output.errorMessage(e.getMessage());
            return createUserMoney(drinks);
        }
        return userMoney;
    }
}
