package vendingmachine.validators;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;

class ProductsValidatorTest {

    @Test
    void validate는_최소수량_이상인지_검사한다() {
        // given
        List<Integer> given = List.of(1, 2, 3, 4, 5, 6);
        // when&then
        assertThatNoException().isThrownBy(() -> ProductsValidator.validate(given));
    }

    @Test
    void validate는_최소수량_미만이면_실패() {
        // given
        List<Integer> given = List.of(1, 2, 3, 4, 0, 6);
        // when&then
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> ProductsValidator.validate(given));
        assertEquals(exception.getMessage(), String.format("상품의 최소 수량은 %d개 이상입니다", 1));

    }
}