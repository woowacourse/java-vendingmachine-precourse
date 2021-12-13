package vendingmachine.model.item.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import vendingmachine.model.vo.Money;

class PriceTest {
    private final Price price = new Price("1000");

    @ParameterizedTest
    @DisplayName("Money 객체를 받아, 상품 가격이 Money의 금액보다 높은지 반환한다.")
    @CsvSource({"2000, false", "1000, false", "900, true"})
    void isExpensiveThan(final String moneyValue, final boolean expected) {
        Money remainingInputMoney = new Money(moneyValue);
        boolean actual = price.isMoreExpensiveThan(remainingInputMoney);
        assertThat(actual).isEqualTo(expected);
    }

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
    @DisplayName("정수가 아니거나 100 미만의 값으로 Price 객체를 생성하면 예외를 발생시킨다.")
    @ValueSource(strings = {"?", "1.2", "0", "-1", "99"})
    void evokeExceptionByNotInteger(final String notIntegerValue) {
        String expectedExceptionMessage = "상품 가격은 100 이상의 정수여야 합니다.";
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
}
