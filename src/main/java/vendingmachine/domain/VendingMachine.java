package vendingmachine.domain;

import static vendingmachine.exception.ErrorCode.INVALID_ORDER_PRODUCT;
import static vendingmachine.exception.ErrorCode.INVALID_ORDER_QUANTITY;
import static vendingmachine.util.Parser.parseMenuInput;

import java.util.Comparator;
import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;
import vendingmachine.domain.constant.Coin;
import vendingmachine.domain.constant.Product;

public class VendingMachine {
    private final EnumMap<Coin, Integer> vmCoinMap;
    private final Map<String, Product> productMap;

    private VendingMachine(EnumMap<Coin, Integer> vmCoinMap, Map<String, Product> productMap) {
        this.vmCoinMap = vmCoinMap;
        this.productMap = productMap;
    }

    // Static Factory Method
    public static VendingMachine from(final EnumMap<Coin, Integer> vmCoinMap, final Map<String, Product> productMap) {
        return new VendingMachine(vmCoinMap, productMap);
    }

    public int getPrice(String menuName) {
        INVALID_ORDER_PRODUCT.validate(()->isExistedMenu(menuName));
        INVALID_ORDER_QUANTITY.validate(()->isPossibleBuying(menuName));
        return productMap.get(menuName).getPrice();
    }

    public int getLowestPrice(){
        Optional<Integer> lowestPrice = getMinPrice();
        return lowestPrice.get();
    }

    private Optional<Integer> getMinPrice() {
        return productMap.values().stream()
                .filter(product -> product.getPrice() > 0)
                .map(Product::getPrice)
                .min(Comparator.naturalOrder());
    }

    //== Validation Method ==//
    private boolean isExistedMenu(String menuName) {
        return productMap.containsKey(menuName);
    }

    private boolean isPossibleBuying(String menuName) {
        int quantity = productMap.get(menuName).getQuantity();
        return quantity == 0;
    }

}
