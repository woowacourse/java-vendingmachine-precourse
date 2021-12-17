package vendingmachine.domain;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class CoinGenerator {
	private static final List<Integer> coin_kind = Arrays.asList(Coin.COIN_10.getAmount(),
		Coin.COIN_50.getAmount(),
		Coin.COIN_100.getAmount(),
		Coin.COIN_500.getAmount());


	public static Coin generateCoin(){
		return Coin.fromMoney(Randoms.pickNumberInList(coin_kind));
	}
}
