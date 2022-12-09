package vendingmachine;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import vendingmachine.domain.Money;
import vendingmachine.domain.products.Price;
import vendingmachine.domain.products.Product;
import vendingmachine.domain.products.Products;
import vendingmachine.domain.products.Quantity;
import vendingmachine.util.ProductsConvert;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ProductsTest {

    private static final String EXCEPTION_MESSAGE = "[ERROR]";

    @DisplayName("정상적으로 구매 가능한 상품을 찾는다.")
    @Test
    void findPurchasableProductSuccess() {
        Products products = ProductsConvert.convert("[콜라,2000,20];[사이다,1000,10]");
        boolean result = true;
        try {
            products.findPurchasableProduct("콜라", Money.from(3000));
        } catch (IllegalArgumentException exception) {
            result = false;
        }
        assertThat(result).isEqualTo(true);
    }

    @DisplayName("구매 가능한 상품이 없을시 예외를 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {"콜라, 1000", "콜라라, 5000", "솔의눈, 10000"})
    void createPriceFailByRange(String name, int money) {
        Products products = ProductsConvert.convert("[콜라,2000,20];[사이다,1000,10];[솔의눈,1000,0]");
        assertThatThrownBy(() -> products.findPurchasableProduct(name, Money.from(money)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EXCEPTION_MESSAGE);
    }

    @DisplayName("정상적으로 최소가격 상품을 찾는다.")
    @Test
    void findMinPriceProductSuccess() {
        Products products = ProductsConvert.convert("[콜라,2000,20];[사이다,1000,10];[솔의눈,10000,0]");
        Product product = new Product("사이다", Price.from(1000), Quantity.from(10));
        assertThat(products.findMinPriceProduct()).isEqualTo(product);
    }
}
