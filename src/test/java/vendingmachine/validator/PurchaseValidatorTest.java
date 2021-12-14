package vendingmachine.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import vendingmachine.constant.Condition;
import vendingmachine.domain.Product;

class PurchaseValidatorTest {

    private void validateProductExist(List<Product> products, String productName) {
        if (!isProductExist(products, productName)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isProductExist(List<Product> products, String productName) {
        boolean result = products.stream()
                .anyMatch(product -> product.getName().equals(productName));

        if (result) {
            return true;
        }
        return false;
    }

    private void validateEnoughMoneyForProductCost(List<Product> products, String productName, int money) {
        if (!canPurchaseProduct(products, productName, money)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean canPurchaseProduct(List<Product> products, String productName, int money) {
        List<Product> findProduct = products.stream().
                filter(product -> product.getName().equals(productName)).collect(Collectors.toList());

        if (isProductMoreExpensiveThanHasMoney(findProduct.get(Condition.INDEX_0.getNumber()).getCost(), money)) {
            return false;
        }
        return true;
    }

    private boolean isProductMoreExpensiveThanHasMoney(int productCost, int money) {
        if (productCost > money) {
            return true;
        }
        return false;
    }

    private void validateProductAmountExist(List<Product> products, String productName) {
        if(!hasProductQuantity(products, productName)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean hasProductQuantity(List<Product> products, String productName) {
        List<Product> findProduct = products.stream().
                filter(product -> product.getName().equals(productName)).collect(Collectors.toList());

        for (Product product :findProduct) {
            if (!product.hasQuantity(product)) {
                return false;
            }
        }
        return true;
    }

    @Test
    void 존재하는_상품인지_확인() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("사이다", 1000, 10));
        products.add(new Product("콜라", 1500, 1));

        assertThrows(IllegalArgumentException.class, () -> validateProductExist(products, "씨그램"));

        assertDoesNotThrow(() -> validateProductExist(products, "사이다"));
    }

    @Test
    void 보유한_금액으로_구매_가능한지_확인() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("사이다", 1000, 10));
        products.add(new Product("콜라", 1500, 1));

        assertThrows(IllegalArgumentException.class, () ->
                validateEnoughMoneyForProductCost(products, "사이다", 900));

        assertDoesNotThrow(() -> validateEnoughMoneyForProductCost(products, "사이다", 1000));
    }

    @Test
    void 재고가_남아있는지_확인() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("사이다", 1000, 10));
        products.add(new Product("콜라", 1500, 0));

        assertThrows(IllegalArgumentException.class, () -> validateProductAmountExist(products, "콜라"));

        assertDoesNotThrow(() -> validateProductAmountExist(products, "사이다"));
    }
}