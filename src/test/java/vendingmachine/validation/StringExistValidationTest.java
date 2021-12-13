package vendingmachine.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringExistValidationTest {

	@Test
	@DisplayName("문자열이 비어있는지 확인한다.")
	public void testStringBlank() {
	    // given
	    String input = "";
	    // then
		assertThrows(IllegalArgumentException.class,
			() -> Validator.validate("문자열", input, new StringExistValidation()));
	}

	@Test
	@DisplayName("문자열이 null인지 확인한다.")
	public void testStringNull() {
		// given
		String input = "";
		// then
		assertThrows(IllegalArgumentException.class,
			() -> Validator.validate("문자열", input, new StringExistValidation()));
	}

	@Test
	@DisplayName("문자열에 값이 있으면 예외를 던지지 않는다")
	public void testStringNotBlank() {
	    // given
		String input = "1";
	    // when
		assertDoesNotThrow(() -> Validator.validate("문자열", input, new StringExistValidation()));
	    // then
	}
}