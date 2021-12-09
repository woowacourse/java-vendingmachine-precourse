package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.util.Arrays;
import vendingmachine.Coin;
import vendingmachine.view.InputView;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VendingMachine {

    private final HashMap<Integer, Integer> coins = new HashMap<>();

    public VendingMachine() {
        int totalMoney = InputView.getVendingMachineTotalMoneyInput();

        for (Coin value : Coin.values()) {
            this.coins.put(value.getAmount(), 0);
        }
        List<Integer> coinTypes = Stream.of(10, 50, 100, 500).collect(Collectors.toList());

        while (totalMoney > 0) {
            int randomCoin = Randoms.pickNumberInList(coinTypes);
            if (totalMoney >= randomCoin) {
                coins.put(randomCoin, coins.get(randomCoin)+1);
                totalMoney -= randomCoin;
            }
        }
    }
}
