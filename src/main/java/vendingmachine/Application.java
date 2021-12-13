package vendingmachine;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> coins = new ArrayList<Integer>();
        for(Coin coin : Coin.values()){
            coins.add(coin.getValue());
        }
        Integer inputmoney = Utils.vendMoneyInput();
        int[] randomList = Utils.generateRandomCoin(coins,inputmoney);
        Utils.printRandomCoin(coins, randomList);
        Utils.prodInput();
    }
}
