package vendingmachine.domain;

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
            throw new IllegalArgumentException("[ERROR] 금액은 양의 숫자여야 합니다.");
        }
    }

    private static void checkMoneyShareByLeastCoin(int money) {
        if (money % 10 != EMPTY_MONEY) {
            throw new IllegalArgumentException("[ERROR] 금액은 10원으로 나누어떨어지는 금액만 입력할 수 있습니다.");
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

    public void checkCoinLargerThenRemainMoney(Coin coin) {
        if (money < coin.amount()) {
            throw new IllegalArgumentException("[ERROR] 차감하려는 동전이 현재 남아있는 금액보다 클 수 없습니다.");
        }
    }

    public void chargeMoney(String money) {
        checkMoneyIntegerFormat(money);
        this.money += Integer.parseInt(money);
    }

    public int currentMoney() {
        return money;
    }
}
