package vendingmachine.repository;

import static constant.StringConstant.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import vendingmachine.model.Product;

public class ProductRepositoryTest {
	@Test
	void findByNameTest() {
		//given
		String name = "콜라";
		Product product = new Product("콜라", 1000, 10);

		//when
		ProductRepository productRepository = new ProductRepository();
		productRepository.addProduct(product);

		//then
		assertThat(productRepository.findByName(name))
			.isEqualTo(product);
	}

	@Test
	void isExistNameTest() {
		//given
		String name = "사이다";
		Product product = new Product("콜라", 1000, 10);

		//when
		ProductRepository productRepository = new ProductRepository();
		productRepository.addProduct(product);

		//then
		assertThatThrownBy(() -> {
			productRepository.findByName(name);})
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(ORDER_NOT_EXIST);
	}
}
