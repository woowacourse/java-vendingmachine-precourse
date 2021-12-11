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
//        this.coins=makeCoins(money);

    }

    public Map<Coin, Integer> getCoins() {
        return coins;
    }


    private void initCoins(){
        Map<Coin, Integer> coins = new HashMap<>();
        for (Coin coin: Coin.values()) {
            coins.put(coin,0);
        }
        this.coins=coins;
    }

}
