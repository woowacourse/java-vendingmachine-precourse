package vendingmachine.domain;

import vendingmachine.utils.Message;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static vendingmachine.domain.Product.isZeroQuantity;


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

    public int buy(int balance,String name){
        Product product = findByName(name);
        this.balance = balance;
        if(this.balance - product.getPrice() < 0){
            throw new IllegalArgumentException(Message.IS_OVER_BALANCE);
        }
        this.balance -= product.getPrice();
        product.subQuantity();
        return this.balance;
    }


    public boolean isBalanceBigger(int balance){
        if(balance > this.change){
            return true;
        }
        return false;
    }

    public int[] coinsToArray(){
       return this.coins.stream()
               .mapToInt(i->i)
               .toArray();
    }


    public boolean availableCheck(int balance){
        int minPrice = findMinPrice();
        if(balance < minPrice){
            return false;
        }

        if(isZeroQuantity(findByPrice(minPrice))){
            return false;
        }

        List<Integer> quantities = findAllQuantity();
        if(quantities.stream().mapToInt(Integer::intValue).sum() == 0){
            return false;
        }

        return true;
    }

    public Product findByPrice(int price){
        return products.stream()
                .filter(product -> product.getPrice() == price)
                .findAny()
                .get();
    }

    public int findMinPrice(){
        return products.stream()
                .mapToInt(product -> product.getPrice())
                .min()
                .getAsInt();
    }

    public List<Integer> findAllQuantity(){
        return products.stream()
                .map(Product::getPrice)
                .collect(Collectors.toList());
    }

    private Product findByName(String name){
        return products.stream()
                .filter(product -> name.equals(product.getName()))
                .findAny()
                .orElseThrow(()->new IllegalArgumentException(Message.ERROR + Message.IS_NOT_FOUNDED_PRODUCT));
    }


}
