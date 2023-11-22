package vendingmachine.domain;

import static vendingmachine.exception.ErrorCode.INVALID_PRODUCT_INFO;
import static vendingmachine.exception.ErrorCode.INVALID_PRODUCT_REQUEST;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import vendingmachine.converter.Parser;
import vendingmachine.dto.ProductDTO;

/**
 * 일급컬렉션
 */
public class Stock {
    private final Map<String, Product> stockInfo;

    private Stock(List<ProductDTO> productDTO) {
        validate(productDTO);
        this.stockInfo = Parser.parseToStockMap(productDTO);
    }

    public static Stock create(List<ProductDTO> stockInfo) {
        return new Stock(stockInfo);
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
                Product.create(product.getPrice(), product.getRemainStock()));

        return replace.getPrice();
    }

    private Product getInStockProduct(String productName) {
        stockInfo.entrySet()
                .stream()
                .filter(product -> isInStock(productName, product))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_PRODUCT_REQUEST.getMessage()));
        return stockInfo.get(productName);
    }

    private boolean isInStock(String productName, Entry<String, Product> product) {
        return product.getKey().equals(productName) && product.getValue().hasStock();
    }

    private void validate(List<ProductDTO> productDTO) {
        boolean isNotValid = productDTO.stream()
                .noneMatch(this::isValidStock);
        if (isNotValid) {
            throw new IllegalArgumentException(INVALID_PRODUCT_INFO.getMessage());
        }
    }

    private boolean isValidStock(ProductDTO productDTO) {
        return isPriceValid(productDTO.price()) && isQuantityValid(productDTO.quantity());
    }

    private boolean isQuantityValid(int quantity) {
        return quantity > 0;
    }

    private boolean isPriceValid(int price) {
        //TODO: 상수로 빼내기
        return (price >= 100) && (price % 10 == 0);
    }
}
