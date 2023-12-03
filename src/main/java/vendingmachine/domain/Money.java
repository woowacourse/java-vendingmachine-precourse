package vendingmachine.domain;

import vendingmachine.constants.Coin;
import vendingmachine.util.Validator;

import java.util.List;
import java.util.stream.Collectors;

public class Money {
    private int money;

    private Money(int money) {
        this.money = money;
    }

    public static Money of(String string) {
        Validator.validateNumber(string);
        return new Money(Integer.parseInt(string));
    }

    public int getMoney() {
        return money;
    }

    public void reduce(int reduce) {
        money -= reduce;
    }

    public String getRestMessage() {
        return CoinCount.build(money).stream()
                .filter(coinCount -> !coinCount.isZero())
                .map(CoinCount::getMessage)
                .collect(Collectors.joining("\n"));
    }
}
