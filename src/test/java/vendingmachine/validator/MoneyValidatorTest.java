package vendingmachine.validator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import vendingmachine.constant.Condition;

class MoneyValidatorTest {

    private void validateMoneyDigit(String money) {
        for (int m = 0; m < money.length(); m++) {
            if (!Character.isDigit(money.charAt(m))) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateMoneyBlank(String Money) {
        if (Money.length() == Condition.LENGTH_0.getNumber()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateMultipleOfTen(String money) {
        if (Integer.parseInt(money) % Condition.DIVIDE_NUMBER.getNumber() != Condition.REMAINDER_0.getNumber()) {
            throw new IllegalArgumentException();
        }
    }

    @Test
    void 투입_금액_입력_예외() {
        assertThrows(IllegalArgumentException.class, () -> validateMoneyDigit("1d"));
        assertThrows(IllegalArgumentException.class, () -> validateMoneyBlank(""));

        assertDoesNotThrow(() -> validateMoneyDigit("1"));
        assertDoesNotThrow(() -> validateMoneyDigit("1089"));
    }

    @Test
    void 투입_금액_10의_배수_확인() {
        assertThrows(IllegalArgumentException.class, () -> validateMultipleOfTen("1001"));

        assertDoesNotThrow(() -> validateMultipleOfTen("3000"));
    }
}