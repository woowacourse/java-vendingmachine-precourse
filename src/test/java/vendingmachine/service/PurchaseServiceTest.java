package vendingmachine.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import vendingmachine.Rollback;
import vendingmachine.config.ServiceConfig;
import vendingmachine.domain.Money;

class PurchaseServiceTest implements Rollback {

	PurchaseService service = ServiceConfig.getPurchaseService();

	@Test
	@DisplayName("금액의 현황 문자열을 얻는다.")
	public void testRetrieveMoneyStatus() {
		// when
		String status = service.retrieveMoneyStatus();
		// then
		assertEquals("3000원", status);
	}

	@Test
	@DisplayName("금액의 현황을 얻는다.")
	public void testRetrieveMoney() {
		// when
		Money money = service.retrieveMoney();
		// then
		assertEquals("3000원", money.toString());
	}

	@Test
	@DisplayName("상품이 구매 가능한지 확인한다.")
	public void testIsAvailable() {
		// when
		boolean available = service.isAvailable();
	    // then
		assertTrue(available);
	}

	@Test
	@DisplayName("상품을 구매한다.")
	public void testPurchase() {
	    // when
		service.purchase("콜라");
	    // then
		assertEquals("1500원", service.retrieveMoney().toString());
	}

	@Test
	@DisplayName("상품이 없으면 예외를 던진다")
	public void testPurchaseWithWrongName() {
		// then
		assertThrows(IllegalArgumentException.class, () -> service.purchase("없는 물품"));
	}
}