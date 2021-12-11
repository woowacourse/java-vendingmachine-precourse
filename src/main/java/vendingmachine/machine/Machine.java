package vendingmachine.machine;

import vendingmachine.Coin;
import vendingmachine.product.Product;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInList;

public class Machine {
    private Map<Coin, Integer> coins;
    private List<Product> productList;
    private boolean isRun;



    public Machine(int money){
        initCoins();
        makeCoins(money);
    }

    public Map<Coin, Integer> getCoins() {
        return coins;
    }

    private void makeCoins(int money) {
        while( money > 0 ){
            int coinPrice= pickNumberInList(Coin.getPossibleAmountList(money));
            Coin coin = Coin.findCoinByPrice(coinPrice);
            coins.put(coin ,coins.get(coin)+1); //선택된 코인 1개 증가
            money-=coinPrice;
        }
    }

    private void initCoins(){
        Map<Coin, Integer> coins = new HashMap<>();
        for (Coin coin: Coin.values()) {
            coins.put(coin,0);
        }
        this.coins=coins;
    }

}
