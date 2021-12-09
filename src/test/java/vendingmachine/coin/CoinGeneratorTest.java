package vendingmachine.coin;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import vendingmachine.Money;

class CoinGeneratorTest {

	@Test
	@DisplayName("보유 금액에 맞는 동전을 임의로 생성한다.")
	public void validateRandomCoinGenerator() {
		CoinGenerator coinGenerator = new RandomCoinGenerator();
		Map<Coin, Integer> coins = coinGenerator.generate(Money.of(200));
		for (Map.Entry<Coin, Integer> coin : coins.entrySet()) {
			System.out.println(coin);
		}
	}

}
