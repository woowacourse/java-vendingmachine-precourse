package vendingmachine.utils;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import vendingmachine.Coin;

@DisplayName("CoinTypeAmountGenerator 클래스")
@ExtendWith(MockitoExtension.class)
class CoinTypeAmountGeneratorTest {

	@Mock
	RandomGenerator randomGenerator;

	@DisplayName("Coin type별로 정해진 수량만큼 코인이 생성되었는지 확인")
	@ParameterizedTest(name = "{index} {displayName} message={0}")
	@CsvSource({"5000, 10", "1000, 1", "300, 4"})
	void generateCoinTypeAmount(final int amountMoney, final int mockRandomNumber) {
		when(randomGenerator.getRandomNumber()).thenReturn(mockRandomNumber);

		ArrayList<Integer> coinTypes = new ArrayList<>();
		coinTypes.add(Coin.COIN_500.getAmount());
		coinTypes.add(Coin.COIN_100.getAmount());
		coinTypes.add(Coin.COIN_50.getAmount());
		coinTypes.add(Coin.COIN_10.getAmount());

		final CoinTypeAmountGenerator coinTypeAmountGenerator =
			new CoinTypeAmountGenerator(randomGenerator, coinTypes);

		final HashMap<Integer, Integer> coinTypesAmount = coinTypeAmountGenerator
			.generateCoinTypesAmount(amountMoney);

		final int coin500Amount = coinTypesAmount.get(Coin.COIN_500.getAmount());
		final int coin100Amount = coinTypesAmount.get(Coin.COIN_100.getAmount());
		final int coin50Amount = coinTypesAmount.get(Coin.COIN_50.getAmount());
		final int coin10Amount = coinTypesAmount.get(Coin.COIN_10.getAmount());
		final int totalMoney = coin500Amount * Coin.COIN_500.getAmount()
			+ coin100Amount * Coin.COIN_100.getAmount()
			+ coin50Amount * Coin.COIN_50.getAmount()
			+ coin10Amount * Coin.COIN_10.getAmount();

		assertTrue(0 <= coin500Amount && coin500Amount <= amountMoney,
			"코인 500 수는 생성된 난수보다 작아야 한다");
		assertTrue(0 <= coin100Amount && coin100Amount <= amountMoney,
			"코인 100 수는 생성된 난수보다 작아야 한다");
		assertTrue(0 <= coin50Amount && coin50Amount <= amountMoney,
			"코인 50 수는 생성된 난수보다 작아야 한다");
		assertTrue(0 <= coin10Amount && coin10Amount <= amountMoney,
			"코인 10 수는 생성된 난수보다 작아야 한다");
		assertEquals(amountMoney, totalMoney, "입력한 금액과 동전의 총액이 같아야 한다");
	}
}
