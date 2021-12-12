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

	@Test
	void 상품_찾을수_없음() {
		// given
		String input = "[콜라,1200,10];[알로에,1500,1]";
		String wrongName = "사이다";
		int money = 1300;

		// when
		Items items = new Items(input);

		// then
		assertThatThrownBy(() -> items.purchase(wrongName, money)).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 상품_구매() {
		// given
		String input = "[콜라,1200,10];[사이다,1000,20]";
		String coke = "콜라";
		int money = 1300;

		// when
		Items items = new Items(input);
		int price = items.purchase(coke, money);

		// then
		assertThat(price).isEqualTo(1200);
	}
}