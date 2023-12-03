package vendingmachine.domain;

import vendingmachine.constants.Coin;
import vendingmachine.domain.VendingMachine.CoinCount;
import vendingmachine.util.Validator;

public class Money {
    private final int money;

    public Money(int money) {
        this.money = money;
    }

    public static Money of(String string) {
        Validator.validateNumber(string);
        return new Money(Integer.parseInt(string));
    }

    public int getMoney() {
        return money;
    }

    public Money reduce(int reduce) {
        return new Money(money - reduce);
    }

    public String getRestMessage() {
        StringBuilder stringBuilder = new StringBuilder();
        int money = this.money;
        for(Coin c : Coin.getSortedCoins()) {
            if(c.getPrice() <= money) {
                stringBuilder.append(new CoinCount(c, money / c.getPrice()).getMessage());
            }
            money %= c.getPrice();
        }
        return stringBuilder.toString();
    }
}
