package vendingmachine.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class BeverageTest {

	@Test
	void 음료_판매() {
		Money canBuyMoney = Money.from(1000);
		Beverage beverage = new Beverage("사이다", Money.from(1000), 2);
		beverage.sell(canBuyMoney);

		assertEquals(1, beverage.getCount());
	}

	@Test
	void 음료_판매_금액이_적어_실패() {
		Money canNotBuyMoney = Money.from(1000);
		Beverage beverage = new Beverage("사이다", Money.from(1500), 2);
		assertThatThrownBy(() -> beverage.sell(canNotBuyMoney))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 음료_판매_전부다_팔려_실패() {
		Beverage beverage = new Beverage("사이다", Money.from(1500), 0);
		assertThatThrownBy(() -> beverage.sell(Money.from(1000)))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest
	@NullAndEmptySource
	void 이름이_비어있어_생성_실패(String name) {
		assertThatThrownBy(() -> new Beverage(name, Money.from(100), 10))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 생성_성공() {
		assertDoesNotThrow(() -> new Beverage("콜라", Money.from(100), 0));
	}

	@Test
	void 가격이_너무작아_생성_실패() {
		assertThatThrownBy(() -> new Beverage("콜라", Money.from(99), 10))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 개수가_너무적어_생성_실패() {
		assertThatThrownBy(() -> new Beverage("콜라", Money.from(100), -1))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
