package vendingmachine.controller;

import vendingmachine.input.MachineInput;
import vendingmachine.model.Coin;
import vendingmachine.model.Product;
import vendingmachine.util.ProductBuilder;
import vendingmachine.util.RandomCoinSelector;
import vendingmachine.util.Validator;
import vendingmachine.view.MachineViewer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static vendingmachine.message.Error.DUPLICATED_PRODUCT_NAME;

public class MachineController {

	private MachineInput machineInput = new MachineInput();
	private MachineViewer viewer = new MachineViewer();
	private HashMap<Coin, Integer> coins = new HashMap<>(Coin.getCoinTypes());
	private List<Product> products = new ArrayList<>();

	public void setupVendingMachine() {
		setupChangeCoins();
		viewer.showCoinBoxStatus(coins);
		setupSellingProducts();
	}

	private void setupChangeCoins() {
		int changes = machineInput.getTotalMachineChanges();
		RandomCoinSelector randomCoinSelector = new RandomCoinSelector();
		coins = randomCoinSelector.makeRandomCoinMix(changes);
	}

	public List<Product> setupSellingProducts() {
		try {
			List<String> productsInfo = machineInput.getProductsInfo();
			makeProductsFromInfo(productsInfo);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			setupSellingProducts();
		}
		return products;
	}

	private void makeProductsFromInfo(List<String> productsInfo) {
		ProductBuilder productBuilder = new ProductBuilder();
		products = productsInfo.stream()
				.map(p -> productBuilder.makeProductFromInfo(p))
				.collect(Collectors.toList());
		checkNoDuplication();
	}

	private void checkNoDuplication() {
		boolean duplicate =  products.stream()
				.map(Product::getName)
				.distinct()
				.count() != products.size();
		if (duplicate) {
			throw new IllegalArgumentException(DUPLICATED_PRODUCT_NAME);
		}
	}
}
