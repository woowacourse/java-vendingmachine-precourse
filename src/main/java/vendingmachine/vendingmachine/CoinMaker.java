package vendingmachine.vendingmachine;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class CoinMaker {

    public void randomCoin(String money) {
        int vendingMoney = Integer.parseInt(money);
        List<Integer> vendingMoneyList = Arrays.asList(500, 100, 50, 10);

        while (vendingMoney != 0) {
            int num = Randoms.pickNumberInList(vendingMoneyList);
            if (vendingMoney - num >= 0) {
                vendingMoney -= num;
                Coin.getCoin(num).addCoin();
            }
        }

    }

    public HashMap<Integer, Integer> remainCoinList(int money) {
        HashMap<Integer, Integer> coinList = new LinkedHashMap<>();

        for (Coin coin : Coin.values()) {
            if (money <= 0) break;
            int require = money / coin.getAmount();

            if (require > coin.getCount()) {
                money -= (coin.getCount() * coin.getAmount());
                coinList.put(coin.getAmount(), coin.getCount());
                continue;
            }

            money -= (require * coin.getAmount());
            coinList.put(coin.getAmount(), require);
        }
        return coinList;
    }


}