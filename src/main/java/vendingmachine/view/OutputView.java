package vendingmachine.view;

import java.util.HashMap;
import java.util.List;

public class OutputView {

    public void vendingMachineCoin(StringBuilder sb) {
        System.out.println(GameMessage.OUTPUT_VENDINGMACHINE_MONEY);
        System.out.println(sb);
    }

    public void remainMoney(int price) {
        System.out.println(GameMessage.OUTPUT_USER_MONEY + price + "원");
    }

    public void returnCoinList(HashMap<Integer, Integer> coinList) {
        System.out.println(GameMessage.OUTPUT_REMAIN_MONEY);
        for (Integer key : coinList.keySet()) {
            if (coinList.get(key) != 0) System.out.println(key + "원 - " + coinList.get(key) + "개");
        }
    }
}
