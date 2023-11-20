package vendingmachine.validators;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import vendingmachine.domain.Coin;

class ProductPriceValidatorTest {

    @ParameterizedTest
    @ValueSource(ints = {100, 10000, 130000})
    void validate는_가격을_검사한다(int price) {
        assertThatNoException().isThrownBy(() -> ProductPriceValidator.validate(price));
    }

    @ParameterizedTest
    @ValueSource(ints = {99, 0, -1})
    void validate는_가격이_100원미만이면_실패(int lessThanMinimum) {
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> ProductPriceValidator.validate(lessThanMinimum));
        assertEquals(exception.getMessage(), String.format("상품의 최소 금액은 %d원입니다", 100));
    }

    @ParameterizedTest
    @ValueSource(ints = {199, 123, 1000000001})
    void validate는_가격이_10원으로_나누어떨어지지않으면_실패(int nonDiveded) {
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> ProductPriceValidator.validate(nonDiveded));
        assertEquals(exception.getMessage(), String.format("상품 금액은 10원 단위로 나누어 떨어집니다.",
                Coin.COIN_10.getAmount()));
    }

}