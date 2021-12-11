package vendingmachine.domain.machine.coin.storage;

import vendingmachine.domain.machine.coin.Coin;

public interface CoinStorage {

	void save(Coin coin);

}
