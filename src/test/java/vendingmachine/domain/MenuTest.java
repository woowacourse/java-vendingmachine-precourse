package vendingmachine.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MenuTest {

	@ParameterizedTest
	@ValueSource(strings = {"[내용", "내용]"})
	void validateBracketsTest(String input) {
		Throwable exception = assertThrows(IllegalArgumentException.class, () ->
			Menu.from(input)
		);

		assertEquals("[ERROR] 대괄호 사이에 메뉴정보를 입력해야 합니다.", exception.getMessage());
	}

}