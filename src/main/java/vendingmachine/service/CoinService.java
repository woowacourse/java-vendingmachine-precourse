package vendingmachine.service;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.repository.Coin;
import vendingmachine.view.InputView;

public class CoinService {
    InputView inputView = new InputView();

    public void generate() {
        int money = Integer.parseInt(inputView.getMoney());
        exchangeMoneyToCoin(money);
    }

    public void exchangeMoneyToCoin(int money) {
        for (Coin coin : Coin.values()) {
            if (coin.getAmount() != Coin.COIN_10.getAmount()) {
                money = generate500To100(coin, money);
                continue;
            }
            generate10(money);
        }
    }

    public int generate500To100(Coin coin, int money) {
        int random = Randoms.pickNumberInRange(0, money / coin.getAmount());
        coin.setStock(random);
        return money - coin.getAmount() * random;
    }

    public void generate10(int money) {
        Coin.COIN_10.setStock(money / Coin.COIN_10.getAmount());
    }

}
