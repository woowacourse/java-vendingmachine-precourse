package vendingmachine.domain.VendingMachine;

import java.util.List;
import java.util.stream.Collectors;

public class Wallet {
    private final List<CoinCount> coins;

    public Wallet(int money) {
        validateMoney(money);
        coins = CoinCount.build(money);
    }

    private void validateMoney(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 0원 이상이어야 합니다!");
        }
    }

    public String getMessage() {
        return coins.stream()
                .map(CoinCount::getMessage)
                .collect(Collectors.joining("\n"));
    }

}
