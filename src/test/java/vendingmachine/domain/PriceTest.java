package vendingmachine.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PriceTest {

	@Test
	@DisplayName("정수로 가격을 생성한다.")
	public void testCreatePrice() {
		// given
		int amount = 100;
		// when
		Price price = new Price(amount);
		// then
		assertEquals("100원", price.toString());
	}

	@Test
	@DisplayName("10으로 나누어 떨어져야 한다.")
	public void testCreatePriceWithNonDividableBy10() {
		// given
		int amount = 11;
		// then
		assertThrows(IllegalArgumentException.class, () -> new Price(amount));
	}

	@Test
	@DisplayName("100 이상이어야 한다.")
	public void testCreatePriceLower100() {
		// given
		int amount = 90;
		// then
		assertThrows(IllegalArgumentException.class, () -> new Price(amount));
	}
}