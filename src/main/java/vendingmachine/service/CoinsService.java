package vendingmachine.service;

import java.util.HashMap;
import java.util.Map;

import vendingmachine.domain.coin.Coin;
import vendingmachine.domain.coin.CoinQuantity;
import vendingmachine.domain.userbalance.UserBalance;
import vendingmachine.domain.vendingmachinebalance.VendingMachineBalance;
import vendingmachine.dto.CoinsOutputDto;
import vendingmachine.repository.CoinsRepository;

public class CoinsService {
	private static final CoinsService coinsService = new CoinsService();
	private final CoinsRepository coinsRepository = CoinsRepository.getInstance();

	private CoinsService() {
	}

	public static CoinsService getInstance() {
		return coinsService;
	}

	public void generateRandomCoins(VendingMachineBalance vendingMachineBalance) {
		int remainingBalance = vendingMachineBalance.toInt();

		while (remainingBalance > 0) {
			Coin randomCoin = Coin.pickRandom();
			if (!isAbleToAddChange(randomCoin, remainingBalance)) {
				continue;
			}

			CoinQuantity originalCoinQuantity = coinsRepository.findByCoin(randomCoin);
			coinsRepository.updateByCoin(randomCoin, CoinQuantity.from(originalCoinQuantity.toInt() + 1));
			remainingBalance = remainingBalance - randomCoin.getAmount();
		}
	}

	private boolean isAbleToAddChange(Coin coin, int balance) {
		return coin.getAmount() <= balance;
	}

	public CoinsOutputDto getCurrentCoins() {
		Map<Coin, CoinQuantity> coins = coinsRepository.findAll();
		return CoinsOutputDto.from(coins);
	}

	public CoinsOutputDto getChange(UserBalance userBalance) {
		Map<Coin, CoinQuantity> coins = new HashMap<>();
		int remainingBalance = userBalance.toInt();

		for (int i = 0; i < Coin.values().length; i++) {
			Coin coin = Coin.values()[i];
			int quantity = getCoinQuantityForChange(coin, remainingBalance);
			coins.put(coin, CoinQuantity.from(quantity));
			remainingBalance = remainingBalance - (coin.getAmount() * quantity);
		}

		return CoinsOutputDto.from(coins);
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
