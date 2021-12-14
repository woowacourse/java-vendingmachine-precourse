package vendingmachine.domain;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.constant.Constant;
import vendingmachine.type.Coin;

public class VendingMachineCoins {

	private final Map<Coin, Integer> coins;

	public VendingMachineCoins(Money vendingMachineMoney) {
		this.coins = generateVendingMachineCoins(vendingMachineMoney);
	}

	public VendingMachineCoins(Map<Coin, Integer> changeCoins) {
		this.coins = changeCoins;
	}

	public List<Coin> getKeys() {
		return new ArrayList<>(coins.keySet());
	}

	public int getAmount(Coin coin) {
		return coins.get(coin);
	}

	private Map<Coin, Integer> generateVendingMachineCoins(Money vendingMachineMoney) {
		Map<Coin, Integer> coinsMap = initializeCoinMap();
		while (vendingMachineMoney.hasMoreMoney()) {
			int amount = Randoms.pickNumberInList(Coin.getCoinList());
			if (vendingMachineMoney.isPossibleChangeToCoin(amount)) {
				addCoin(coinsMap, amount);
				vendingMachineMoney.changeToCoin(amount);
			}
		}
		return coinsMap;
	}

	private Map<Coin, Integer> initializeCoinMap() {
		Map<Coin, Integer> coinsMap = new EnumMap<>(Coin.class);
		for (Coin coin : Coin.values()) {
			coinsMap.put(coin, 0);
		}
		return coinsMap;
	}

	public void addCoin(Map<Coin, Integer> coinsMap, int amount) {
		Coin coinType = Coin.findCoinType(amount);
		coinsMap.put(coinType, coinsMap.get(coinType) + 1);
	}

	public Map<Coin, Integer> generateChangeCoins(Money userMoney) {
		Map<Coin, Integer> changeCoins = initializeCoinMap();
		for (Coin coin : coins.keySet()) {
			addChangeCoin(userMoney, changeCoins, coin);
		}
		return changeCoins;
	}

	private void addChangeCoin(Money userMoney, Map<Coin, Integer> changeCoins, Coin coin) {
		int quantity = Constant.ZERO;
		while (isPossibleGenerateChangeCoin(coin, userMoney)) {
			quantity++;
			userCoin(coin);
			userMoney.spendMoney(coin.getAmount());
		}
		if (quantity != Constant.ZERO) {
			changeCoins.put(coin, quantity);
		}
	}

	private void userCoin(Coin coin) {
		coins.put(coin, coins.get(coin) - 1);
	}

	private boolean isPossibleGenerateChangeCoin(Coin coin, Money userMoney) {
		return hasCoin(coin) && userMoney.isEnoughMoney(coin.getAmount());
	}

	public boolean hasCoin(Coin coin) {
		return coins.get(coin) > Constant.ZERO;
	}
}
