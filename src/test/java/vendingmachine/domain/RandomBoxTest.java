package vendingmachine.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RandomBoxTest {

	private RandomBox randomBox;

	@BeforeEach
	void beforeEach(){
		randomBox = RandomBox.RANDOM_COIN_BOX;
	}

	@Test
	void 랜덤으로_동전_나누기_테스트(){
		Map<Integer, Integer> clip_10 =  randomBox.getNumOfCoins(10);
		assertEquals(clip_10.containsKey(10), true);

		Map<Integer, Integer> clip_1000 =  randomBox.getNumOfCoins(1000);
		assertEquals(clip_1000.keySet().stream()
				.mapToInt(k -> k*clip_1000.get(k)).sum(), 1000);
	}

}