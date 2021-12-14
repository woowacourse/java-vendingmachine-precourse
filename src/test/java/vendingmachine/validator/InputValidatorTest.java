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

	@ParameterizedTest
	@DisplayName("세미콜론 존재 여부와 위치에 따라 예외가 발생한다. - 실패")
	@ValueSource(strings = {"[콜라,1500,20];", "[콜라,1500,20][사이다,1000,10]", "[콜라,1500,20];;[사이다,1000,10]"})
	void checkInputFormFauilureWhenDuplicateOrEmptySemicolon(String input) {
		//given
		//when then
		assertThatThrownBy(
			() -> InputValidator.checkInputForm(input)
		).isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest
	@DisplayName("금액이 100원 이상 10원으로 나누어 떨어질때는 예외가 발생하지 않는다. - 성공")
	@ValueSource(strings = {"1500", "100"})
	void checkMoneyForm(String input) {
		//given
		//when then
		assertThatCode(
			() -> InputValidator.checkMoneyForm(input)
		).doesNotThrowAnyException();
	}

	@ParameterizedTest
	@DisplayName("금액이 100원 미만이거나 10원으로 나누어 떨어지지 않을때 예외가 발생한다. - 실패")
	@ValueSource(strings = {"99", "1997"})
	void checkMoneyFormFailureWhenIllegalPrice(String input) {
		//given
		//when then
		assertThatThrownBy(
			() -> InputValidator.checkMoneyForm(input)
		).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("수량이 음수일때는 실패한다. - 실패")
	void checkStockFormFailureWhenInputIsNegative() {
		//given
		String InputStock = "-1";
		//when then
		assertThatThrownBy(
			() -> InputValidator.checkStockForm(InputStock)
		).isInstanceOf(IllegalArgumentException.class);
	}

}