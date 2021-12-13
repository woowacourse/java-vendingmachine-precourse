package vendingmachine.util;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StringConversionUtilTest {

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "s1", ",s"})
    @DisplayName("숫자 변환 시 문자를 입력할 경우 exception이 발생해야 한다.")
    void parseIntExceptionByFormatTest(String input) {
        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> StringConversionUtil.parseInt(input))
            .withMessage("[ERROR] 숫자만 입력할 수 있습니다.");
    }
}