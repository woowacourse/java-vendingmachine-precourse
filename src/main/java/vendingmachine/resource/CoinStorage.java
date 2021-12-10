package vendingmachine.resource;

import java.util.ArrayList;
import java.util.List;

public class CoinStorage {
	private static final CoinStorage coinStorage = new CoinStorage();

	private List<Coin> coins = new ArrayList<>();

	private CoinStorage(){
	}

	public static CoinStorage getCoinStorage(){
		return coinStorage;
	}

	public void createCoin(int amount){
		coins.add(Coin.getCoinFromAmount(amount));
	}
}
