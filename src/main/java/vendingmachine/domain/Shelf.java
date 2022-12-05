package vendingmachine.domain;

import vendingmachine.util.ErrorMessage;

import java.util.List;

public class Shelf {
    private final List<Product> products;

    public Shelf(List<Product> products) {
        this.products = products;
    }
    public boolean productExist(String productName){
        return products.stream().anyMatch(o -> o.equals(productName));
    }
    public int getMinPrice(){
        return products.stream()
                .mapToInt(Product::getPrice)
                .min()
                .orElseThrow(IllegalArgumentException::new);
    }
}
