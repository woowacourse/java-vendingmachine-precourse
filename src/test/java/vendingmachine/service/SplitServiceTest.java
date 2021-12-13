package vendingmachine.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import vendingmachine.config.ServiceConfig;
import vendingmachine.domain.ProductCandidate;

class SplitServiceTest {

	SplitService splitService = ServiceConfig.getSplitService();

	@Test
	@DisplayName("여러개의 상품을 구분한다")
	public void testProductLineSplit() {
	    // given
		String input = "[콜라,1500,20];[사이다,1000,10]";
	    // when
		List<ProductCandidate> productCandidates = splitService.splitProducts(input);
		// then
		assertEquals(2, productCandidates.size());
	}

	@Test
	@DisplayName("상품목록이 비어있으면 에러를 던진다.")
	public void testProductLineSplitWithEmpty() {
		// given
		String input = "";
		// then
		assertThrows(IllegalArgumentException.class, () -> splitService.splitProducts(input));
	}

	@Test
	@DisplayName("상품목록이 null이면 에러를 던진다.")
	public void testProductLineSplitWithNull() {
		// given
		String input = null;
		// then
		assertThrows(IllegalArgumentException.class, () -> splitService.splitProducts(input));
	}

}