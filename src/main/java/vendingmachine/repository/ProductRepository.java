package vendingmachine.repository;

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
            throw new IllegalArgumentException("같은 상품을 여러 번 입력할 수 없습니다.");
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
            throw new IllegalArgumentException("해당 상품은 재고가 남아있지 않습니다.");
        }
        productUserWantBuying.takeOutInWarehouse();
    }

    private int validateUserHaveMoneyToBuy(Price userMoney, Product productUserWantBuying) {
        int priceUserWantBuying = productUserWantBuying.getPrice();
        if (userMoney.getPrice() < priceUserWantBuying) {
            throw new IllegalArgumentException("남아있는 금액으로는 해당 제품을 구매할 수 없습니다.");
        }
        return priceUserWantBuying;
    }

    //userRepository 돌면서 가장 저렴한 userMoney 를 찾는다.
    //userMoney가 가장 저렴한 제품의 가격보다 적거나,
    public boolean cantBuyBecauseOfNoMoney(Price userMoney) {
        int userPrice = userMoney.getPrice();
        int cheapestPrice = productRepository.keySet()
            .stream()
            .mapToInt(this::getPrice)
            .min()
            .orElseThrow(() -> new IllegalArgumentException("최소값이 없습니다. 로직오류"));
        return userPrice < cheapestPrice; //아무것도 살 수 없는 돈
    }

    private int getPrice(String productName) {
        return productRepository.get(productName).getPrice();
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
