package vendingmachine.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProductCandidateTest {

	@Test
	@DisplayName("상품후보를 생성한다.")
	public void testCreateProductCandidate() {
	    // given
		String name = "콜라";
		String price = "1000";
		String quantity = "10";
	    // when
		ProductCandidate candidate = new ProductCandidate(name, price, quantity);
	    // then
		assertEquals("[콜라, 1000, 10]", candidate.toString());
	}

	@Test
	@DisplayName("상품후보를 상품으로 변환한다")
	public void testProductCandidateToProduct() {
		String name = "콜라";
		String price = "1000";
		String quantity = "10";
		ProductCandidate candidate = new ProductCandidate(name, price, quantity);
		// when
		Product product = candidate.toProduct();
		// then
		assertEquals("[콜라, 1000원, 10개]", product.toString());
	}
}