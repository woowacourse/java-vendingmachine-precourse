package vendingmachine.service;

import java.util.List;
import java.util.Map;

import exception.PriceException;
import exception.ProductException;
import vendingmachine.model.Coin;
import vendingmachine.model.Product;
import vendingmachine.model.VendingMachine;

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

	public void saveProductList(String userProducts) {
		ProductException.isValidProduct(userProducts);
		List<Product> productList = ProductService.stringToProductList(userProducts);
		ProductException.isDuplicated(productList);
		vendingMachine.setProductList(productList);
	}

}
