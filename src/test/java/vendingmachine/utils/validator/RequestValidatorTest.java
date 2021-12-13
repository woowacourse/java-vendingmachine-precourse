package vendingmachine.utils.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RequestValidatorTest {
	@DisplayName("입력값은 양수여야 한다.")
	@Test
	void isNumber() {
		assertThatThrownBy(() -> RequestValidator.isNumber("-1"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("입력값은 양수여야 한다.");
	}

	@DisplayName("입력값은 빈 값이면 안된다.")
	@Test
	void isEmpty() {
		assertThatThrownBy(() -> RequestValidator.isEmpty(""))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("입력값은 빈 값이면 안된다.");
	}
}
