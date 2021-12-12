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

    public static VendingMachine createByMoney(String money) {
         checkMoneyIntegerFormat(money);

        return new VendingMachine(new HashMap<>());
    }

    private static void checkMoneyIntegerFormat(String money) {
        if (!money.matches(INTEGER_REGEX)) {
            throw new IllegalArgumentException("[ERROR] 금액은 양의 숫자여야 합니다.");
        }
    }
}
