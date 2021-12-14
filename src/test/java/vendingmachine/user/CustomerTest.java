package vendingmachine.user;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import vendingmachine.ConsoleTest;
import vendingmachine.Rollback;
import vendingmachine.config.UserConfig;

class CustomerTest extends ConsoleTest implements Rollback {

	@Test
	@DisplayName("문자열을 입력받아 상품울 구매한다.")
	public void testCustomerPurchase() {
	    // given
		Customer customer = UserConfig.getCustomer();
		// when
		changeInput("3000\n콜라\n사이다");
		customer.purchase();
	    // then
		assertEquals("\n투입 금액을 입력해 주세요.\n"
			+ "\n"
			+ "투입 금액: 3000원\n"
			+ "구매할 상품명을 입력해 주세요.\n"
			+ "\n"
			+ "투입 금액: 1500원\n"
			+ "구매할 상품명을 입력해 주세요.\n"
			+ "\n"
			+ "투입 금액: 500원\n"
			+ "잔돈\n"
			+ "100원 - 4개\n"
			+ "50원 - 1개\n", outputStream.toString());
	}
}