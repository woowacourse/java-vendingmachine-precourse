package vendingmachine;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ProductsTest {
    @ParameterizedTest
    @ValueSource(strings = {"콜라,1000,20]", "[콜라,1000,20", "콜라,1000,20"})
    void 상품정보입력값_대괄호가_포함되지않음_예외(String wrongInput) {
        assertThatThrownBy(() -> new Products(wrongInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
