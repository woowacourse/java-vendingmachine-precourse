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

		assertEquals("[ERROR] 대괄호 사이에 상품정보를 입력해야 합니다.", exception.getMessage());
	}

	@ParameterizedTest
	@ValueSource(strings = {"[,가격,수량]", "[상품명,,수량]", "[상품명,가격,]", "[상품명,가격]", "[상품명,가격,수량,미식가점수]"})
	void validateDelimetersTest(String input) {
		Throwable exception = assertThrows(IllegalArgumentException.class, () ->
			Menu.from(input)
		);

		assertEquals("[ERROR] 상품 정보는 [상품명,가격,수량] 형태로 입력해야 합니다.", exception.getMessage());
	}

}