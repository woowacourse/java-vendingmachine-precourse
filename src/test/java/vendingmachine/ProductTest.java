package vendingmachine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import vendingmachine.Domain.Product;
import vendingmachine.Util.Validation.ProductInspector;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static vendingmachine.Constant.Error.*;

public class ProductTest {

    private Product product;
    private final ProductInspector inspector = new ProductInspector();

    @BeforeEach
    void initProduct() {
        product = new Product();
    }

    @ParameterizedTest
    @CsvSource(value = {"Cola:2000:20", "Cider:2000:20", "Coffee:2000:20", "Latte:2000:20"}, delimiter = ':')
    @DisplayName("제품정보 초기화")
    void productInfo(String inputName, int inputPrice, int inputCount) {
        product.addProduct(inputName, inputPrice, inputCount);

        assertThat(product.getNames()).contains(inputName);
        assertThat(product.getPrice(inputName)).isEqualTo(inputPrice);
        assertThat(product.getCount(inputName)).isEqualTo(inputCount);
    }

    @Test
    @DisplayName("제품정보 초기화시 갯수 확인")
    void productCount() {
        List<String> Names = List.of("A", "B", "C", "D", "E", "F", "G", "H", "I");

        for (String name : Names) product.addProduct(name, 1000, 1);

        assertThat(product.getNames().size()).isEqualTo(Names.size());
    }

    @ParameterizedTest
    @ValueSource(strings = {"TestProductName"})
    @DisplayName("품절된 제품 구매시")
    void productSoldCount(String name) {
        product.addProduct(name, 1000, 1);
        product.sold(name);

        assertThatThrownBy(() -> inspector.productSoldOut(name, product)).isInstanceOf(IllegalArgumentException.class).hasMessageContaining(SOLD_OUT_PRODUCT.toMessage());
    }

    @Test
    @DisplayName("제품 중 최저가 확인")
    void productCheapestPrice() {
        List<String> names = List.of("A", "B", "C", "D");
        List<Integer> prices = List.of(1000, 50, 100, 5000);
        List<Integer> counts = List.of(1, 2, 3, 4);

        for (int i = 0; i < 4; i++) product.addProduct(names.get(i), prices.get(i), counts.get(i));

        assertThat(product.getCheapestPrice()).isEqualTo(prices.stream().min(Integer::compareTo).get());
    }

    @ParameterizedTest
    @ValueSource(strings = {"콜라,1000,1", "[콜라,1000,1", "콜라,1000,1]", "[콜라],[1000],[1]"})
    @DisplayName("주문형식을 확인")
    void productOrderPrefixAndSuffix(String order) {
        assertThatThrownBy(() -> inspector.inputInitOrder(order))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_PROPER_ORDER_COMMAND.toMessage());
    }

    @Test
    @DisplayName("존재하지 않는 제품 입력시 예외확인")
    void invalidProductName() {
        List<String> Names = List.of("A", "B", "C", "D");
        for (String name : Names) product.addProduct(name, 1000, 1);

        assertThatThrownBy(() -> inspector.productNameExist("Z", product))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_EXIST_PRODUCT_NAME.toMessage());
    }

    @Test
    @DisplayName("품절제품 입력시 예외확인")
    void soldOutProductName() {
        List<String> Names = List.of("A", "B", "C", "D");
        for (String name : Names) product.addProduct(name, 1000, 0);

        for (String name : Names) {
            assertThatThrownBy(() -> inspector.productSoldOut(name, product))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(SOLD_OUT_PRODUCT.toMessage());
        }
    }

}
