package vendingmachine.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProductTest {

	@Test
	@DisplayName("상품을 생성한다.")
	public void createProduct() {
	    // given
		Name name = new Name("콜라");
		Price price = new Price(1000);
		Quantity quantity = new Quantity(10);
	    // when
		Product product = new Product(name, price, quantity);
	    // then
		assertEquals("[콜라, 1000원, 10개]", product.toString());
	}

	@Test
	@DisplayName("상품명이 같으면 같은 객체로 취급한다.")
	public void createProductEquals() {
	    // given
		Product productA = new Product(new Name("콜라"), new Price(1500), new Quantity(10));
		Product productB = new Product(new Name("콜라"), new Price(1000), new Quantity(11));
	    // then
		assertEquals(productA, productB);
	}
}