package vendingmachine.domain;

import java.util.ArrayList;
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

    public List<CoinCount> getRests(Money money) {
        List<CoinCount> ret = new ArrayList<>();
        int amount = money.getMoney();
        for(CoinCount c : coins) {
            int cnt = Math.min(c.getCount(), amount / c.getCoin().getPrice());
            if(cnt == 0) {
                continue;
            }
            ret.add(new CoinCount(c.getCoin(), cnt));
            amount -= cnt * c.getCoin().getPrice();
        }
        return ret;
    }
}
