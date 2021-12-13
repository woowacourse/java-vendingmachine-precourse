package vendingmachine.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("inputtedDataValidation 클래스")
class InputtedDataValidationTest {

	InputtedDataValidation inputtedDataValidation = new InputtedDataValidation();

	@Nested
	@DisplayName("숫자 데이터를 검증한다. 문자열 타임의 숫자데이터가 ")
	class NumberData {

		@DisplayName("올바른 형식의 데이터라면 true를 반환한다")
		@ParameterizedTest(name = "{displayName} inputtedData={0}")
		@ValueSource(strings = {"100", "20"})
		void validInput(final String inputtedData) {
			final boolean result = inputtedDataValidation.validateNumberInput(inputtedData);
			assertTrue(result, "올바른 데이터에 대한 검증이 제대로 이루어 지지 않았다");
		}

		@DisplayName("0~9사이의 수가 아닌 다른 문자가 포함되 있으면 IllegalArgumentException을 출력한다")
		@ParameterizedTest(name = "{displayName} inputtedData={0}")
		@ValueSource(strings = {"10.2", "-23", "12de"})
		void involveNotNumberCharacter(final String inputtedData) {
			IllegalArgumentException invalidInput = assertThrows(IllegalArgumentException.class,
				() -> inputtedDataValidation.validateNumberInput(inputtedData));
			final String expectedMessage = "[ERROR]: " + inputtedData + " 정수만 입력되야 합니다";
			assertEquals(expectedMessage, invalidInput.getMessage());
		}

		@DisplayName("1의 자리가 0이 아닌 다른 숫자일 경우 IllegalArgumentException을 출력한다")
		@ParameterizedTest(name = "{displayName} inputtedData={0}")
		@ValueSource(strings = {"101", "298"})
		void invalidNumber(final String inputtedData) {
			IllegalArgumentException invalidInput = assertThrows(IllegalArgumentException.class,
				() -> inputtedDataValidation.validateNumberInput(inputtedData));
			final String expectedMessage = "[ERROR]: " + inputtedData + " 1의자리가 0인 정수여야 합니다";
			assertEquals(expectedMessage, invalidInput.getMessage());
		}

		@DisplayName("길이가 1이하면 IllegalArgumentException을 출력한다")
		@ParameterizedTest(name = "{displayName} inputtedData={0}")
		@ValueSource(strings = {"1", "3"})
		void invalidLength(final String inputtedData) {
			IllegalArgumentException invalidInput = assertThrows(IllegalArgumentException.class,
				() -> inputtedDataValidation.validateNumberInput(inputtedData));
			final String expectedMessage = "[ERROR]: " + inputtedData + " 길이가 너무 짧습니다";
			assertEquals(expectedMessage, invalidInput.getMessage());
		}
	}

	@Nested
	@DisplayName("제품 정보에 대해 검증한다. 제품 정보가")
	class ProductInformation {

		@DisplayName("올바른 형식이라면 true를 반환한다")
		@ParameterizedTest(name = "{displayName} inputtedData={0}")
		@ValueSource(strings = {"[콜라,1500,20];[사이다,1000,10]", "[콜라,1500,20]"})
		void validProductInformation(final String inputtedData) {
			final boolean result = inputtedDataValidation
				.validateProductsInformation(inputtedData);
			assertTrue(result, "유효한 제품 정보의 검증이 제대로 이루어지지 않았다");
		}

		@DisplayName("[]괄호 쌍이 맞지 않으면 IllegalArgumentException을 출력한다")
		@ParameterizedTest(name = "{displayName} inputtedData={0}")
		@ValueSource(strings = {"[콜라,1500,20];[사이다,1000,10", "[콜라,1500,20", "콜라,1500,20]"})
		void checkBrackets(final String inputtedData) {
			IllegalArgumentException invalidInput = assertThrows(IllegalArgumentException.class,
				() -> inputtedDataValidation.validateProductsInformation(inputtedData));
			final String expectedMessage = "[ERROR]: " + inputtedData + " 괄호 쌍이 맞지 않습니다";
			assertEquals(expectedMessage, invalidInput.getMessage());
		}

		@DisplayName("두 제품의 정보를 ;로 구분하고 있지 않은 경우 IllegalArgumentException을 출력한다")
		@ParameterizedTest(name = "{displayName} inputtedData={0}")
		@ValueSource(strings =
			{"[콜라,1500,20][사이다,1000,10]", "[콜라,1500,20], [사이다,1000,10]", "[콜라,1500,20]; [사이다,1000,10]"})
		void distinguishProductsInformation(final String inputtedData) {
			IllegalArgumentException invalidInput = assertThrows(IllegalArgumentException.class,
				() -> inputtedDataValidation.validateProductsInformation(inputtedData));
			final String expectedMessage = "[ERROR]: " + inputtedData + " 서로 다른 제품은 ;로 구분되야 합니다";
			assertEquals(expectedMessage, invalidInput.getMessage());
		}

		@DisplayName("하나의 제품 정보에 포함되야 하는 이름, 가격, 수량이 ,로 분리되 있지 않거나 하나 이상의 정보가 없는 경우")
		@ParameterizedTest(name = "{displayName} inputtedData={0}")
		@ValueSource(strings = {"[콜라,1500,20];[사이다,1000 10]", "[콜라,1500;20];[사이다,1000,10]"})
		void parseProductInformation(final String inputtedData) {
			IllegalArgumentException invalidInput = assertThrows(IllegalArgumentException.class,
				() -> inputtedDataValidation.validateProductsInformation(inputtedData));
			final String expectedMessage = "[ERROR]: " + inputtedData +
				" 제품의 정보는 이름,가격,수량 순으로 되있어야 하며 ,로 구분되야 합니다";
			assertEquals(expectedMessage, invalidInput.getMessage());
		}

	}

}
