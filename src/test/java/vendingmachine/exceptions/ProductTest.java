package vendingmachine.exceptions;

import static constant.StringConstant.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exception.ProductException;

public class ProductTest {
	@Test
	void isProductWrappedTest() {
		//given
		String userInput = "콜라,1000,20";

		//when

		//then
		assertThatThrownBy(() -> {
			ProductException.isValidProduct(userInput);})
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(PRODUCT_WRAPPER_NULL);
	}

	@Test
	void isProductDividedTest() {
		//given
		String userInput = "[콜라,1000,20][사이다,1000,20]";

		//when

		//then
		assertThatThrownBy(() -> {
			ProductException.isValidProduct(userInput);})
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(PRODUCT_WRAPPER_NULL);
	}
}
