package vendingmachine.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ItemsTest {
	@Test
	void 생성_실패() {
		// given
		String withoutBracket = "콜라,1200,10;[사이다,1000,20]";

		// when
		assertThatThrownBy(() -> new Items(withoutBracket))
			.isInstanceOf(IllegalArgumentException.class); // then
	}

	@Test
	void 생성_성공() {
		// given
		String input = "[콜라,1200,10];[사이다,1000,20]";

		// when
		Items items = new Items(input);

		// then
		assertThat(items).isNotNull();
	}
}