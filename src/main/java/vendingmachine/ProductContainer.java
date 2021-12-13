package vendingmachine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class ProductContainer {

    Map<String, Product> productMap = new HashMap<>();

    public ProductContainer(List<Product> productList) {
        productList.forEach(product -> productMap.put(product.getName(), product));
    }

    public int getPrice(String productName) {
        checkProductInContainer(productName);
        return productMap.get(productName).getPrice();
    }

    public void sellProduct(String productName) {
        checkProductInContainer(productName);
        productMap.get(productName).sell();
    }

    public int getMinimumPrice() {
        return productMap.values().stream()
                                    .filter(product -> product.getStockQuantity() != 0)
                                    .mapToInt(Product::getPrice)
                                    .min()
                                    .orElse(Integer.MAX_VALUE);
    }

    public boolean isAllSoldOut() {
        return productMap.values().stream()
                                    .filter(product -> !product.isSoldOut())
                                    .collect(Collectors.toList())
                                    .isEmpty();
    }

    private void checkProductInContainer(String productName) {
        if (!productMap.keySet().contains(productName)) {
            throw new NoSuchElementException(ErrorMessage.NO_PRODUCT_MATCH.getCompleteMessage());
        }
    }
}
