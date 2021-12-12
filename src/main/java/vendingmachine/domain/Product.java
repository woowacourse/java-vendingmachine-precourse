package vendingmachine.domain;

import vendingmachine.utils.Message;

import java.util.List;
import java.util.stream.Collectors;

public class Product {
    private String name;
    private int price;
    private int quantity;

    public Product(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }


    public void subQuantity() {
        if (this.quantity == 0) {
            throw new IllegalArgumentException(Message.IS_OUT_OF_STOCK);
        }
        this.quantity -= 1;
    }

    public static boolean isZeroQuantity(Product product) {
        if (product.quantity == 0) {
            return true;
        }
        return false;
    }

    public boolean isEnoughBalance(int balance,Product product){
        if(balance - product.price < 0){
            return false;
        }
        return true;
    }

    public static boolean isZeroQuantity(List<Product> products){
        List<Integer> quantityList = products.stream()
                .map(product -> product.price)
                .collect(Collectors.toList());
        if (quantityList.stream().mapToInt(Integer::intValue).sum() == 0) {
            return true;
        }
        return false;
    }

    public boolean isEqualPrice(int price, Product product){
        if(price == product.price){
            return true;
        }
        return false;
    }

    public boolean isEqualName(String name, Product product){
        if(name.equals(product.name)){
            return true;
        }
        return false;
    }

    public int subPriceFromBalnace(int balance,Product product){
        return balance - product.price;
    }

    public static int findMinPrice(List<Product> products) {
        return products.stream()
                .mapToInt(product -> product.price)
                .min()
                .getAsInt();
    }

}
