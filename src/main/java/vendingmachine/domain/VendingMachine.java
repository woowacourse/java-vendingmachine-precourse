package vendingmachine.domain;

import java.util.*;

public class VendingMachine {

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
        Comparator<Product> comparatorByPrice = Comparator.comparingInt(Product::getPrice);

        Optional<Product> optionalProduct = productList.stream().max(comparatorByPrice);

        Product maxProduct = optionalProduct
                .orElseThrow(IllegalArgumentException::new);

        int price = money.getPrice();

        if (price >= maxProduct.getPrice()) {
            return true;
        }

        return false;
    }
}
