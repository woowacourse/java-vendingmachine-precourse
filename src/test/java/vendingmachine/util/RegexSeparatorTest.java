package vendingmachine.util;

import org.junit.jupiter.api.Test;
import vendingmachine.domain.product.Product;

import static org.assertj.core.api.Assertions.assertThat;

public class RegexSeparatorTest {
    private final String PRODUCT_INFO = "[콜라,1500,20]";
    private final String PRODUCT_NAME = "콜라";

    @Test
    void 입력_문자열_정규표현_구분() {
        Product product = RegexSeparator.mapInfoToProduct(PRODUCT_INFO);
        assertThat(product.verifyName(PRODUCT_NAME)).isTrue();
    }
}
