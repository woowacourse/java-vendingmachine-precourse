package vendingmachine.domain;

import vendingmachine.exception.MoneyPositiveIntegerValueException;
import vendingmachine.exception.MoneyShareByLeastCoin;

public class Money {

    private static final String INTEGER_REGEX = "[0-9]+";
    private static final int EMPTY_MONEY = 0;

    private int money;

    private Money(int money) {
        this.money = money;
    }

    public static Money init() {
        return new Money(EMPTY_MONEY);
    }

    public static Money valueOf(String inputMoney) {
        checkMoneyIntegerFormat(inputMoney);
        int money = Integer.parseInt(inputMoney);
        checkMoneyShareByLeastCoin(money);

        return new Money(money);
    }

    private static void checkMoneyIntegerFormat(String money) {
        if (!money.matches(INTEGER_REGEX)) {
            throw new MoneyPositiveIntegerValueException();
        }
    }

    private static void checkMoneyShareByLeastCoin(int money) {
        if (money % 10 != EMPTY_MONEY) {
            throw new MoneyShareByLeastCoin();
        }
    }

    public boolean isEmpty() {
        return money == EMPTY_MONEY;
    }

    public Coin cutOffByCoin(Coin coin) {
        checkCoinLargerThenRemainMoney(coin);
        money -= coin.amount();
        return coin;
    }

    private void checkCoinLargerThenRemainMoney(Coin coin) {
        if (money < coin.amount()) {
            throw new IllegalArgumentException("[ERROR] 차감하려는 동전이 현재 남아있는 금액보다 클 수 없습니다.");
        }
    }

    public void chargeMoney(Money chargeMoney) {
        this.money += chargeMoney.money;
    }

    public int currentMoney() {
        return money;
    }

    public boolean isDivisable(Coin coin) {
        return this.money / coin.amount() > 0;
    }

    public void useMoney(int money) {
        checkUseMoneyLargerThenRemainMoney(money);
        this.money -= money;
    }

    private void checkUseMoneyLargerThenRemainMoney(int money) {
        if (this.money < money) {
            throw new IllegalArgumentException("[ERROR] 차감하고자하는 금액이 현재 보유 금액보다 클 수 없습니다.");
        }
    }
}
