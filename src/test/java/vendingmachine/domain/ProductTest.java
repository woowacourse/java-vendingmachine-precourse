package vendingmachine.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import vendingmachine.constants.Constants;

class ProductTest {

    private static final int MIN_PRICE = 100;
    private static final int PRICE_UNIT = 10;
    
    @Test
    void construct_Fail_ByPriceIsLessThanMinimum() {
        // when, then
        Assertions.assertThatThrownBy(() -> new Product("콜라", 1, 10))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format("%s 상품 가격은 %d원 이상이어야 합니다.",
                        Constants.ERROR_PREFIX.getValue(), MIN_PRICE));
    }

    @Test
    void construct_Fail_ByInvalidPriceUnit() {
        // when, then
        Assertions.assertThatThrownBy(() -> new Product("콜라", 111, 10))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format("%s 상품 가격은 %d원 단위만 가능합니다.",
                        Constants.ERROR_PREFIX.getValue(), PRICE_UNIT));
    }
}
