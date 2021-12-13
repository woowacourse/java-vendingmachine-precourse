package vendingmachine.service;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import vendingmachine.repository.ProductRepository;

class ProductRepositoryServiceTest {
	private static ProductRepository productRepository;
	private static ProductRepositoryService productRepositoryService;

	@BeforeAll
	static void beforeAll() {
		productRepository = new ProductRepository();
		productRepositoryService = new ProductRepositoryService(productRepository);
	}

	@Test()
	@Order(1)
	void saveTest() {
		//given

		//when
		String userInput = "[콜라,1500,10];[사이다,1000,10]";
		productRepositoryService.saveProductRepository(userInput);

		//then
		assertThat(productRepository.getProductList())
			.extracting("name")
			.contains("콜라")
			.contains("사이다");
	}

	@Test
	void getMinPriceTest() {
		//given

		//when

		//then
		assertThat(productRepositoryService.getMinPrice())
			.isEqualTo(1000);
	}

	@Test
	void getProductStockTest() {
		//given
		ProductRepository productRepository = new ProductRepository();
		ProductRepositoryService productRepositoryService = new ProductRepositoryService(productRepository);

		//when
		String userInput = "[콜라,1500,10];[사이다,1000,10]";
		productRepositoryService.saveProductRepository(userInput);

		//then
		assertThat(productRepositoryService.getStock())
			.isEqualTo(20);
	}

	@Test
	void updateOrderTest() {
		//given
		String order = "콜라";
		int money = 2000;

		//when
		productRepositoryService.updateByOrder(order, money);

		//then
		assertThat(productRepository.findByName(order).getQuantity())
			.isEqualTo(9);
	}

}