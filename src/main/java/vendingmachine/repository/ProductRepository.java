package vendingmachine.repository;

import static vendingmachine.ErrorMessage.*;

import java.util.LinkedHashMap;

import vendingmachine.domain.Price;
import vendingmachine.domain.Product;

public class ProductRepository {
    LinkedHashMap<String, Product> productRepository = new LinkedHashMap<>(); // String key는 상품의 이름이다.

    public void clear() {
        productRepository.clear();
    }

    public void add(Product product) {
        validateAlreadyHave(product);
        productRepository.put(product.getName(), product);
    }

    private void validateAlreadyHave(Product product) {
        if (productRepository.containsKey(product.getName())) {
            throw new IllegalArgumentException(HAVE_SAME_PRODUCT_ERROR_MESSAGE);
        }
    }

    public boolean has(String productName) {
        return productRepository.containsKey(productName);
    }

    public int takeout(String productName, Price userMoney) {
        Product productUserWantBuying = productRepository.get(productName);
        int priceUserWantBuying = validateUserHaveMoneyToBuy(userMoney, productUserWantBuying);
        validateWarehouseHaveStock(productUserWantBuying);
        return priceUserWantBuying;
    }

    private void validateWarehouseHaveStock(Product productUserWantBuying) {
        if (!productUserWantBuying.hasStock()) {
            throw new IllegalArgumentException(NO_STOCK_ERROR_MESSAGE);
        }
        productUserWantBuying.takeOutInWarehouse();
    }

    private int validateUserHaveMoneyToBuy(Price userMoney, Product productUserWantBuying) {
        int priceUserWantBuying = productUserWantBuying.getPrice();
        if (userMoney.getPrice() < priceUserWantBuying) {
            throw new IllegalArgumentException(MONEY_LACK_ERROR_MESSAGE);
        }
        return priceUserWantBuying;
    }

    public boolean canBuyProduct(Price userMoney) {
        int userPrice = userMoney.getPrice();
        return productRepository.values()
            .stream()
            .filter(product -> product.getPrice() <= userPrice)
            .anyMatch(product -> product.hasStock());
    }

    public boolean hasNoQuantity() {
        return productRepository.keySet()
            .stream()
            .noneMatch(productName -> getQuantity(productName) != 0);
    }

    private int getQuantity(String productName) {
        return productRepository.get(productName).getQuantity();
    }
}
