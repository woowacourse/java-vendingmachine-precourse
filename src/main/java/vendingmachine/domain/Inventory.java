package vendingmachine.domain;

import static vendingmachine.error.ErrorCode.INVALID_PRODUCT_NAME;

import java.util.Map;
import java.util.Map.Entry;

/**
 * 일급컬렉션
 */
public class Inventory {
    private final Map<String, Product> stockInfo;

    private Inventory(Map<String, Product> stockInfo) {
        this.stockInfo = stockInfo;
    }

    public static Inventory create(Map<String, Product> stockInfo) {
        return new Inventory(stockInfo);
    }

    public int getMinGoodsPrice() {
        return stockInfo.values()
                .stream()
                .filter(Product::hasStock)
                .min(Product.priceComparator())
                .map(Product::getPrice)
                .orElse(0); // TODO: 0을 반환하면 안될듯
    }

    public boolean isRunOutOfStock() {
        return stockInfo.values()
                .stream()
                .noneMatch(Product::hasStock);
    }

    public int decreaseStock(String productName) {
        Product product = getInStockProduct(productName);
        //TODO: 이름 바꾸기
        Product replace = stockInfo.replace(productName,
                Product.create(productName, product.getPrice(), product.getRemainStock()));

        return replace.getPrice();
    }

    private Product getInStockProduct(String productName) {
        stockInfo.entrySet()
                .stream()
                .filter(product -> isInStock(productName, product))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_PRODUCT_NAME.getMessage()));
        return stockInfo.get(productName);
    }

    private boolean isInStock(String productName, Entry<String, Product> product) {
        return product.getKey().equals(productName) && product.getValue().hasStock();
    }
}
