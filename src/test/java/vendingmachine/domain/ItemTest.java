package vendingmachine.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ItemTest {
	@Test
	void 생성_실패() {
		// given
		String[] insufficientAttributes = {"콜라", "1200"};
		String[] lackQuantity = {"콜라", "1200", "-1"};

		// when, then
		assertAll(() -> assertThatThrownBy(() -> new Item(insufficientAttributes)).isInstanceOf(
				IllegalArgumentException.class),
			() -> assertThatThrownBy(() -> new Item(lackQuantity)).isInstanceOf(IllegalArgumentException.class));
	}

	@Test
	void 생성_성공() {
		// given
		String[] itemData = {"콜라", "1200", "10"};

		// when
		Item item = new Item(itemData);

		// then
		assertThat(item).isNotNull();
	}
}