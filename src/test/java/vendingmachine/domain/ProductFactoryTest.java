package vendingmachine.domain;

import static camp.nextstep.edu.missionutils.Console.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductFactoryTest {


	private ProductFactory productFactory;
	private Product product;
	private String products;

	@BeforeEach
	void beforeEach(){
		productFactory = ProductFactory.PRODUCT_FACTORY;
		products = "[콜라,1500,20];[사이다,1000,10];[환타,800,10]";
	}

	@Test
	void 상품_생성_테스트(){
		String[] productData = products.split(";");

		for (int i = 0; i < productData.length; i++) {
			String[] data = productData[i].substring(1, productData[i].length() - 1).split(",");
			int price = Integer.parseInt(data[1]);
			int amount = Integer.parseInt(data[2]);
			product = productFactory.createProduct(data[0], price, amount);
			assertEquals(product.getPrice(), price);
			assertEquals(product.getAmount(), amount);
		}
	}
}