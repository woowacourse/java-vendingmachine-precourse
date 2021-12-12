package vendingmachine.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

	@Test
	@DisplayName("금액을 생성한다.")
	public void testMoneyCreation() {
		// given
		int amount = 100;
		// when
		Money money = new Money(amount);
		// then
		assertEquals("100원", money.toString());
	}

	@Test
	@DisplayName("금액은 0 미만일 수 없다.")
	public void testMoneyPositive() {
		// given
		int amount = -1;
		// then
		assertThrows(IllegalArgumentException.class, () -> new Money(amount));
	}
}