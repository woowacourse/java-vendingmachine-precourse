package vendingmachine.domain.coin;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import vendingmachine.domain.machine.Balance;

class CoinsTest {

	@Test
	void 랜덤한_동전_생성_테스트() {
		// given // when
		Coins coins = Coins.from(450);

		// then
		int amount = 0;
		for (Map.Entry<Coin, Integer> coin : coins.getCoins().entrySet()) {
			amount += coin.getKey().getAmount() * coin.getValue();
		}
		assertEquals(amount, 450);
	}

	@ParameterizedTest
	@CsvSource(value = {"1000,450,450", "200,450,200"})
	void 보유하고_있는_동전과_보유잔액에_따른_최소_갯수_동전_생성_테스트(int balanceNum, int coinsNum, int answerNum) {
		// given
		Balance balance = Balance.from(balanceNum);
		Coins coins = Coins.from(coinsNum);

		// when
		Coins returnCoins = coins.calculateReturnCoins(balance);

		// then
		int amount = 0;
		for (Map.Entry<Coin, Integer> coin : returnCoins.getCoins().entrySet()) {
			amount += coin.getKey().getAmount() * coin.getValue();
		}
		assertEquals(amount, answerNum);
	}
}
