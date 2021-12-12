package vendingmachine.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MoneyValidatorTest {

	@Test
	void validateInteger() {
		// given
		// when
		// then
		MoneyValidator.validateInteger("0");
		Assertions.assertThatIllegalArgumentException().isThrownBy(() -> MoneyValidator.validateInteger("-1"));
	}
}