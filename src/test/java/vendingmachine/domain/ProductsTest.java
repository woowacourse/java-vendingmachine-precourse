package vendingmachine.domain;

import java.util.Objects;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ProductsTest {
	private Products products;

	@BeforeEach
	void setUp() {
		products = new Products();
		products.add(new Product("콜라",new Money(1000), 1));
		products.add(new Product("사이다",new Money(800), 1));
	}

	@DisplayName("구매 가능한 상품 중 최소 가격인 상품")
	@Test
	void getCheapestProduct() {
		assertThat(products.getCheapestProduct().hashCode()).isEqualTo(Objects.hash("사이다"));
	}

	@DisplayName("상품 이름으로 상품 찾기")
	@Test
	void findForName() {
		assertThat(products.findForName("콜라").hashCode()).isEqualTo(Objects.hash("콜라"));
	}
}
