package vendingmachine.domain;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProductTest {

    @Test
    @DisplayName("제품의 가격이 100원 이하일 경우 exception이 발생해야 한다.")
    void createProductExceptionByLessPriceTest() {
        // given
        String name = "콜라";
        int price = 50;
        int remainAmount = 20;

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Product(name, price, remainAmount))
            .withMessage("[ERROR] 상품 가격은 100원 이상의 값이 들어와야 합니다.");
    }

    @Test
    @DisplayName("제품 가격이 10원으로 나누어떨어지지 않을 경우 exception이 발생해야 한다.")
    void createProductExceptionByDivisableCoinTest() {
        // given
        String name = "콜라";
        int price = 1001;
        int remainAmount = 20;

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Product(name, price, remainAmount))
            .withMessage("[ERROR] 상품 가격은 10원으로 나누어떠러져야 합니다.");
    }

    @Test
    @DisplayName("상품의 이름과 동일한 이름이 들어오는 경우 true를 반환한다.")
    void isEqualsNameTest() {
        // given
        String name = "콜라";
        int price = 1500;
        int remainAmount = 20;
        Product product = new Product(name, price, remainAmount);

        // when
        boolean result = product.isEqualsName(name);

        // then
        assertTrue(result);
    }
}