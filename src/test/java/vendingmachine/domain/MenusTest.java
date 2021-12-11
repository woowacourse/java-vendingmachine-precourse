package vendingmachine.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MenusTest {
	@ParameterizedTest
	@ValueSource(strings = {"", ";", "상품정보1;상품정보2;", ";상품정보1;상품정보2"})
	void validateDelimetersTest(String input) {
		Throwable exception = assertThrows(IllegalArgumentException.class, () ->
			Menus.from(input)
		);

		assertEquals("[ERROR] 각 상품 정보는 세미콜론(;)으로 구분합니다.", exception.getMessage());
	}
}