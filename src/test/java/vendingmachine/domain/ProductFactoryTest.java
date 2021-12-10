package vendingmachine.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import vendingmachine.domain.product.Product;
import vendingmachine.domain.product.ProductFactory;

class ProductFactoryTest {


	private ProductFactory productFactory;

	@BeforeEach
	void beforeEach(){
		productFactory = new ProductFactory();
	}

	@Test
	void 상품_생성_테스트(){
		String[] productData = "[콜라,1500,20];[사이다,1000,10];[환타,800,10]".split(";");

		for (int i = 0; i < productData.length; i++) {
			String[] data = productData[i].substring(1, productData[i].length() - 1).split(",");
			int price = Integer.parseInt(data[1]);
			int amount = Integer.parseInt(data[2]);
			Product product = productFactory.createProduct(data[0], price, amount);
			assertEquals(product.getPrice(), price);
			assertEquals(product.getAmount(), amount);
		}
	}
}