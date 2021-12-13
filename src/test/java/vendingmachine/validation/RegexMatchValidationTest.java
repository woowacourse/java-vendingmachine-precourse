package vendingmachine.validation;

import static org.junit.jupiter.api.Assertions.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RegexMatchValidationTest {

	@Test
	@DisplayName("정규표현식으로 추출한 값이 올바른지 확인한다.")
	public void testProductStringRegex() {
		// given
		Pattern pattern = Pattern.compile("\\d+");
		String input = "1234";
		// when
		Matcher matcher = pattern.matcher(input);
		// then
		assertDoesNotThrow(() -> Validator.validate("상품", matcher, new RegexMatchValidation()));
	}

	@Test
	@DisplayName("정규표현식이 일치하지 않으면 에러를 던진다.")
	public void testProductStringRegexFail() {
		// given
		Pattern pattern = Pattern.compile("\\d+");
		String input = "1234a";
		// when
		Matcher matcher = pattern.matcher(input);
		// then
		assertThrows(IllegalArgumentException.class,
			() -> Validator.validate("상품", matcher, new RegexMatchValidation()));
	}
}