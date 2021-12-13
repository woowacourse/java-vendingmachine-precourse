package vendingmachine.service;

import java.util.Map;

import vendingmachine.domain.ChangeSafe;
import vendingmachine.domain.Coin;
import vendingmachine.domain.CoinGenerator;
import vendingmachine.domain.Money;
import vendingmachine.domain.Quantity;
import vendingmachine.repository.ChangeSafeRepository;

public class ChangeSafeService {

	private final CoinGenerator coinGenerator;
	private final ChangeSafeRepository repository;

	public ChangeSafeService(CoinGenerator coinGenerator, ChangeSafeRepository repository) {
		this.coinGenerator = coinGenerator;
		this.repository = repository;
	}

	public String generateChangeSafe(Money money) {
		Map<Coin, Quantity> coinMap = coinGenerator.generate(money);
		return repository.save(new ChangeSafe(coinMap)).toString();
	}

	public String giveChange(Money money) {
		ChangeSafe changeSafe = repository.get();
		return changeSafe.giveChange(money).toString();
	}

}
