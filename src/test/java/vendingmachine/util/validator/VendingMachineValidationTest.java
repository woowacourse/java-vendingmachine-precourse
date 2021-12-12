package vendingmachine.util.validator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class VendingMachineValidationTest {

    @Test
    void 정수_외_검증() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> VendingMachineValidation
                        .verifyBalanceInput("1a3",() -> new IllegalArgumentException("[ERROR]")))
                .withMessageStartingWith("[ERROR]");
    }

    @Test
    void 음수_검증() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> VendingMachineValidation
                        .verifyBalanceInput("-1",() -> new IllegalArgumentException("[ERROR]")))
                .withMessageStartingWith("[ERROR]");
    }

    @Test
    void Integer_범위를_넘는_검증() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> VendingMachineValidation
                        .verifyBalanceInput("999999999999",() -> new IllegalArgumentException("[ERROR]")))
                .withMessageStartingWith("[ERROR]");
    }

    @Test
    void 입력값_10의_배수_검증() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> VendingMachineValidation
                        .verifyBalanceInput("131",() -> new IllegalArgumentException("[ERROR]")))
                .withMessageStartingWith("[ERROR]");
    }
}
