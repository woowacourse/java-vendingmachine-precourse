package vendingmachine.job;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import vendingmachine.ConsoleTest;
import vendingmachine.Rollback;
import vendingmachine.config.JobConfig;

class ProductJobTest extends ConsoleTest implements Rollback {
	@Test
	@DisplayName("문자열을 입력받아 상품을 초기화한다.")
	public void testAdminInitialize() {
		// given
		ProductJob job = JobConfig.getProductJob();
		// when
		changeInput("[콜라,1500,20];[사이다,1000,10]");
		job.execute();
		// then
		assertTrue(outputStream.toString().contains("상품명과 가격, 수량을 입력해 주세요"));
	}
}