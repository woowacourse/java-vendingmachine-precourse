package vendingmachine.validators;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ProductValidatorTest {

    @ParameterizedTest
    @ValueSource(ints = {100, 10000, 130000})
    void validate는_가격을_검사한다(int price){
        assertThatNoException().isThrownBy(() -> ProductValidator.validate(price));
    }

    @ParameterizedTest
    @ValueSource(ints = {99, 0, -1})
    void validate는_가격이_100원미만이면_예외반환(int lessThanMinimum) {
        assertThatThrownBy(() -> ProductValidator.validate(lessThanMinimum))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {199, 123, 1000000001})
    void validate는_가격이_10원으로_나누어떨어지지않으면_예외반환(int nonDiveded) {
        String name = "사이다";
        assertThatThrownBy(() -> ProductValidator.validate(nonDiveded))
                .isInstanceOf(IllegalArgumentException.class);
    }

}