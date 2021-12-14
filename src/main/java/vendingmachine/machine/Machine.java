package vendingmachine.machine;

import vendingmachine.coin.Coin;
import vendingmachine.product.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Machine {
    private Map<Coin, Integer> coins;
    private List<Product> productList;
    private int money;
    // private int userMoney;

    public Machine(){
        initCoins();
        productList = new ArrayList<>();
        money=0;
    }

    public Map<Coin, Integer> getCoins() {
        return coins;
    }

    public int getMoney() {
        return money;
    }

    public boolean isRun() {
        if ( !existStock() || !canBuyAny() ){
            return false;
        }
        return true;
    }

    public boolean existStock(){
        int noStock = productList.stream()
            .filter(product -> product.getStock() <= 0)
            .collect(Collectors.toList())
            .size();
        if (noStock >0){
            return false;
        }
        return true;
    }

    public boolean canBuyAny(){
        int canBuy = productList.stream()
            .filter(product -> product.getPrice() <= money)
            .collect(Collectors.toList())
            .size();
        if (canBuy > 0){
            return true;
        }
        return false;
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

    public boolean isIn(String product){
        List<String> productNames = productList.stream()
            .map(Product::getName).collect(Collectors.toList());
        for (String name : productNames){
            if (name.equals(product)){
                return true;
            }
        }
        return false;

    }

    public Product findProduct(String productName){
        return productList.stream()
            .filter(p -> p.isSame(productName))
            .collect(Collectors.toList())
            .get(0);
    }

    public void buyProduct(String productName){
        Product product = findProduct(productName);
        product.buy();
        money-=product.getPrice();
    }

    public void returnMoney(){
        coins.entrySet().stream()
            .filter(coinIntegerEntry -> coinIntegerEntry.getValue() > 0)
            .sorted(Comparator.comparingInt(value -> -value.getKey().getAmount()))
            .forEach(entry -> {
                int changesNum = giveChanges(entry.getKey(), entry.getValue());
                System.out.println(entry.getKey().getAmount()+"원 - "+changesNum+"개");
            });
    }

    private int giveChanges(Coin coin,int coinNum){
        int coinAmount = coin.getAmount();
        int changesNum=money/coinAmount;

        money%=coinAmount;
        coins.put(coin,coinNum-(changesNum));
        return changesNum;
    }



}
