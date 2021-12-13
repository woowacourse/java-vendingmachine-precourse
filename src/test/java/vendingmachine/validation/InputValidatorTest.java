package vendingmachine.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InputValidatorTest {
	private final InputValidator validator = new InputValidator();

	@Test
	void isValidChanges() {
		assert validator.isValidMoney("가") == false;
		assert validator.isValidMoney("-1") == false;
		assert validator.isValidMoney("451") == false;
		assert validator.isValidMoney("450");
	}
}