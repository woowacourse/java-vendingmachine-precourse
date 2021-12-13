package vendingmachine.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IntegerGreaterValidationTest {

	@Test
	@DisplayName("숫자가 주어진 값 이상이어야한다.")
	public void testIntegerGreater() {
	    // given
	    int target = 10;
	    int min = 9;
	    // when
		assertDoesNotThrow(() -> Validator.validate("숫자", target, new IntegerGreaterValidation(min)));
	    // then
	}

	@Test
	@DisplayName("숫자가 주어진 값 미만이면 예외를 던진다.")
	public void testIntegerLess() {
		// given
		int target = 9;
		int min = 10;
		// when
		assertThrows(IllegalArgumentException.class,
			() -> Validator.validate("숫자", target, new IntegerGreaterValidation(min)));
		// then
	}
}