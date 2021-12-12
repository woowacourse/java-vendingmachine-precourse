package vendingmachine.model.user;

import vendingmachine.model.drink.Drinks;

public class UserMoney {
    private int amount;

    public UserMoney(String inputMoney, Drinks drinks) {
        new UserMoneyValidator(inputMoney, drinks);
        this.amount = Integer.parseInt(inputMoney);
    }
}
