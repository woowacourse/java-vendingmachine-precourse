package vendingmachine.domain;

import java.util.*;

public class VendingMachine {

    private static final int ZERO = 0;

    private Change change;
    private Money money;
    private List<Product> productList = new ArrayList<>();

    public VendingMachine() {
    }

    public void inputMoney(Money money) {
        this.money = money;
    }

    public void createChange(Change change) {
        this.change = change;
    }

    public void inputProducts(List<Product> productList) {
        this.productList = productList;
    }

    public Change returnChange() {
        return change;
    }

    public Money getMoney() {
        return money;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public int getRestMoney() {
        return money.getPrice();
    }

    public void extractProduct(String productName) {
        for (Product product : productList) {
            if (product.getProductName().equals(productName)) {
                int price = product.getPrice();
                money.reduce(price);

                product.reduceQuantity();

                return;
            }
        }
    }

    public boolean checkProgress() {
        try {
            if (checkMoney() == true && checkQuantity() == true) {
                return true;
            }
        } catch(IllegalArgumentException e) {
            return false;
        }

        return false;
    }

    private boolean checkMoney() {
        Comparator<Product> comparatorByPrice = Comparator.comparingInt(Product::getPrice);

        Optional<Product> optionalProduct = productList
                .stream()
                .filter(p -> p.getQuantity() > 0)
                .min(comparatorByPrice);

        Product minProduct = optionalProduct
                .orElseThrow(IllegalArgumentException::new);

        int price = money.getPrice();

        if (price >= minProduct.getPrice()) {
            return true;
        }

        return false;
    }

    private boolean checkQuantity() {
        int sumQuantity = ZERO;

        for (Product product : productList) {
            sumQuantity = sumQuantity + product.getQuantity();
        }

        if (sumQuantity == ZERO) {
           return false;
        }

        return true;
    }
}
