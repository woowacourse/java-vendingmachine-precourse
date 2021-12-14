package vendingmachine.util.validator;

import org.junit.jupiter.api.Test;
import vendingmachine.util.validator.validation.BalanceValidation;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class BalanceValidationTest {

    @Test
    void 정수_외_검증() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> BalanceValidation
                        .verifyBalanceInput("1a3"))
                .withMessageStartingWith("[ERROR]");
    }

    @Test
    void 음수_검증() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> BalanceValidation
                        .verifyBalanceInput("-1"))
                .withMessageStartingWith("[ERROR]");
    }

    @Test
    void Integer_범위를_넘는_검증() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> BalanceValidation
                        .verifyBalanceInput("999999999999"))
                .withMessageStartingWith("[ERROR]");
    }

    @Test
    void 입력값_10의_배수_검증() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> BalanceValidation
                        .verifyBalanceInput("131"))
                .withMessageStartingWith("[ERROR]");
    }
}
