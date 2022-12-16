package model;

import exception.ErrorMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class VendingMachine {

    private final List<Product> products;

    private Money money;


    public VendingMachine(String productGroup) {
        products = setProducts(productGroup);
    }

    public Money getMoney() {
        return money;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setMoney(Money money) {
        this.money = money;
    }

    public boolean isPossibleUsing() {
        return money.getAmount() >= minimumPrice();
    }


    public boolean isRemaining() {
        return products.stream().mapToInt(p -> p.getPrice())
                .allMatch(p -> p == 0);
    }

    public int minimumPrice() {
        return products.stream()
                .mapToInt(p -> p.getPrice())
                .min()
                .getAsInt();
    }


    public void buyProduct(String name) {
        Product product = findProduct(name);
        if (isPossibleBuy(product)) {
            product.decreaseAmount();
            decreaseMoney(product);
        }
    }

    public Product findProduct(String name) {
        return products.stream()
                .filter(p -> p.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NON_PRESENT_PRODUCT_ERROR_MESSAGE.getMessage()));
    }

    public boolean isPossibleBuy(Product product) {
        return product.getPrice() <= this.money.getAmount();
    }

    public void decreaseMoney(Product product) {
        this.money.removeMoney(product.getPrice());
    }

    public List<Product> setProducts(String productGroup) {
        List<String> parsedGroup = parseProductGroup(productGroup);
        return parsedGroup.stream().map(Product::new).collect(Collectors.toList());
    }

    public List<String> parseProductGroup(String productGroup) {
        String[] split = productGroup.split(";");
        return Arrays.stream(split).collect(Collectors.toList());
    }

}
