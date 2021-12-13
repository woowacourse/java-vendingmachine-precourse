package vendingmachine.user;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import vendingmachine.ConsoleTest;
import vendingmachine.Rollback;
import vendingmachine.config.UserConfig;

class AdministratorTest extends ConsoleTest implements Rollback {

	@Test
	@DisplayName("문자열을 입력받아 자판기를 초기화한다.")
	public void testAdminInitialize() {
		// given
		Administrator administrator = UserConfig.getAdministrator();
		// when
		changeInput("450\n[콜라,1500,20];[사이다,1000,10]");
		administrator.initialize();
		// then
		assertTrue(outputStream.toString().contains("자판기가 보유한 동전"));
		assertTrue(outputStream.toString().contains("상품명과 가격, 수량을 입력해 주세요."));
	}

	@Test
	@DisplayName("문자열이 잘못 입력될 경우 다시 입력받는다.")
	public void testAdminInitializeFail() {
		// given
		Administrator administrator = UserConfig.getAdministrator();
		// when
		changeInput("-1\n450\n[콜라,1500,20];[사이다,1000,10]");
		administrator.initialize();
		// then
		assertTrue(outputStream.toString().contains("[ERROR]"));
	}
}