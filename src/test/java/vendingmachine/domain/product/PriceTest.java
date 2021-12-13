package vendingmachine.domain.product;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PriceTest {

	@ParameterizedTest
	@ValueSource(strings = {"1000"})
	void 상품_가격_생성_테스트(String value) {
		// given
		Price price = Price.from(value);

		// when // then
		assertTrue(price.equals(Price.from("1000")));
	}

	@ParameterizedTest
	@ValueSource(strings = {"02", "한글", "en", " ", "544", "-1"})
	void 상품_가격_생성_실패_테스트(String value) {
		assertThrows(IllegalArgumentException.class, () -> {
			Price.from(value);
		});
	}
}
