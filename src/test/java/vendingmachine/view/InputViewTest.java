package vendingmachine.view;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import vendingmachine.constant.Condition;

class InputViewTest {

    private void validateDigit(String Money) {
        for (int m = 0; m < Money.length(); m++) {
            if (!Character.isDigit(Money.charAt(m))) {
                throw  new IllegalArgumentException();
            }
        }
    }

    private void validateNull(String Money) {
        if (Money.length() == Condition.valueOf("LENGTH_0").getNumber()) {
            throw new IllegalArgumentException();
        }
    }

    @Test
    void 자판기_보유_금액_입력_예외() {
        assertThrows(IllegalArgumentException.class, () -> validateDigit("1d"));
        assertThrows(IllegalArgumentException.class, () -> validateNull(""));

        assertDoesNotThrow(() -> validateDigit("1"));
        assertDoesNotThrow(() -> validateDigit("1089"));
    }
}