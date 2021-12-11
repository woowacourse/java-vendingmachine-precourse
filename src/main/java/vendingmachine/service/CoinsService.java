package vendingmachine.service;

import java.util.HashMap;
import java.util.Map;

import vendingmachine.domain.coin.Coin;
import vendingmachine.domain.coin.CoinQuantity;
import vendingmachine.domain.userbalance.UserBalance;
import vendingmachine.domain.vendingmachinebalance.VendingMachineBalance;
import vendingmachine.dto.CoinsDto;
import vendingmachine.repository.CoinsRepository;

public class CoinsService {
	private final CoinsRepository coinsRepository = CoinsRepository.getInstance();

	public void generateRandomCoins(VendingMachineBalance vendingMachineBalance) {
		int remainingBalance = vendingMachineBalance.toInt();

		while (remainingBalance > 0) {
			Coin randomCoin = Coin.pickRandomWithLimit(remainingBalance);

			CoinQuantity originalCoinQuantity = coinsRepository.findByCoin(randomCoin);
			coinsRepository.updateByCoin(randomCoin, originalCoinQuantity.increaseQuantity());

			remainingBalance = remainingBalance - randomCoin.getAmount();
		}
	}

	public CoinsDto getCurrentCoins() {
		Map<Coin, CoinQuantity> coins = coinsRepository.findAll();
		return CoinsDto.from(coins);
	}

	public CoinsDto getChange(UserBalance userBalance) {
		Map<Coin, CoinQuantity> changeCoins = new HashMap<>();
		int remainingBalance = userBalance.toInt();

		for (Coin coin : Coin.values()) {
			int quantity = getCoinQuantityForChange(coin, remainingBalance);
			changeCoins.put(coin, CoinQuantity.from(quantity));

			remainingBalance = remainingBalance - (coin.getAmount() * quantity);
		}

		return CoinsDto.from(changeCoins);
	}

	private int getCoinQuantityForChange(Coin coin, int balance) {
		int maxCoinQuantityForChange = getMaxCoinQuantityForChange(coin, balance);
		int holdingQuantity = coinsRepository.findByCoin(coin).toInt();

		return Math.min(maxCoinQuantityForChange, holdingQuantity);
	}

	private int getMaxCoinQuantityForChange(Coin coin, int balance) {
		return balance / coin.getAmount();
	}
}
