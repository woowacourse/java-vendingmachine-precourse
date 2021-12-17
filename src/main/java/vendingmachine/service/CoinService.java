package vendingmachine.service;

import vendingmachine.domain.Coin;
import vendingmachine.domain.CoinGenerator;
import vendingmachine.repository.CoinRepository;

public class CoinService {
	private static final int ZERO = 0;

	private final CoinRepository coinRepository;

	public CoinService() {
		this.coinRepository = new CoinRepository();
	}

	public void changeMoneyToCoin(int money) {
		while (money > ZERO) {
			Coin coin = CoinGenerator.generateCoin();
			if (canChange(money, coin.getAmount())) {
				coinRepository.addCoin(coin);
				money -= coin.getAmount();
			}
		}
	}

	private boolean canChange(int money, int coin) {
		if (money - coin >= ZERO) {
			return true;
		}
		return false;
	}

	public String getMachineSmallChange() {
		return coinRepository.getCurrentMachineCoin();
	}

	public String calculateSmallChange(int remainMoney) {
		return coinRepository.subtractCoins(remainMoney);
	}

}
