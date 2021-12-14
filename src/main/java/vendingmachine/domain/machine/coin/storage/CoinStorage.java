package vendingmachine.domain.machine.coin.storage;

import java.util.List;

import vendingmachine.domain.machine.coin.Coin;
import vendingmachine.domain.user.User;

public interface CoinStorage {

	void save(Coin coin);

	void refund(User user);

	List<String> getAllCoinsAsString();

	List<String> getExistedCoinsAsString();

}
