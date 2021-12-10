package vendingmachine.model.item.vo;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class PriceTest {
    private final Price price = new Price("1000");

    @ParameterizedTest
    @DisplayName("필드 값을 기준으로 동등성을 반환한다.")
    @MethodSource("provideAnotherPriceAndExpected")
    void equals(final Price another, final boolean expected) {
        boolean actual = price.equals(another);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("필드 값이 같으면 같은 해쉬코드를 반환한다.")
    @MethodSource("provideAnotherPriceAndExpected")
    void hashCode(final Price another, final boolean expected) {
        int hashCodeOfPrice = price.hashCode();
        int hashCodeOfAnotherPrice = another.hashCode();
        assertThat(hashCodeOfPrice == hashCodeOfAnotherPrice).isEqualTo(expected);
    }


    private static Stream<Arguments> provideAnotherPriceAndExpected() {
        return Stream.of(
                Arguments.of(new Price("1000"), true),
                Arguments.of(new Price("2000"), false)
        );
    }

    @ParameterizedTest
    @DisplayName("양의 정수가 아닌 값으로 Price 객체를 생성하면 예외를 발생시킨다.")
    @ValueSource(strings = {"?", "1.2", "0", "-1"})
    void evokeExceptionByNotInteger(final String notIntegerValue) {
        String expectedExceptionMessage = "상품 가격은 양의 정수여야 합니다.";
        assertThatIllegalArgumentException().isThrownBy(() -> new Price(notIntegerValue))
                .withMessage(expectedExceptionMessage);
    }

    @Test
    @DisplayName("10의 배수가 아닌 값으로 Price 객체를 생성하면 예외를 발생시킨다.")
    void evokeExceptionByNotMultipleOfTen() {
        String notMultipleOfTen = "1001";
        String expectedExceptionMessage = "상품 가격의 최소 단위는 10원입니다.";
        assertThatIllegalArgumentException().isThrownBy(() -> new Price(notMultipleOfTen))
                .withMessage(expectedExceptionMessage);
    }

    @Test
    @DisplayName("100 미만의 값으로 Price 객체를 생성하면 예외를 발생시킨다.")
    void evokeExceptionByLowerThan100() {
        String valueLowerThan100 = "99";
        String expectedExceptionMessage = "상품 가격은 최소 100원이여야 합니다.";
        assertThatIllegalArgumentException().isThrownBy(() -> new Price(valueLowerThan100))
                .withMessage(expectedExceptionMessage);
    }
}