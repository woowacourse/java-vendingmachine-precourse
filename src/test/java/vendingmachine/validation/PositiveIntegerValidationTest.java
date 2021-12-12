package vendingmachine.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositiveIntegerValidationTest {

	@Test
	@DisplayName("int가 0 이상이면 에러를 던지지 않는다.")
	public void testIntegerNormal() {
	    // given
	    int amount = 1;
	    // when
		Integer validated = Validator.validate("숫자", amount, new PositiveIntegerValidation());
		// then
		assertEquals(1, validated);
	}

	@Test
	@DisplayName("int가 0이면 에러를 던지지 않는다")
	public void testIntegerZero() {
	    // given
	    int amount = 0;
	    // when
		Integer validated = Validator.validate("숫자", amount, new PositiveIntegerValidation());
		// then
		assertEquals(0, validated);
	}

	@Test
	@DisplayName("int가 0 미만이면 에러를 던진다.")
	public void testIntegerLowerZero() {
	    // given
		int amount = -1;
		// when
		assertThrows(IllegalArgumentException.class,
			() -> Validator.validate("숫자", amount, new PositiveIntegerValidation()));
	    // then
	}
}