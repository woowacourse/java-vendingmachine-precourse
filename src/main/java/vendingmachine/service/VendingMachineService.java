package vendingmachine.service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

	public int getMinProductPrice() {
		List<Integer> productPriceList = vendingMachine.getProductList()
			.stream()
			.map(Product::getPrice)
			.collect(Collectors.toList());
		return Collections.min(productPriceList);
	}

	public int getProductStock() {
		int productStocks = vendingMachine.getProductList()
			.stream()
			.mapToInt(Product::getQuantity)
			.sum();
		return productStocks;
	}
}
