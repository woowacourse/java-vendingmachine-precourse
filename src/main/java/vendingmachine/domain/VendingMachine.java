package vendingmachine.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class VendingMachine {
    private int amount;
    private List<Integer> coins;
    private List<Product> products = new ArrayList<>();

    public VendingMachine(int amount, List<String> productList){
        this.amount = amount;
        setCoins();
        setProducts(productList);
    }

    private void setCoins(){
        int nowPrice = this.amount;
        int[] coinList = new int[4];
        while(nowPrice > 0){
            for(Coin coin : Coin.values()) {
                int quantity = coin.convertPriceToCoins(coin, nowPrice);
                coinList[coin.ordinal()] += quantity;
                nowPrice -= coin.calculate(quantity);
            }
        }
        this.coins = Arrays.stream(coinList)
                .boxed()
                .collect(Collectors.toList());
    }

    private void setProducts(List<String> productList){
        for(int i =0 ;i < productList.size(); i+=3){
            String name = productList.get(i);
            int price = Integer.valueOf(productList.get(i+1));
            int quantity = Integer.valueOf(productList.get(i+2));
            Product product = new Product(name,price,quantity);
            this.products.add(product);
        }
    }

}
