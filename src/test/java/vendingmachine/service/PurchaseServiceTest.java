package vendingmachine.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import vendingmachine.Rollback;
import vendingmachine.config.ServiceConfig;
import vendingmachine.domain.Money;
import vendingmachine.domain.Price;

class PurchaseServiceTest implements Rollback {

	PurchaseService service = ServiceConfig.getPurchaseService();

	@Test
	@DisplayName("상품이 구매 가능한지 확인한다.")
	public void testIsAvailable() {
		Money money = new Money(3000);
		// when
		boolean available = service.isAvailable(money);
	    // then
		assertTrue(available);
	}

	@Test
	@DisplayName("상품을 구매한다.")
	public void testPurchase() {
	    // when
		Price price = service.purchase("콜라");
		// then
		assertEquals("1500원", price.toString());
	}

	@Test
	@DisplayName("상품이 없으면 예외를 던진다")
	public void testPurchaseWithWrongName() {
		// then
		assertThrows(IllegalArgumentException.class, () -> service.purchase("없는 물품"));
	}
}