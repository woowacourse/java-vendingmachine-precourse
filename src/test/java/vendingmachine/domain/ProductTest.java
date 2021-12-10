package vendingmachine.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;
import vendingmachine.domain.product.Product;

class ProductTest extends NsTest {


	private Product product;

	@BeforeEach
	void beforeEach(){
		product = new Product("콜라",1000,10);
	}

	@Test
	void 상품_입력_테스트(){
		assertEquals(product.getPrice(), 1000);
		assertEquals(product.getAmount(), 10);
	}

	@Test
	synchronized void 상품_판매_테스트(){
		assertEquals(product.getAmount(), 10);
		product.sellProduct();
		assertEquals(product.getAmount(), 9);
	}

	@Override
	protected void runMain() {

	}
}