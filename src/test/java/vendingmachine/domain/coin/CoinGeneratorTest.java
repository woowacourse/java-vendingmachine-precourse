package vendingmachine.domain.coin;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import vendingmachine.domain.money.Money;

class CoinGeneratorTest {
	@Test
	@DisplayName("보유 금액에 맞는 동전을 임의로 생성한다.")
	public void validateRandomCoinGenerator() {
		CoinGenerator coinGenerator = new RandomCoinGenerator();
		Coins coins = coinGenerator.generate(Money.of(200));
		System.out.println(coins);
	}
}
