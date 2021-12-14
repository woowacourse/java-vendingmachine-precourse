package vendingmachine.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import vendingmachine.Rollback;
import vendingmachine.config.RepositoryConfig;
import vendingmachine.domain.ChangeSafe;
import vendingmachine.domain.Coin;
import vendingmachine.domain.Quantity;

class ChangeSafeRepositoryTest implements Rollback {

	ChangeSafeRepository repository = RepositoryConfig.getChangeSafeRepository();

	@Test
	@DisplayName("잔돈을 금고에 저장한다.")
	public void testSaveChangeSafe() {
	    // given
		Map<Coin, Quantity> coinMap = Coin.createEmpty();
		coinMap.put(Coin.COIN_100, new Quantity(3));
		coinMap.put(Coin.COIN_50, new Quantity(2));
		ChangeSafe changeSafe = new ChangeSafe(coinMap);
	    // when
		ChangeSafe save = repository.save(changeSafe);
		// then
		System.out.println(save.toString());
		assertEquals("500원 - 0개\n"
			+ "100원 - 3개\n"
			+ "50원 - 2개\n"
			+ "10원 - 0개", save.toString());
	}
}