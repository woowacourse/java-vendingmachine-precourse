package vendingmachine.machine;

import vendingmachine.coin.Coin;
import vendingmachine.product.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Machine {
    private Map<Coin, Integer> coins;
    private List<Product> productList;
    private boolean isRun;
    private int money;

    public Machine(){
        initCoins();
        productList = new ArrayList<>();
    }

    public Map<Coin, Integer> getCoins() {
        return coins;
    }

    public List<Product> getProductList() {
        return productList;
    }

    private void initCoins(){
        Map<Coin, Integer> coins = new HashMap<>();
        for (Coin coin: Coin.values()) {
            coins.put(coin,0);
        }
        this.coins=coins;
    }

    public void insertMoney(int money){
        this.money=money;
    }
}
