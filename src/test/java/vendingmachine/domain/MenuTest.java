package vendingmachine.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import vendingmachine.domain.menu.Menu;
import vendingmachine.exceptions.NotDivisibleByMinPriceCoinException;

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

	@Test
	void validatePriceNumber() {
		Throwable exception = assertThrows(IllegalArgumentException.class, () ->
			Menu.from("[상품명,오백원,4]")
		);

		assertEquals("[ERROR] 상품 가격은 정수입니다.", exception.getMessage());
	}

	@ParameterizedTest
	@ValueSource(strings = {"[상품명,0,4]", "[상품명,50,4]"})
	void validateMinPrice(String input) {
		Throwable exception = assertThrows(IllegalArgumentException.class, () ->
			Menu.from(input)
		);

		assertEquals("[ERROR] 상품 가격은 100원 이상입니다.", exception.getMessage());
	}

	@ParameterizedTest
	@ValueSource(strings = {"[상품명,111,4]", "[상품명,1111,4]"})
	void validateDividingByMinPriceCoin(String input) {
		Throwable exception = assertThrows(NotDivisibleByMinPriceCoinException.class, () ->
			Menu.from(input)
		);

		assertEquals("[ERROR] 상품 가격은 10원으로 나누어 떨어져야 합니다.", exception.getMessage());
	}

	@ParameterizedTest
	@ValueSource(strings = {"[상품명,500,넷]", "[상품명,500,4개]"})
	void validateCountNumber(String input) {
		Throwable exception = assertThrows(IllegalArgumentException.class, () ->
			Menu.from(input)
		);

		assertEquals("[ERROR] 상품 수량은 정수입니다.", exception.getMessage());
	}

}