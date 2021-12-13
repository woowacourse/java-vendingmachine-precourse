package vendingmachine.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import vendingmachine.Rollback;
import vendingmachine.config.RepositoryConfig;
import vendingmachine.domain.Name;
import vendingmachine.domain.Price;
import vendingmachine.domain.Product;
import vendingmachine.domain.ProductSet;
import vendingmachine.domain.Quantity;

class ProductRepositoryTest implements Rollback {

	ProductRepository repository = RepositoryConfig.getProductRepository();

	@Test
	@DisplayName("상품목록을 저장한다.")
	public void testProductSave() {
		// given
		ProductSet productSet = new ProductSet(
			new HashSet<>(Arrays.asList(
				new Product(new Name("콜라"), new Price(1000), new Quantity(10)),
				new Product(new Name("사이다"), new Price(1500), new Quantity(15)))
			)
		);
		// when
		String save = repository.save(productSet);
		// then
		assertEquals("[[사이다, 1500원, 15개], [콜라, 1000원, 10개]]", save);
	}

	@Test
	@DisplayName("상품을 구매한다.")
	public void testProductPurchase() {
		// given
		Name name = new Name("콜라");
		// when
		Price price = repository.purchase(name);
	    // then
		assertEquals("1500원", price.toString());
	}

	@Test
	@DisplayName("상품이 없으면 예외를 던진다")
	public void testPurchaseWrongName() {
	    // when
		Name name = new Name("없는 물건");
		// then
		assertThrows(IllegalArgumentException.class, () -> repository.purchase(name));
	}
}