package vendingmachine.utils.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

	@DisplayName("상품 목록 입력 정규식")
	@ParameterizedTest
	@ValueSource(strings = {"[콜라,1000,10", "콜라,1000,10]", "[콜라,100010]", "[콜라1000,10]"})
	void isMatchRegexToProduct(String request) {
		RequestValidator.isMatchRegexToProduct("[콜라,1000,10]");
		assertThatThrownBy(() -> RequestValidator.isMatchRegexToProduct(request))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
