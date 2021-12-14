package vendingmachine.domain;

import static org.assertj.core.api.Assertions.*;

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

		Items items = new Items(input);

		// when, then
		assertThatThrownBy(() -> items.purchase(wrongName, money)).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 상품_구매() {
		// given
		String input = "[콜라,1200,10];[사이다,1000,20]";
		String coke = "콜라";
		int money = 1300;

		Items items = new Items(input);

		// when
		int price = items.purchase(coke, money);

		// then
		assertThat(price).isEqualTo(1200);
	}

	@Test
	void 상품_구매_가능_테스트() {
		// given
		String notEnoughMoney = "[콜라,1200,10];[사이다,1000,20]";
		String justOneQuantity = "[커피,300,1]";
		String continuable = "[커피,300,2];[코코아,200,1];[밀크티,800,2]";
		int money = 700;

		Items notEnoughMoneyItems = new Items(notEnoughMoney);
		Items justOneQuantityItems = new Items(justOneQuantity);
		Items continuableItems = new Items(continuable);

		// when
		justOneQuantityItems.purchase("커피", money);
		continuableItems.purchase("코코아", money);

		// then
		assertThat(notEnoughMoneyItems.continuable(money)).isEqualTo(false);
		assertThat(justOneQuantityItems.continuable(money)).isEqualTo(false);
		assertThat(continuableItems.continuable(money)).isEqualTo(true);
	}
}