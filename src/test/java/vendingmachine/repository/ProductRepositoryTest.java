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
}