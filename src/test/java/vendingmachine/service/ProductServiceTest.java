package vendingmachine.service;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import vendingmachine.constant.Symbol;
import vendingmachine.repository.ProductRepository;

class ProductServiceTest {

	private ProductService productService;
	private ProductRepository productRepository;

	@BeforeEach
	void setUp() {
		this.productRepository = new ProductRepository();
		this.productService = new ProductService(productRepository);
		List<String> productList = Arrays.asList("[콜라,300,20]", "[사이다,1500,300]");
		productService.setProducts(productList.get(0) + Symbol.PRODUCT_DELIMITER.getSymbol() + productList.get(1));
	}

	@Test
	void setProducts() {
		// given
		// when
		// then
		assertThat(productRepository.findByName("콜라")).hasValueSatisfying(p -> {
			assertThat(p.getName()).isEqualTo("콜라");
			assertThat(p.getPrice()).isEqualTo(300);
			assertThat(p.getQuantity()).isEqualTo(20);
		});
	}

	@Test
	void getAffordableList() {
		// given
		// when
		// then
		assertThat(productService.getAffordableList(550)).hasSize(1);
	}

	@Test
	void getPrice() {
		// given
		// when
		// then
		assertThat(productService.getPrice("콜라")).isEqualTo(300);
	}

	@Test
	void decreaseProduct() {
		// given
		final String productName = "콜라";
		int previousQuantity = 0;
		if (productRepository.findByName(productName).isPresent())
			previousQuantity = productRepository.findByName(productName).get().getQuantity();
		// when
		productService.decreaseProduct(productName);
		// then
		assertThat(productRepository.findByName(productName).get().getQuantity()).isLessThan(previousQuantity);
	}
}