package vendingmachine.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("ValidateInputtedData 클래스")
class InputtedDataValidationTest {

	InputtedDataValidation validateInputtedData = new InputtedDataValidation();

	@Nested
	@DisplayName("숫자 데이터를 검증한다. 문자열 타임의 숫자데이터가 ")
	class NumberData {

		@DisplayName("올바른 형식의 데이터라면 true를 반환한다")
		@ParameterizedTest(name = "{displayName} inputtedData={0}")
		@ValueSource(strings = {"100", "20"})
		void validInput(final String inputtedData) {
			final boolean result = validateInputtedData.validateNumberInput(inputtedData);
			assertTrue(result, "올바른 데이터에 대한 검증이 제대로 이루어 지지 않았다");
		}

		@DisplayName("0~9사이의 수가 아닌 다른 문자가 포함되 있으면 IllegalArgumentException을 출력한다")
		@ParameterizedTest(name = "{displayName} inputtedData={0}")
		@ValueSource(strings = {"10.2", "-23", "12de"})
		void involveNotNumberCharacter(final String inputtedData) {
			IllegalArgumentException invalidInput = assertThrows(IllegalArgumentException.class,
				() -> validateInputtedData.validateNumberInput(inputtedData));
			final String expectedMessage = "[ERROR]: " + inputtedData + " 정수만 입력되야 합니다";
			assertEquals(expectedMessage, invalidInput.getMessage());
		}

		@DisplayName("1의 자리가 0이 아닌 다른 숫자일 경우 IllegalArgumentException을 출력한다")
		@ParameterizedTest(name = "{displayName} inputtedData={0}")
		@ValueSource(strings = {"101", "298"})
		void invalidNumber(final String inputtedData) {
			IllegalArgumentException invalidInput = assertThrows(IllegalArgumentException.class,
				() -> validateInputtedData.validateNumberInput(inputtedData));
			final String expectedMessage = "[ERROR]: " + inputtedData + " 1의자리가 0인 정수여야 합니다";
			assertEquals(expectedMessage, invalidInput.getMessage());
		}

		@DisplayName("길이가 1이하면 IllegalArgumentException을 출력한다")
		@ParameterizedTest(name = "{displayName} inputtedData={0}")
		@ValueSource(strings = {"1", "3"})
		void invalidLength(final String inputtedData) {
			IllegalArgumentException invalidInput = assertThrows(IllegalArgumentException.class,
				() -> validateInputtedData.validateNumberInput(inputtedData));
			final String expectedMessage = "[ERROR]: " + inputtedData + " 길이가 너무 짧습니다";
			assertEquals(expectedMessage, invalidInput.getMessage());
		}
	}
}
