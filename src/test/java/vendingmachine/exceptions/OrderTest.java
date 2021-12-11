package vendingmachine.exceptions;

import static constant.StringConstant.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import vendingmachine.model.Product;
import vendingmachine.repository.ProductRepository;
import vendingmachine.service.ProductRepositoryService;

public class OrderTest {

	private static ProductRepository productRepository;
	private static ProductRepositoryService productRepositoryService;

	@BeforeAll
	static void beforeAll() {
		productRepository = new ProductRepository();
		productRepositoryService = new ProductRepositoryService(productRepository);
	}

	@Test
	void isExistTest() {
		//given
		productRepository.addProduct(new Product("콜라",100,1));

		//when
		String userInput = "사이다";

		//then
		assertThatThrownBy(() -> {
			productRepositoryService.updateProductByOrder(userInput, 1000);})
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(ORDER_NOT_EXIST);
	}

	@Test
	void isEnoughMoneyTest() {
		//given
		productRepository.addProduct(new Product("콜라",100,1));

		//when
		String userInput = "콜라";

		//then
		assertThatThrownBy(() -> {
			productRepositoryService.updateProductByOrder(userInput, 10);})
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(NOT_ENOUGH_MONEY);
	}

	@Test
	void isLeftTest() {
		//given
		productRepository.addProduct(new Product("콜라", 100, 1));

		//when
		String userInput = "콜라";
		productRepositoryService.updateProductByOrder(userInput, 1000);

		//then
		assertThatThrownBy(() -> {
			productRepositoryService.updateProductByOrder(userInput, 900);})
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(ORDER_NOT_LEFT);
	}
}
