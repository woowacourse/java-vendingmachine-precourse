package vendingmachine.job;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import vendingmachine.ConsoleTest;
import vendingmachine.Rollback;
import vendingmachine.config.JobConfig;

class ChangeSafeJobTest extends ConsoleTest implements Rollback {

	@Test
	@DisplayName("문자열을 입력받아 잔돈을 초기화한다.")
	public void testAdminInitialize() {
		rollback();
		// given
		ChangeSafeJob job = JobConfig.getChangeSafeJob();
		// when
		changeInput("40");
		job.execute();
		// then
		assertTrue(outputStream.toString().contains("자판기가 보유한 동전"));
		assertTrue(outputStream.toString().contains("500원 - 0개\n100원 - 0개\n50원 - 0개\n10원 - 4개"));
	}

}