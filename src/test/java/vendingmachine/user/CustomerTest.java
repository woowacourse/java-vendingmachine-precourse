package vendingmachine.user;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import vendingmachine.ConsoleTest;
import vendingmachine.config.UserConfig;

class CustomerTest extends ConsoleTest {

	@Test
	@DisplayName("문자열을 입력받아 상품울 구매한다.")
	public void testCustomerPurchase() {
	    // given
		Customer customer = UserConfig.getCustomer();
		// when
		changeInput("3000\n콜라\n사이다");
		customer.purchase();
	    // then
		assertTrue(outputStream.toString().contains("투입 금액: 3000원"));
		assertTrue(outputStream.toString().contains("투입 금액: 1500원"));
		assertTrue(outputStream.toString().contains("투입 금액: 500원"));
		assertTrue(outputStream.toString().contains("잔돈\n100원 - 4개\n50원 - 1개"));
	}
}