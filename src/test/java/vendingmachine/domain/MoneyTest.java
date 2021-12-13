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

	@Test
	@DisplayName("금액끼리 더할 수 있다")
	public void testMoneyPlus() {
	    // given
		Money moneyA = new Money(1000);
		Money moneyB = new Money(500);
	    // when
		Money plus = moneyA.plus(moneyB);
		// then
		assertEquals(new Money(1500), plus);
	}

	@Test
	@DisplayName("금액끼리 뺄 수 있다")
	public void testMoneyMinus() {
		// given
		Money moneyA = new Money(1000);
		Money moneyB = new Money(500);
		// when
		Money plus = moneyA.minus(moneyB);
		// then
		assertEquals(new Money(500), plus);
	}

	@Test
	@DisplayName("금액은 곱할 수 있다")
	public void testMoneyMultiply() {
	    // given
		Money money = new Money(100);
	    // when
		Money multiply = money.multiply(5);
		// then
		assertEquals(new Money(500), multiply);
	}

	@Test
	@DisplayName("금액은 대소를 비교할 수 있다")
	public void testMoneyLess() {
	    // given
		Money moneyA = new Money(1000);
		Money moneyB = new Money(500);
	    // when
		boolean compare = moneyB.isLessThan(moneyA);
		// then
		assertTrue(compare);
	}
}