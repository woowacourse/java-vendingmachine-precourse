package vendingmachine.model.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {
    @Test
    @DisplayName("금액을 감소시킨다.")
    void decrease() {
        Money money = new Money("2000");
        int decreasingValue = 1000;
        money.decreaseBy(decreasingValue);
        Money another = new Money("1000");
        boolean actual = money.equals(another);
        assertThat(actual).isTrue();
    }

    @ParameterizedTest
    @DisplayName("상품 가격을 받아, 금액이 상품 가격보다 낮은지 반환한다.")
    @CsvSource({"3000, true", "2000, false", "1900, false"})
    void isLowerThan(final int itemPrice, final boolean expected) {
        Money money = new Money("2000");
        boolean actual = money.isLowerThan(itemPrice);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("양의 정수가 아닌 값으로 Money 객체를 생성하면 예외를 발생시킨다.")
    @ValueSource(strings = {"?", "1.2", "0", "-1"})
    void evokeExceptionByNotInteger(final String notIntegerValue) {
        String expectedExceptionMessage = "금액은 양의 정수여야 합니다.";
        assertThatIllegalArgumentException().isThrownBy(() -> new Money(notIntegerValue))
                .withMessage(expectedExceptionMessage);
    }

    @Test
    @DisplayName("10의 배수가 아닌 값으로 Money 객체를 생성하면 예외를 발생시킨다.")
    void evokeExceptionByNotMultipleOfTen() {
        String notMultipleOfTen = "1001";
        String expectedExceptionMessage = "금액의 최소 단위는 10원입니다.";
        assertThatIllegalArgumentException().isThrownBy(() -> new Money(notMultipleOfTen))
                .withMessage(expectedExceptionMessage);
    }

    @Test
    @DisplayName("금액을 반환한다.")
    void getValue() {
        Money money = new Money("2000");
        int actual = money.getValue();
        int expected = 2000;
        assertThat(actual).isEqualTo(expected);
    }
}
