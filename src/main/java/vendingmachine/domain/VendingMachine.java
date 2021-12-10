package vendingmachine.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class VendingMachine {
    private List<Integer> coins;
    private List<Product> products;

    public VendingMachine(int[] coinList, List<String> productList){
        this.coins = setCoins(coinList);
        this.products = setProducts(productList);
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
        System.out.println(products);
        return products;
    }

}
