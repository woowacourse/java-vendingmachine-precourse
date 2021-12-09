package vendingmachine.utils;

import static org.junit.jupiter.api.Assertions.*;
import static vendingmachine.domain.Coin.*;
import static vendingmachine.utils.Constant.*;

import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import vendingmachine.domain.Coin;

class ConstantTest {

	private List<Coin> coins;

	@BeforeEach
	void beforeEach(){
		coins = Lists.list(COIN_10, COIN_50, COIN_100, COIN_500);
	}

	@Test
	void 코인_리스트_테스트(){
		List<Integer> list = COIN_LIST;
		assertEquals(coins.stream().map(s -> s.getValue()).allMatch(s -> list.contains(s)), true);
	}
}