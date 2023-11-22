package vendingmachine.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import vendingmachine.constants.Constants;

class InputAmountTest {

    private static final int MIN_INPUT_AMOUNT = 10;
    private static final int INPUT_AMOUNT_UNIT = 10;

    @Test
    void construct_Fail_ByAmountIsLessThanMinimum() {
        // when, then
        Assertions.assertThatThrownBy(() -> new InputAmount(1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format("%s 투입 금액은 %d원 이상이어야 합니다.",
                        Constants.ERROR_PREFIX.getValue(), MIN_INPUT_AMOUNT));
    }

    @Test
    void construct_Fail_ByInvalidUnit() {
        // when, then
        Assertions.assertThatThrownBy(() -> new InputAmount(111))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format("%s 투입 금액은 %d원 단위만 가능합니다.",
                        Constants.ERROR_PREFIX.getValue(), INPUT_AMOUNT_UNIT));
    }
}
