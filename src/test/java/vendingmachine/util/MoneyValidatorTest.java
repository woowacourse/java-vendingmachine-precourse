package vendingmachine.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MoneyValidatorTest {

	@Test
	void 정수_검증() {
		assertThrows(IllegalArgumentException.class, () -> MoneyValidator.validate(""));
		assertThrows(IllegalArgumentException.class, () -> MoneyValidator.validate(" "));
		assertThrows(IllegalArgumentException.class, () -> MoneyValidator.validate("a"));
		assertThrows(IllegalArgumentException.class, () -> MoneyValidator.validate("ㄱ"));
		assertThrows(IllegalArgumentException.class, () -> MoneyValidator.validate("1 2"));
		assertThrows(IllegalArgumentException.class, () -> MoneyValidator.validate(","));
		assertThrows(IllegalArgumentException.class, () -> MoneyValidator.validate("1,"));
		assertThrows(IllegalArgumentException.class, () -> MoneyValidator.validate("1,67"));
		assertThrows(IllegalArgumentException.class, () -> MoneyValidator.validate("020"));
		assertThrows(IllegalArgumentException.class, () -> MoneyValidator.validate("00"));
		assertThrows(IllegalArgumentException.class, () -> MoneyValidator.validate("24t1"));
	}

	@Test
	void 동전_변환가능_검증() {
		assertThrows(IllegalArgumentException.class, () -> MoneyValidator.validate("1"));
		assertThrows(IllegalArgumentException.class, () -> MoneyValidator.validate("9"));
		assertThrows(IllegalArgumentException.class, () -> MoneyValidator.validate("0"));
		assertThrows(IllegalArgumentException.class, () -> MoneyValidator.validate("010"));
		assertThrows(IllegalArgumentException.class, () -> MoneyValidator.validate("51"));
		assertThrows(IllegalArgumentException.class, () -> MoneyValidator.validate("155"));
	}
}
