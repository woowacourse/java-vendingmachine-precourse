package vendingmachine.domain;

import vendingmachine.utils.Message;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class VendingMachine {
    private int change;
    private int balance;
    private List<Integer> coins;
    private List<Product> products;

    public VendingMachine(int change, int[] coinList, List<String> productList){
        this.change = change;
        this.coins = setCoins(coinList);
        this.products = setProducts(productList);
    }

    public List<Product> getProducts() {
        return products;
    }

    public int buy(int balance, Product product){
        this.balance = balance;
        this.balance -= product.getPrice();
        product.subQuantity();
        return this.balance;
    }

    private List<Integer> setCoins(int[] coinList){
        return Arrays.stream(coinList)
                .boxed()
                .collect(Collectors.toList());
    }

    private List<Product> setProducts(List<String> productList){
        List<Product> products = new ArrayList<>();
        for(int i =0 ;i < productList.size(); i+=3){
            String name = productList.get(i);
            int price = Integer.valueOf(productList.get(i+1));
            int quantity = Integer.valueOf(productList.get(i+2));
            Product product = new Product(name,price,quantity);
            products.add(product);
        }
        return products;
    }

}
