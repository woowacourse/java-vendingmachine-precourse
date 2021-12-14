package vendingmachine.utils;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * <h1>코인 타입 별로 갯수를 정의하는 클래스</h1>
 * 자판기 내부에 있어야 하는 코인 종류와 난수를 활용해
 * 각 코인 종류에 대응되는 코인 갯수를 만든다
 *
 * @author yunki kim
 * @version 1.0
 * @since 2021-12-10(V1.0)
 */

public class CoinTypeAmountGenerator {

	private static final Integer INITIAL_AMOUNT_COIN = 0;

	private final RandomGenerator randomGenerator;

	private final ArrayList<Integer> coinTypes;

	public CoinTypeAmountGenerator(final RandomGenerator randomGenerator, ArrayList<Integer> coinTypes) {
		this.randomGenerator = randomGenerator;
		this.coinTypes = coinTypes;
	}

	private HashMap<Integer, Integer> initCoinTypesAmount() {
		HashMap<Integer, Integer> coinTypesAmount = new HashMap<>();
		coinTypes.forEach(coinType -> coinTypesAmount.put(coinType, INITIAL_AMOUNT_COIN));
		return coinTypesAmount;
	}

	private Integer fillCoin(final int amountOfMoney, final int randomNumber,
			final int coinType) {
		if(amountOfMoney < randomNumber * coinType) {
			if(amountOfMoney >= coinType) {
				return amountOfMoney / coinType;
			}
			return 0;
		}
		return randomNumber;
	}

	public HashMap<Integer, Integer> generateCoinTypesAmount(int amountOfMoney) {
		HashMap<Integer, Integer> coinTypesAmount = initCoinTypesAmount();
		while(amountOfMoney > 0) {
			for(Integer coinType : coinTypes) {
				final Integer randomNumber = randomGenerator.getRandomNumber();
				final Integer usedCoins = fillCoin(amountOfMoney, randomNumber, coinType);
				final Integer usedMoney = usedCoins * coinType;
				amountOfMoney -= usedMoney;
				final Integer exCoinAmount = coinTypesAmount.get(coinType);
				coinTypesAmount.put(coinType, exCoinAmount + usedCoins);
			}
		}
		return coinTypesAmount;
	}
}
