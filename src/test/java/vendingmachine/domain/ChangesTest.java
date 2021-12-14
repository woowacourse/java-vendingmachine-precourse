package vendingmachine.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ChangesTest {
	@DisplayName("Changes 초기화")
	@Test
	public void initChangesMap() throws Exception {
		//given
		Changes changes = new Changes();
		List<Coin> coins = Arrays.asList(Coin.COIN_10, Coin.COIN_50, Coin.COIN_100, Coin.COIN_500);
		Map<Coin, Integer> changesMap = changes.getChangesMap();
		//when
		Set<Coin> changesMapKeySet = changesMap.keySet();
		//then
		assertTrue(coins.containsAll(changesMapKeySet));
	}

	@DisplayName("Changes 총 금액 구하기")
	@Test
	public void getTotalAmount() throws Exception {
		//given
		Changes changes = new Changes();
		int money = 50000;
		changes.makeRandomCoin(money);
		//when
		int totalAmount = changes.getTotalAmount();
		//then
		assertEquals(totalAmount, money);
	}

}