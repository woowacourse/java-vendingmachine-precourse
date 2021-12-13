package vendingmachine.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

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
}
