package vendingmachine.domain.product;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class QuantityTest {
	@ParameterizedTest
	@ValueSource(strings = {"0", "02", "한글", "en", " "})
	void 상품_수량_생성_실패_테스트(String value) {
		assertThrows(IllegalArgumentException.class, () -> {
			Quantity.from(value);
		});
	}

	@ParameterizedTest
	@ValueSource(strings = {"1"})
	void 상품_수량이_0인_경우_감소불가_테스트(String value) {
		// given
		Quantity quantity = Quantity.from(value);
		Quantity newQuantity = quantity.minus();

		// when // then
		assertThrows(IllegalArgumentException.class, newQuantity::minus);
	}
}
