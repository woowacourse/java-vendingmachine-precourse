package vendingmachine.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import vendingmachine.Rollback;
import vendingmachine.config.RepositoryConfig;
import vendingmachine.domain.Money;

class DepositRepositoryTest implements Rollback {

	DepositRepository repository = RepositoryConfig.getDepositRepository();

	@Test
	@DisplayName("금액을 저장한다.")
	public void testSave() {
	    // given
		Money money = new Money(1000);
	    // when
		Money save = repository.save(money);
		// then
		assertEquals("1000원", save.toString());
	}
}