package vendingmachine.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Product 클래스")
class ProductTest {

	@DisplayName("제품 정보가 제대로 저장되었는지 확인")
	@ParameterizedTest(name = "{index} {displayName} name={0}, price={1}, amount={2}")
	@CsvSource({"cola, 100, 10", "'orange juice', 200, 5"})
	void checkProductInformation(final String name, final Integer price, final Integer amount) {
		final Product product = new Product(name, price, amount);

		assertEquals(name, product.getName());
		assertEquals(price, product.getPrice());
		assertEquals(amount, product.getAmount());
	}

	@DisplayName("각 제품의 양을 설정했을때 제대로 설정이 되는지 확인")
	@ParameterizedTest(name = "{index} {displayName} amount={0}")
	@ValueSource(ints = {10, 100, -1, -10})
	void setProductAmount(final Integer amount) {
		final Product product = new Product("a", 1, amount);

		final Integer productAmount = product.getAmount();
		assertTrue(productAmount.equals(amount) || productAmount.equals(0),
			"제품의 갯수는 0보다 커야된다.");
	}
}

