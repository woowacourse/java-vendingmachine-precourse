package vendingmachine.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IntegerParsableValidationTest {
	
	@Test
	@DisplayName("문자열이 2^31 미만이면 에러를 던지지 않는다.")
	public void testIntegerNormal() {
	    // given
		String input = "2147483647";
	    // when
		String validated = Validator.validate("정수", input, new IntegerParsableValidation());
		// then
		assertEquals("2147483647", validated);
	}

	@Test
	@DisplayName("문자열이 2^31 이상이면 에러를 던진다.")
	public void testIntegerOverfow() {
		// given
		String input = "2147483648";
		// when
		assertThrows(IllegalArgumentException.class,
			() -> Validator.validate("정수", input, new IntegerParsableValidation()));
	}
}