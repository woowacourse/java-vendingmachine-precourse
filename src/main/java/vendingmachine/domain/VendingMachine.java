package vendingmachine.domain;

import java.util.HashMap;
import java.util.Map;
import vendingmachine.Coin;

public class VendingMachine {

    private static final String INTEGER_REGEX = "[0-9]+";

    private final Map<Coin, Integer> coins;

    public VendingMachine(Map<Coin, Integer> coins) {
        this.coins = coins;
    }

    public static VendingMachine createByMoney(String stringMoney) {
         checkMoneyIntegerFormat(stringMoney);
         int money = Integer.parseInt(stringMoney);
         checkMoneyShareByLeastCoin(money);

        return new VendingMachine(new HashMap<>());
    }

    private static void checkMoneyIntegerFormat(String money) {
        if (!money.matches(INTEGER_REGEX)) {
            throw new IllegalArgumentException("[ERROR] 금액은 양의 숫자여야 합니다.");
        }
    }

    private static void checkMoneyShareByLeastCoin(int money) {
        if (money % 10 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 10원으로 나누어떨어지는 금액만 입력할 수 있습니다.");
        }
    }
}
