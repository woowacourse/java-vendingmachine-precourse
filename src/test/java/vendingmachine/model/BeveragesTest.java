package vendingmachine.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class BeveragesTest {

	@Test
	void 없는상품_구매시_오류() {
		Beverage cider = new Beverage("사이다", Money.from(1000), 2);
		Beverages beverages = new Beverages(Arrays.asList(cider));
		String doesNotExist = "콜라";

		assertThatThrownBy(() -> beverages.sell(doesNotExist, Money.from(2000)))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 전부다_팔렸는지_확인하는_기능() {
		Beverage cider = new Beverage("사이다", Money.from(1000), 0);
		Beverage cola = new Beverage("콜라", Money.from(1000), 0);
		Beverages beverages = new Beverages(Arrays.asList(cider, cola));

		assertFalse(beverages.canSellMore(Money.from(1000)));
	}

	@Test
	void 남은돈이_최저가_상품보다_적을_때() {
		Beverage cider = new Beverage("사이다", Money.from(1000), 1);
		Beverages beverages = new Beverages(Arrays.asList(cider));

		assertFalse(beverages.canSellMore(Money.from(900)));
	}
}
