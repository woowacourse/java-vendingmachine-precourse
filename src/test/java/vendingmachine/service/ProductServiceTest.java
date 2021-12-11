package vendingmachine.service;

import static org.junit.jupiter.api.Assertions.*;
import static vendingmachine.config.ConstantConfig.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import vendingmachine.domain.Machine;
import vendingmachine.domain.product.ProductFactory;
import vendingmachine.domain.product.ProductRepository;
import vendingmachine.domain.product.Products;
import vendingmachine.exception.CustomerLeakMoneyException;

class ProductServiceTest {

	private Machine machine;
	private Products products;
	private ProductFactory productFactory;
	private ProductRepository productRepository;
	private ProductService productService;

	@BeforeEach
	void beforeEach(){
		machine = new Machine();
		products = new Products();
		productFactory = new ProductFactory();
		productRepository = new ProductRepository(products, productFactory);
		productService = new ProductService(machine, productRepository);
		String productInput = "[치킨,10000,10];[바나나,300,10]";
		productService.saveAll(productInput.split(SEMICOLON));
	}

	@Test
	void 상품_등록하기(){
		assertEquals(productRepository.findByName("치킨").getName(), "치킨");
		assertEquals(productRepository.findByName("바나나").getName(), "바나나");
	}

	@Test
	void 상품_판매하기(){
		assertEquals(productRepository.findByName("치킨").getAmount(), 10);
		productService.sellProduct("치킨");
		assertEquals(productRepository.findByName("치킨").getAmount(), 9);
	}

	@Test
	void 상품_이름확인하기(){
		machine.save(1000000);
		assertEquals(productService.checkProductIsExistedByName("치킨"), true);
		assertEquals(productService.checkProductIsExistedByName("가나다라"), false);
	}

	@Test
	void 상품_금액부족으로_구매불가_예외(){
		machine.save(5000);
		assertThrows(CustomerLeakMoneyException.class, ()-> {
			productService.checkProductIsExistedByName("치킨");
		});
	}

}