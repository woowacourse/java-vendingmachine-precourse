package vendingmachine.domain;

import org.junit.jupiter.api.BeforeEach;

import vendingmachine.domain.product.Product;
import vendingmachine.domain.product.ProductFactory;

class ProductFactoryTest {


	private ProductFactory productFactory;
	private Product product;
	private String products;

	@BeforeEach
	void beforeEach(){
		productFactory = ProductFactory.PRODUCT_FACTORY;
		products = "[콜라,1500,20];[사이다,1000,10];[환타,800,10]";
	}

	// 기능테스트와 충돌
	// @Test
	// void 상품_생성_테스트(){
	// 	String[] productData = products.split(";");
	//
	// 	for (int i = 0; i < productData.length; i++) {
	// 		String[] data = productData[i].substring(1, productData[i].length() - 1).split(",");
	// 		int price = Integer.parseInt(data[1]);
	// 		int amount = Integer.parseInt(data[2]);
	// 		product = productFactory.createProduct(data[0], price, amount);
	// 		assertEquals(product.getPrice(), price);
	// 		assertEquals(product.getAmount(), amount);
	// 	}
	// }
}