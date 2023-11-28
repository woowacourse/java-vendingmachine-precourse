package domain.wrapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static util.message.ExceptionMessage.BLANK_MESSAGE;

public class ProductNameTest {
    @ParameterizedTest
    @DisplayName("정상적으로 입력했을 경우 예외를 처리하지 않는다.")
    @ValueSource(strings = {"콜라", "사이다", "피자", "치킨"})
    void givenNormalName_thenSuccess(final String carName) {
        assertThat(Name.create(carName))
                .isInstanceOf(Name.class);

        assertThatCode(() -> Name.create(carName))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("이름이 공백일 경우 예외를 처리한다.")
    @EmptySource
    void givenBlankName_thenFail(final String carName) {
        assertThatThrownBy(() -> Name.create(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(BLANK_MESSAGE.getValue(), "상품명"));
    }
}
