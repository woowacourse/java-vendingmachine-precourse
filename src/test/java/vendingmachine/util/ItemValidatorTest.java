package vendingmachine.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import vendingmachine.domain.Item;

class ItemValidatorTest {

	@Test
	void 상품_입력값_예외검증() {
		assertThrows(IllegalArgumentException.class, () -> ItemValidator.validateItemForm("콜라,1500,20]"));
		assertThrows(IllegalArgumentException.class, () -> ItemValidator.validateItemForm("[콜라,1500,20"));
		assertThrows(IllegalArgumentException.class, () -> ItemValidator.validateItemForm("[,1500,20]"));
		assertThrows(IllegalArgumentException.class, () -> ItemValidator.validateItemForm("[콜라,,20]"));
		assertThrows(IllegalArgumentException.class, () -> ItemValidator.validateItemForm("[콜라,1500,]"));
		assertThrows(IllegalArgumentException.class, () -> ItemValidator.validateItemForm("[콜라1500,20]"));
		assertThrows(IllegalArgumentException.class, () -> ItemValidator.validateItemForm("[콜라,150020]"));
		assertThrows(IllegalArgumentException.class, () -> ItemValidator.validateItemForm("[10,1500,20]"));
		assertThrows(IllegalArgumentException.class, () -> ItemValidator.validateItemForm("[콜라,z,20]"));
		assertThrows(IllegalArgumentException.class, () -> ItemValidator.validateItemForm("[콜라,1500,z]"));
		assertThrows(IllegalArgumentException.class, () -> ItemValidator.validateItemForm("[ ,1500,20]"));
		assertThrows(IllegalArgumentException.class, () -> ItemValidator.validateItemForm("[콜라, ,20]"));
		assertThrows(IllegalArgumentException.class, () -> ItemValidator.validateItemForm("[콜라,1500, ]"));
		assertThrows(IllegalArgumentException.class, () -> ItemValidator.validateItemForm("[콜,라,1500, 20]"));
		assertThrows(IllegalArgumentException.class, () -> ItemValidator.validateItemForm("[콜라,15,00, 20]"));
		assertThrows(IllegalArgumentException.class, () -> ItemValidator.validateItemForm("[콜 라,1500, 20]"));
		assertThrows(IllegalArgumentException.class, () -> ItemValidator.validateItemForm("[콜라,15 00, 20]"));
		assertThrows(IllegalArgumentException.class, () -> ItemValidator.validateItemForm("[콜라,1501, 20]"));
		assertThrows(IllegalArgumentException.class, () -> ItemValidator.validateItemForm("[콜라,050, 20]"));
		assertThrows(IllegalArgumentException.class, () -> ItemValidator.validateItemForm("[콜라,150, 02]"));
		assertThrows(IllegalArgumentException.class, () -> ItemValidator.validateItemForm("[콜라,10, 2]"));
	}

	@Test
	void 상품명_입력_검증() {
		List<Item> itemList = Item.createList(Arrays.asList("[콜라,1500,0]", "[사이다,1000,10]"));

		assertThrows(IllegalArgumentException.class, () -> ItemValidator.validateAvailability(itemList, "환타"));

		assertThrows(IllegalArgumentException.class, () -> ItemValidator.validateAvailability(itemList, "콜라"));
	}
}
