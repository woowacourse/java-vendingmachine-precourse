package vendingmachine.utils;

import java.util.ArrayList;

import vendingmachine.models.Coin;

/**
 * <h1>코인 종류를 리스트로 반환한다</h1>
 *
 * @author yunki kim
 * @version 1.0
 * @since 2021-12-14(V1.0)
 */

public class CoinTypeGenerator {

	public static ArrayList<Integer> getCoinTypes() {
		ArrayList<Integer> coinTypes = new ArrayList<>();
		coinTypes.add(Coin.COIN_500.getAmount());
		coinTypes.add(Coin.COIN_100.getAmount());
		coinTypes.add(Coin.COIN_50.getAmount());
		coinTypes.add(Coin.COIN_10.getAmount());
		return coinTypes;
	}
}
