package vendingmachine;

import vendingmachine.coin.CoinGenerator;
import vendingmachine.coin.Coins;
import vendingmachine.coin.RandomCoinGenerator;

public class VendingMachineService {
	private final VendingMachine vendingMachine = new VendingMachine();

	public Coins generateCoin(Money retentionMoney) {
		CoinGenerator coinGenerator = new RandomCoinGenerator();
		Coins generateCoins = coinGenerator.generate(retentionMoney);
		vendingMachine.addCoinAll(generateCoins);
		return generateCoins;
	}

}
