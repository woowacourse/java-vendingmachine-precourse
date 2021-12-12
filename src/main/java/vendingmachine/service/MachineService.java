package vendingmachine.service;

import java.util.Map;

import vendingmachine.domain.Coin;
import vendingmachine.domain.Machine;
import vendingmachine.util.CoinGenerator;

public class MachineService {
	public void addCoins(Machine machine, Integer totalCoin) {
		Map<Coin, Integer> generatedCoins = CoinGenerator.generate(Coin.getCoinList(), totalCoin);
		machine.addCoins(generatedCoins);
	}
}
