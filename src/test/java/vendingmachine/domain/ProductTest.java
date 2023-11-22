package vendingmachine.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ProductTest {

    @ParameterizedTest
    @CsvSource(value = {"'사이다',1000","'콜라',1500000"})
    void 팩터리메서드_테스트(String name, int price) {
        // when
        Product result = Product.of(name, price);
        // then
        assertThat(result).isInstanceOf(Product.class);
    }
}