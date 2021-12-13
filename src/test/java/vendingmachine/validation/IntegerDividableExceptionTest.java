package vendingmachine.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IntegerDividableExceptionTest {

	@Test
	@DisplayName("주어진 숫자로 나누어 떨어져야 한다.")
	public void testDividable() {
	    // given
		int target = 100;
	    int div = 10;
	    // then
		assertDoesNotThrow(() -> Validator.validate("숫자", target, new IntegerDividableException(div)));
	}

	@Test
	@DisplayName("주어진 숫자로 나누어 떨어지지 않으면 예외를 던진다..")
	public void testNonDividable() {
		// given
		int target = 101;
		int div = 10;
		// then
		assertThrows(IllegalArgumentException.class,
			() -> Validator.validate("숫자", target, new IntegerDividableException(div)));
	}
}