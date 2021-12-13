package vendingmachine.validation;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import vendingmachine.domain.Name;
import vendingmachine.domain.Price;
import vendingmachine.domain.Product;
import vendingmachine.domain.Quantity;

class DistinctValidationTest {

	@Test
	@DisplayName("상품명이 중복되지 않으면 예외를 던지지 않는다.")
	public void testProductDistinct() {
	    // given
		List<Product> products = new ArrayList<>();
		products.add(new Product(new Name("콜라"), new Price(1000), new Quantity(3)));
		products.add(new Product(new Name("사이다"), new Price(1500), new Quantity(3)));
	    // when
		List<Product> validated = Validator.validate("상품", products, new DistinctValidation());
		// then
		assertEquals(products.toString(), validated.toString());
	}

	@Test
	@DisplayName("상품명이 중복되면 예외를 던진다")
	public void testProductDuplication() {
		// given
		List<Product> products = new ArrayList<>();
		products.add(new Product(new Name("콜라"), new Price(1000), new Quantity(3)));
		products.add(new Product(new Name("콜라"), new Price(1500), new Quantity(5)));
		// then
		assertThrows(IllegalArgumentException.class,
			() -> Validator.validate("상품", products, new DistinctValidation()));

	}
}