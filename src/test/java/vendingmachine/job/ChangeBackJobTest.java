package vendingmachine.job;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import vendingmachine.ConsoleTest;
import vendingmachine.Rollback;
import vendingmachine.config.JobConfig;

class ChangeBackJobTest extends ConsoleTest implements Rollback {

	ChangeBackJob job = JobConfig.getChangeBackJob();

	@Test
	@DisplayName("잔돈을 돌려준다.")
	public void testChangeBackJob() {
	    // when
		job.execute();
	    // then
		assertEquals("잔돈\n"
			+ "100원 - 4개\n"
			+ "50원 - 1개\n", outputStream.toString());
	}
}