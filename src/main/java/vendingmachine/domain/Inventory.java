package vendingmachine.domain;

import java.util.Map;

/**
 * 일급컬렉션
 */
public class Inventory {
    private final Map<String, Product> stockInfo;

    public Inventory(Map<String, Product> stockInfo) {
        this.stockInfo = stockInfo;
    }

    public int getMinGoodsPrice() {
        return stockInfo.values()
                .stream()
                .filter(Product::hasStock)
                .min(Product.priceComparator())
                .map(Product::getPrice)
                .orElse(0);
    }
}
