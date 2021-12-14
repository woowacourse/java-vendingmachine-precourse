package vendingmachine.util.validator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class IntegerValidationTest {
    @Test
    void 음수_값_검증() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> IntegerValidator
                        .isNegative(-1, () -> new IllegalArgumentException("[ERROR]")))
                .withMessageStartingWith("[ERROR]");
    }

    @Test
    void 입력값_10의_배수_검증() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> IntegerValidator
                        .isNotMultiplyByTen(131, () -> new IllegalArgumentException("[ERROR]")))
                .withMessageStartingWith("[ERROR]");
    }
}
