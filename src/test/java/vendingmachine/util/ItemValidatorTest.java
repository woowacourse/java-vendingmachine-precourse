package vendingmachine.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ItemValidatorTest {

	@Test
	void 상품_입력값_예외검증() {
		assertThrows(IllegalArgumentException.class, () -> ItemValidator.validate("콜라,1500,20]"));
		assertThrows(IllegalArgumentException.class, () -> ItemValidator.validate("[콜라,1500,20"));
		assertThrows(IllegalArgumentException.class, () -> ItemValidator.validate("[,1500,20]"));
		assertThrows(IllegalArgumentException.class, () -> ItemValidator.validate("[콜라,,20]"));
		assertThrows(IllegalArgumentException.class, () -> ItemValidator.validate("[콜라,1500,]"));
		assertThrows(IllegalArgumentException.class, () -> ItemValidator.validate("[콜라1500,20]"));
		assertThrows(IllegalArgumentException.class, () -> ItemValidator.validate("[콜라,150020]"));
		assertThrows(IllegalArgumentException.class, () -> ItemValidator.validate("[10,1500,20]"));
		assertThrows(IllegalArgumentException.class, () -> ItemValidator.validate("[콜라,z,20]"));
		assertThrows(IllegalArgumentException.class, () -> ItemValidator.validate("[콜라,1500,z]"));
		assertThrows(IllegalArgumentException.class, () -> ItemValidator.validate("[ ,1500,20]"));
		assertThrows(IllegalArgumentException.class, () -> ItemValidator.validate("[콜라, ,20]"));
		assertThrows(IllegalArgumentException.class, () -> ItemValidator.validate("[콜라,1500, ]"));
		assertThrows(IllegalArgumentException.class, () -> ItemValidator.validate("[콜,라,1500, 20]"));
		assertThrows(IllegalArgumentException.class, () -> ItemValidator.validate("[콜라,15,00, 20]"));
		assertThrows(IllegalArgumentException.class, () -> ItemValidator.validate("[콜 라,1500, 20]"));
		assertThrows(IllegalArgumentException.class, () -> ItemValidator.validate("[콜라,15 00, 20]"));
	}
}
