package vendingmachine;

import dto.MoneyResponseDto;
import util.Validator;

public class Money {
    private int money = 0;

    public Money(int money) {
        Validator.validateDivisibleByMinimumMonetaryUnit(money);
        this.money = money;
    }

    public MoneyResponseDto toMoneyResponseDto() {
        return new MoneyResponseDto(money);
    }

    public boolean noMoney(int price) {
        return money < price;
    }

    public void subtract(int price) {
        money -= price;
    }
    public int getMoney() {
        return money;
    }
}
