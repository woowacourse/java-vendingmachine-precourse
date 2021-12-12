package vendingmachine.validator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ProductListValidatorTest {

	@ParameterizedTest
	@ValueSource(strings = {"[콜라,1500,1000]", "[사,0,0]", "[a,0,0];[b,0,0];[c,0,0]", "[콜라,사이다,마듀]", "[];[]",
		"[콜라,사이다,마듀,ㅁㄴㅇㄹ]"})
	void validateBracketAndSemiColonSuccess(String input) {
		// given
		// when
		// then
		ProductListValidator.validateBracketAndSemiColon(input);
	}

	@ParameterizedTest
	@ValueSource(strings = {"[콜라];", "[[", "]]", "[]", "", "[];["})
	void validateBracketAndSemiColonFail(String input) {
		// given
		// when
		// then
		assertThatIllegalArgumentException().isThrownBy(() -> ProductListValidator.validateBracketAndSemiColon(input));
	}

	@ParameterizedTest
	@ValueSource(strings = {"[콜라,사이다,밥]", "[1,2,3]", "[콜라,1000,2]", "[사이다,1000,2]"})
	void validateCommaSuccess(String input) {
		// given
		// when
		// then
		ProductListValidator.validateComma(input);
	}

	@ParameterizedTest
	@ValueSource(strings = {"[콜라]", "[1,2]", "[1,2,3,4]", "[]"})
	void validateCommaFail(String input) {
		// given
		// when
		// then
		assertThatIllegalArgumentException().isThrownBy(() -> ProductListValidator.validateComma(input));
	}

	@ParameterizedTest
	@ValueSource(strings = {"[콜라,1,2]", "[1,2,3]"})
	void validateNameLengthAndIntegerSuccess(String input) {
		// given
		// when
		// then
		ProductListValidator.validateNameLengthAndInteger(input);
	}

	@ParameterizedTest
	@ValueSource(strings = {"[콜라,d,x]", "[1,2,x]"})
	void validateNameLengthAndIntegerFail(String input) {
		// given
		// when
		// then
		assertThatIllegalArgumentException().isThrownBy(() -> ProductListValidator.validateNameLengthAndInteger(input));
	}

	@Test
	void validatePrice() {
		// given
		// when
		// then
		ProductListValidator.validatePrice(500);
		assertThatIllegalArgumentException().isThrownBy(() -> ProductListValidator.validatePrice(10));
		assertThatIllegalArgumentException().isThrownBy(() -> ProductListValidator.validatePrice(101));
	}

	@Test
	void validateQuantity() {
		// given
		// when
		// then
		ProductListValidator.validateQuantity(0);
		assertThatIllegalArgumentException().isThrownBy(() -> ProductListValidator.validateQuantity(-1));
	}
}