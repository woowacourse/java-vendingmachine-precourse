package vendingmachine.validator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

	@ParameterizedTest
	@DisplayName("올바른 입력폼으로 들어왔을때 예외가 발생하지 않는다. - 성공")
	@ValueSource(strings = {"[콜라,1500,20]", "[콜라,1500,20];[사이다,1000,10]"})
	void checkInputForm(String input) {
		//given
		//when then
		assertThatCode(
			() -> InputValidator.checkInputForm(input)
		).doesNotThrowAnyException();
	}
}