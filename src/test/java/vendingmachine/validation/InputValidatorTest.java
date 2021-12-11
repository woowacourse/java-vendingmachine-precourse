package vendingmachine.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InputValidatorTest {
	private final InputValidator validator = new InputValidator();

	@Test
	void isValidChanges() {
		assert validator.isValidChanges("가") == false;
		assert validator.isValidChanges("-1") == false;
		assert validator.isValidChanges("451") == false;
		assert validator.isValidChanges("450");
	}
}