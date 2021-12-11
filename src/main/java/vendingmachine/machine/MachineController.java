package vendingmachine.machine;

import vendingmachine.coin.Coin;
import vendingmachine.coin.CoinController;

import java.util.Map;

public class MachineController {
    private final CoinController coinController = new CoinController();

    private void makeCoins(Machine machine,int money) {
        Map<Coin, Integer> coins = machine.getCoins();
        while( money > 0 ){
            Coin coin = coinController.pickPossibleRandomCoin(money);
            coins.put(coin ,coins.get(coin)+1); //선택된 코인 1개 증가
            money-=coin.getAmount();
        }
    }
}
