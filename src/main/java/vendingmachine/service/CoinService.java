package vendingmachine.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.repository.Coin;
import vendingmachine.view.InputView;

public class CoinService {
    InputView inputView = new InputView();
    CoinValidator coinValidator = new CoinValidator();

    public void generate() {
        while (true) {
            try {
                String money = inputView.getMoney();
                coinValidator.isValid(money);
                exchangeMoneyToCoin(Integer.parseInt(money));
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void exchangeMoneyToCoin(int money) {
        List<Integer> number = new ArrayList<>(Arrays.asList(500, 100, 50, 10));
        HashMap<Integer, String> numberMap = new HashMap<>();
        numberMap = makeNumberMap(numberMap);
        while (money != 0) {
            int randomCoin = Randoms.pickNumberInList(number);
            if (randomCoin <= money) {
                Coin coin = Coin.valueOf(numberMap.get(randomCoin));
                coin.addStock();
                money -= randomCoin;
            }
        }
    }

    public HashMap<Integer, String> makeNumberMap(HashMap<Integer, String> numberMap) {
        numberMap.put(500, "COIN_500");
        numberMap.put(100, "COIN_100");
        numberMap.put(50, "COIN_50");
        numberMap.put(10, "COIN_10");
        return numberMap;
    }
}
