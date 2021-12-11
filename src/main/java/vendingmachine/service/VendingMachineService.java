package vendingmachine.service;

import static constant.NumberConstant.*;

import java.util.Map;

import exception.PriceException;
import vendingmachine.model.Coin;
import vendingmachine.model.VendingMachine;
import vendingmachine.repository.ProductRepository;

public class VendingMachineService {
	VendingMachine vendingMachine;

	public VendingMachineService(VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
	}

	public void saveBalance(String rawBalance) throws IllegalArgumentException {
		PriceException.isValidPrice(rawBalance);
		int balance = Integer.parseInt(rawBalance);
		vendingMachine.setBalance(balance);
	}

	public void saveCoins() {
		int balance = vendingMachine.getBalance();
		Map<Coin, Integer> coinMap = new CoinService().getCoinsByBalance(balance);
		vendingMachine.setCoinMap(coinMap);
	}

	public Map<Coin,Integer> getCoinMap() {
		return vendingMachine.getCoinMap();
	}

	public void saveProductRepository(ProductRepository productRepository) {
		vendingMachine.setProductRepository(productRepository);
	}

	public Map<Coin, Integer> getChangeCoinSet(int money) {
		money %= MIN_BILL_UNIT;
		Map<Coin, Integer> coinState = vendingMachine.getCoinMap();
		return new CoinService().getMinCoinSet(coinState, money);

	}
}
