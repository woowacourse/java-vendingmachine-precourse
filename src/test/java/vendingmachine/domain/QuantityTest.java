package vendingmachine.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class QuantityTest {

	@Test
	@DisplayName("숫자로 개수를 만든다.")
	public void testCreateQuantity() {
	    // given
	    int count = 1;
	    // when
		Quantity quantity = new Quantity(count);
	    // then
		assertEquals("1개", quantity.toString());
	}

	@Test
	@DisplayName("개수가 음수면 예외를 던진다.")
	public void testCreateLowerZero() {
	    // given
	    int count = -1;
		// then
		assertThrows(IllegalArgumentException.class, () -> new Quantity(count));
	}

	@Test
	@DisplayName("개수는 더할 수 있다")
	public void testPlusQuantity() {
	    // given
		Quantity quantityA = new Quantity(2);
		Quantity quantityB = new Quantity(3);
	    // when
		Quantity plus = quantityA.plus(quantityB);
		// then
		assertEquals("5개", plus.toString());
	}

	@Test
	@DisplayName("같은 수량은 같은 객체로 취급한다.")
	public void testPlusEquals() {
	    // given
		Quantity quantityA = new Quantity(2);
		Quantity quantityB = new Quantity(2);
	    // when
		boolean equals = quantityA.equals(quantityB);
		// then
		assertTrue(equals);
	}
}