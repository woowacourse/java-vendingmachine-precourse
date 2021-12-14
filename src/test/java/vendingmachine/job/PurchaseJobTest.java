package vendingmachine.job;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import vendingmachine.ConsoleTest;
import vendingmachine.Rollback;
import vendingmachine.config.JobConfig;
import vendingmachine.domain.Money;
import vendingmachine.repository.DepositRepository;

class PurchaseJobTest extends ConsoleTest implements Rollback {

	PurchaseJob purchaseJob = JobConfig.getPurchaseJob();

	@Test
	@DisplayName("문자열을 입력받아 상품울 구매한다.")
	public void testPurchase() {
		// given
		changeInput("콜라\n사이다");
		// when
		purchaseJob.execute();
		// then
		assertEquals("\n"
			+ "투입 금액: 3000원\n"
			+ "구매할 상품명을 입력해 주세요.\n"
			+ "\n"
			+ "투입 금액: 1500원\n"
			+ "구매할 상품명을 입력해 주세요.\n"
			+ "\n"
			+ "투입 금액: 500원\n", outputStream.toString());
	}
}