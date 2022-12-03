package vendingmachine.moneyGenerator;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.Coin;

import java.util.Arrays;
import java.util.List;

public class VendingMachineMoneyGenrator {

    public void makeRandomCoin(String money) {
        int vendingMoney = Integer.parseInt(money);
        List<Integer> vendingMoneyList = Arrays.asList(500, 100, 50, 10);
        while (true) {
            int num = Randoms.pickNumberInList(vendingMoneyList);
            if (vendingMoney <= 0) break;
            if (vendingMoney - num < 0) {
                num = Randoms.pickNumberInList(vendingMoneyList);
                continue;
            }
            vendingMoney -= num;
            Coin.getCoin(num).addCoin();
        }


    }
}
