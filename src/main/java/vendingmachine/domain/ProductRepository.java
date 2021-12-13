package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.constant.Condition;

public class ProductRepository {
    private static final ProductRepository instance = new ProductRepository();
    private List<Product> products = new ArrayList<>();

    private ProductRepository() {
    }

    public static ProductRepository getInstance() {
        return instance;
    }

    public void addProduct(ArrayList<String> productInfoList) {
        Product product = new Product(productInfoList.get(Condition.INDEX_PRODUCT_NAME.getNumber()),
                Integer.parseInt(productInfoList.get(Condition.INDEX_PRODUCT_COST.getNumber())),
                Integer.parseInt(productInfoList.get(Condition.INDEX_PRODUCT_AMOUNT.getNumber())));

        products.add(product);
    }

    public boolean isMinCost(int money) {
        List<Product> productCollect = products.stream()
                .sorted().collect(Collectors.toList());

        for (Product product : productCollect) {
            if (product.getQuantity() < Condition.QUANTITY_1.getNumber()) {
                continue;
            }
            if (product.getCost() <= money) {
                return true;
            }
        }
        return false;
    }

    public boolean hasAllProductQuantity() {
        int allAmount = Condition.QUANTITY_0.getNumber();
        for (Product product : products) {
            allAmount += product.getQuantity();
        }

        if (allAmount > Condition.QUANTITY_0.getNumber()) {
            return true;
        }
        return false;
    }

    public void purchaseProduct(String productName) {
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                product.sellProduct();
            }
        }
    }

    public int useMoneyForProductPurchase(String productName) {
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                return product.getCost();
            }
        }
        return Condition.MONEY_0.getNumber();
    }

    public boolean hasSameProduct(String productName) {
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasProductQuantity(String productName) {
        List<Product> findProduct = products.stream().
                filter(product -> product.getName().equals(productName)).collect(Collectors.toList());
        if (findProduct.get(Condition.INDEX_0.getNumber()).getQuantity() == Condition.QUANTITY_0.getNumber()) {
            return false;
        }
        return true;
    }

    public boolean isProductExist(String productName) {
        boolean result = products.stream()
                .anyMatch(product -> product.getName().equals(productName));

        if (result) {
            return true;
        }
        return false;
    }

    public boolean canPurchaseProduct(String productName) {
        List<Product> findProduct = products.stream().
                filter(product -> product.getName().equals(productName)).collect(Collectors.toList());

        if (Money.isProductMoreExpensiveThanHasMoney(findProduct.get(Condition.INDEX_0.getNumber()).getCost())) {
            return false;
        }
        return true;
    }
}
