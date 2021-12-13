package vendingmachine.domain.product;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

	@ParameterizedTest
	@ValueSource(strings = {"콜라", "사이다"})
	void 상품_동일명_테스트(String value) {
		assertEquals(Name.from(value).isValidateSameName(value), true);
	}
}
