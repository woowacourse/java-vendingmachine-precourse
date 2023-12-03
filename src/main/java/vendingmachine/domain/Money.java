package vendingmachine.domain;

import vendingmachine.constants.Coin;
import vendingmachine.util.Validator;

import java.util.List;
import java.util.stream.Collectors;

public class Money {
    private int money;

    private Money(int money) {
        validateMoney(money);
        this.money = money;
    }

    private void validateMoney(int money) {
        if(money < 0) {
            throw new IllegalArgumentException("[ERROR] 금액이 0 미만이 될 수 없습니다!");
        }
    }

    public static Money of(String string) {
        Validator.validateNumber(string);
        return new Money(Integer.parseInt(string));
    }

    public int getMoney() {
        return money;
    }

    public void reduce(int reduce) {
        validateMoney(money - reduce);
        money -= reduce;
    }

    public String getRestMessage() {
        return CoinCount.build(money).stream()
                .filter(coinCount -> !coinCount.isZero())
                .map(CoinCount::getMessage)
                .collect(Collectors.joining("\n"));
    }
}
