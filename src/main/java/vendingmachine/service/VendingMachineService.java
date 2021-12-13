package vendingmachine.service;

import static constant.NumberConstant.*;

import java.util.LinkedHashMap;
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

	public void saveBalance(String rawBalance) {
		PriceException.isValidPrice(rawBalance);
		int balance = Integer.parseInt(rawBalance);
		vendingMachine.setBalance(balance);
	}

	public void setVendingMachineCoins(int balance) {
		LinkedHashMap<Coin, Integer> coinMap = new CoinService().getCoinsByBalance(balance);
		vendingMachine.setCoinMap(coinMap);
	}

	public Map<Coin,Integer> getCoinMap() {
		return vendingMachine.getCoinMap();
	}

	public void saveProductRepository(ProductRepository productRepository) {
		vendingMachine.setProductRepository(productRepository);
	}

	//반환금액에 맞는 동전 갯수 받기
	public Map<Coin, Integer> getChangeCoins(int money) {
		money %= MIN_BILL_UNIT;
		Map<Coin, Integer> coinState = vendingMachine.getCoinMap();
		return new CoinService().getChangeCoins(coinState, money);
	}
}
