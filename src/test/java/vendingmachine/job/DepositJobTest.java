package vendingmachine.job;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import vendingmachine.ConsoleTest;
import vendingmachine.config.JobConfig;

class DepositJobTest extends ConsoleTest {

	@Test
	@DisplayName("문자열을 입력받아 금액을 투입한다.")
	public void testCustomerPurchase() {
		// given
		DepositJob depositJob = JobConfig.getDepositJob();
		// when
		changeInput("3000");
		depositJob.execute();
		// then
		assertTrue(outputStream.toString().contains("투입 금액을 입력해 주세요."));
	}

}