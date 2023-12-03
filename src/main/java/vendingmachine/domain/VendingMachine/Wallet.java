package vendingmachine.domain.VendingMachine;

import java.util.List;
import java.util.stream.Collectors;

public class Wallet {
    private final List<CoinCount> coins;

    public Wallet(int money) {
        coins = CoinCount.build(money);
    }

    public String getMessage() {
        return coins.stream()
                .map(CoinCount::getMessage)
                .collect(Collectors.joining("\n"));
    }

}
