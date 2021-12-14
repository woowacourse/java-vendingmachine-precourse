package vendingmachine.util.validator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringValidationTest {
    @Test
    void 정수_외_기타값_입력_검증() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> StringValidator
                        .isNotInteger("1a3", () -> new IllegalArgumentException("[ERROR]")))
                .withMessageStartingWith("[ERROR]");
    }

    @Test
    void Integer_범위를_넘는_값_검증() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> StringValidator
                        .isOutOfIntegerRange("9999999999999", () -> new IllegalArgumentException("[ERROR]")))
                .withMessageStartingWith("[ERROR]");
    }
}
