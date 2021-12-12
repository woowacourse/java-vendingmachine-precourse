package vendingmachine.job;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import vendingmachine.ConsoleTest;
import vendingmachine.config.JobConfig;

class ChangeSafeJobTest extends ConsoleTest {

	@Test
	@DisplayName("문자열을 입력받아 잔돈을 초기화한다.")
	public void testAdminInitialize() {
		// given
		ChangeSafeJob job = JobConfig.getChangeSafeJob();
		// when
		changeInput("450");
		job.execute();
		// then
		assertTrue(outputStream.toString().contains("자판기가 보유한 동전"));
		assertTrue(outputStream.toString().contains(
			String.join("\n", "500원 - 0개", "100원 - 4개", "50원 - 1개", "10원 - 0개"))
		);
	}

}