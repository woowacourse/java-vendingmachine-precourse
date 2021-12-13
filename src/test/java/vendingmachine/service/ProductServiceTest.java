package vendingmachine.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import vendingmachine.Rollback;
import vendingmachine.config.ServiceConfig;
import vendingmachine.domain.ProductCandidate;

class ProductServiceTest implements Rollback {

	ProductService service = ServiceConfig.getProductService();

	@Test
	@DisplayName("상품후보목록을 상품목록으로 저장한다.")
	public void testProductPersist() {
	    // given
		List<ProductCandidate> candidates = new ArrayList<>();
		candidates.add(new ProductCandidate("콜라", "1000", "10"));
		candidates.add(new ProductCandidate("사이다", "1500", "20"));
	    // when
		String persist = service.persist(candidates);
		// then
		assertEquals("[[콜라, 1000원, 10개], [사이다, 1500원, 20개]]", persist);
	}

	@Test
	@DisplayName("상품후보목록에 중복이 있으면 예외를 던진다")
	public void testProductDuplicationPersist() {
	    // given
		List<ProductCandidate> candidates = new ArrayList<>();
		candidates.add(new ProductCandidate("콜라", "1000", "10"));
		candidates.add(new ProductCandidate("콜라", "1500", "20"));
	    // when
		assertThrows(IllegalArgumentException.class, () -> service.persist(candidates));
	    // then
	}
}