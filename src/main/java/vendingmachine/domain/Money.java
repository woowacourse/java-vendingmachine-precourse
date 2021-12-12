package vendingmachine.domain;

public class Money {

    private static final String MONEY_IS_INTEGER = "[ERROR] : 돈은 숫자로 구성되어야 합니다.";
    private static final String MONEY_IS_OVER_THAN_1 = "[ERROR] : 돈은 양의 정수 이어야 합니다.";

    private int amount = 0;

    public Money(int money) {
        this.amount = money;
    }

    public void add(String money) {
        validMoney(money);
        amount += Integer.parseInt(money);
    }

    private void validMoney(String stringMoney) {
        Integer money = 0;
        try {
            money = Integer.parseInt(stringMoney);
        } catch (Exception exception) {
            throw new IllegalArgumentException(MONEY_IS_INTEGER);
        }

        if (money <= 0) {
            throw new IllegalArgumentException(MONEY_IS_OVER_THAN_1);
        }
    }

    public void spend(int cost) {
        amount -= cost;
    }

    public int amount() {
        return amount;
    }
}
