package vendingmachine.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BalanceValidatorTest {

	@Test
	void 정수_검증() {
		assertThrows(IllegalArgumentException.class, () -> BalanceValidator.validate(""));
		assertThrows(IllegalArgumentException.class, () -> BalanceValidator.validate(" "));
		assertThrows(IllegalArgumentException.class, () -> BalanceValidator.validate("1 2"));
		assertThrows(IllegalArgumentException.class, () -> BalanceValidator.validate(","));
		assertThrows(IllegalArgumentException.class, () -> BalanceValidator.validate("1,"));
		assertThrows(IllegalArgumentException.class, () -> BalanceValidator.validate("1,67"));
		assertThrows(IllegalArgumentException.class, () -> BalanceValidator.validate("020"));
		assertThrows(IllegalArgumentException.class, () -> BalanceValidator.validate("00"));
		assertThrows(IllegalArgumentException.class, () -> BalanceValidator.validate("24t1"));
	}

	@Test
	void 동전_변환가능_검증() {
		assertThrows(IllegalArgumentException.class, () -> BalanceValidator.validate("1"));
		assertThrows(IllegalArgumentException.class, () -> BalanceValidator.validate("9"));
		assertThrows(IllegalArgumentException.class, () -> BalanceValidator.validate("0"));
		assertThrows(IllegalArgumentException.class, () -> BalanceValidator.validate("51"));
		assertThrows(IllegalArgumentException.class, () -> BalanceValidator.validate("155"));
	}
}
