package vendingmachine.exceptions;

import static constant.StringConstant.*;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import exception.ProductException;
import vendingmachine.model.Product;

public class ProductTest {

	@Test
	void isProductEmptyTest() {
		//given
		String userInput = "";

		//when

		//then
		assertThatThrownBy(() -> {
			ProductException.isValidProduct(userInput);})
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(PRODUCT_NAME_NULL);
	}

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
			.hasMessageContaining(PRODUCT_NOT_DIVIDED);
	}

	@Test
	void isProductPriceNumberTest() {
		//given
		String userInput = "[콜라,천원,20]";

		//when

		//then
		assertThatThrownBy(() -> {
			ProductException.isValidProduct(userInput);})
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(NOT_NUMBER);
	}

	@Test
	void isProductPricePositiveTest() {
		//given
		String userInput = "[콜라,-1,20]";

		//when

		//then
		assertThatThrownBy(() -> {
			ProductException.isValidProduct(userInput);})
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(NOT_POSITIVE);
	}

	@Test
	void isProductQuantityNumberTest() {
		//given
		String userInput = "[콜라,20,천원]";

		//when

		//then
		assertThatThrownBy(() -> {
			ProductException.isValidProduct(userInput);})
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(NOT_NUMBER);
	}

	@Test
	void isProductQuantityPositiveTest() {
		//given
		String userInput = "[콜라,20,-1]";

		//when

		//then
		assertThatThrownBy(() -> {
			ProductException.isValidProduct(userInput);})
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(NOT_POSITIVE);
	}

	@Test
	void isProductDuplicateTest() {
		//given
		Product product_1 = new Product("콜라", 100, 2);
		Product product_2 = new Product("콜라", 200, 3);

		//when
		List<Product> productList = new ArrayList<>();
		productList.add(product_1);
		productList.add(product_2);

		//then
		assertThatThrownBy(() -> {
			ProductException.isDuplicated(productList);})
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(PRODUCT_NAME_DUPLICATED);
	}
}
