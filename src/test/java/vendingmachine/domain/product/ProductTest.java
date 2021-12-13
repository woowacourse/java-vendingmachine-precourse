package vendingmachine.domain.product;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import vendingmachine.domain.machine.Balance;

class ProductTest {

	@ParameterizedTest
	@ValueSource(strings = "콜라,1000,2")
	void 상품_이름_중복_테스트(String value) {
		// given
		Product product = Product.from(value);
		Product sameProduct = Product.from(value);

		// when // then
		assertEquals(product.isValidateSameProduct("콜라"), true);
		assertEquals(product.equals(sameProduct), true);
	}

	@ParameterizedTest
	@ValueSource(strings = {"콜라,000,2", "콜라,100,0", "콜라,0,-1", "사이다,-1,1", "커피,100,01"})
	void 상품_생성_예외_테스트(String value) {
		assertThrows(IllegalArgumentException.class, () -> {
			Product.from(value);
		});
	}

	@ParameterizedTest
	@ValueSource(strings = {"콜라,1000,2", "콜라,2000,1"})
	void 상품_구매_가능_테스트(String value) {
		// given
		Balance balance = Balance.from(2000);
		Product product = Product.from(value);

		// when // then
		assertEquals(product.isValidateProductPurchase(balance), true);
	}

	@ParameterizedTest
	@ValueSource(strings = {"콜라,3000,2"})
	void 상품_구매_가격_불가능_테스트(String value) {
		// given
		Balance balance = Balance.from(2000);
		Product product = Product.from(value);

		// when // then
		assertEquals(product.isValidateProductPurchase(balance), false);
	}

	@ParameterizedTest
	@ValueSource(strings = {"콜라,2000,1"})
	void 상품_구매_수량_불가능_테스트(String value) {
		// given
		Balance balance = Balance.from(2000);
		Product product = Product.from(value);
		product.purchase(balance);

		// when // then
		assertEquals(product.isValidateProductPurchase(balance), false);
	}
}
