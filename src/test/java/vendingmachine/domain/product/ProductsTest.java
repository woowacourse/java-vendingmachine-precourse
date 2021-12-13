package vendingmachine.domain.product;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import vendingmachine.domain.machine.Balance;

class ProductsTest {
	private static final String PRODUCTS_INPUT_SPLIT = ";";

	@ParameterizedTest
	@ValueSource(strings = {"콜라,1000,2;콜라,2000,1"})
	void 상품들_저장_실패_테스트(String value) {
		// given
		List<String> products = Arrays.stream(value.split(PRODUCTS_INPUT_SPLIT))
			.collect(Collectors.toList());

		// when // then
		assertThrows(IllegalArgumentException.class, () -> {
			Products.from(products);
		});
	}

	@ParameterizedTest
	@ValueSource(strings = {"콜라,1000,2;사이다,2000,1"})
	void 등록된_상품들_구매_가능_테스트(String value) {
		// given
		List<String> productList = Arrays.stream(value.split(PRODUCTS_INPUT_SPLIT))
			.collect(Collectors.toList());
		Products products = Products.from(productList);
		Balance balance = Balance.from(3000);

		// when // then
		assertEquals(products.isValidateProductsPurchase(balance), false);
	}

	@ParameterizedTest
	@ValueSource(strings = {"콜라,1000,2;사이다,2000,1"})
	void 등록된_상품들_구매_불가능_테스트(String value) {
		// given
		List<String> productList = Arrays.stream(value.split(PRODUCTS_INPUT_SPLIT))
			.collect(Collectors.toList());
		Products products = Products.from(productList);
		Balance balance = Balance.from(500);

		// when // then
		assertEquals(products.isValidateProductsPurchase(balance), true);
	}

	@ParameterizedTest
	@ValueSource(strings = {"콜라,1000,2"})
	void 상품_이름_일치_테스트(String value) {
		// given
		List<String> productList = Arrays.asList(value);
		Products products = Products.from(productList);
		Product product = Product.from("콜라,1000,2");

		// when // then
		assertEquals(product.equals(products.isCheckSameProduct("콜라")), true);
	}

	@ParameterizedTest
	@ValueSource(strings = {"콜라,1000,2"})
	void 상품_이름_불일치_테스트(String value) {
		// given
		List<String> productList = Arrays.asList(value);
		Products products = Products.from(productList);

		// when // then
		assertThrows(IllegalArgumentException.class, () -> {
			products.isCheckSameProduct("사이다");
		});
	}
}
