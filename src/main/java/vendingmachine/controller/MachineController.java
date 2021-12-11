package vendingmachine.controller;

import vendingmachine.input.CustomerInput;
import vendingmachine.input.MachineInput;
import vendingmachine.model.Coin;
import vendingmachine.model.Product;
import vendingmachine.util.ProductBuilder;
import vendingmachine.util.RandomCoinSelector;
import vendingmachine.view.MachineViewer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static vendingmachine.message.Error.DUPLICATED_PRODUCT_NAME;
import static vendingmachine.message.Error.NO_SUCH_PRODUCT_EXIST;

public class MachineController {

	private MachineInput machineInput = new MachineInput();
	private CustomerInput customerInput = new CustomerInput();
	private MachineViewer viewer = new MachineViewer();
	private HashMap<Coin, Integer> coins = new HashMap<>(Coin.getCoinTypes());
	private List<Product> products = new ArrayList<>();
	private int money = 0;

	public void setupVendingMachine() {
		setupChangeCoins();
		viewer.showCoinBoxStatus(coins);
		setupSellingProducts();
		money = customerInput.getInsertedMoney();
	}

	public void operate() {
		while (checkAnyProductRemain()) {
			sell();
		}
	}

	public void sell() {
		Product product = getProductByName(getPurchaseName());
		money = product.purchaseOne(money);
	}

	private String getPurchaseName() {
		String name = "";
		try {
			viewer.showRemainMoney(money);
			name = customerInput.getPurchaseName();
			checkProductIsExist(name);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			getPurchaseName();
		}
		return name;
	}

	private Product getProductByName(String name) {
		return products.stream()
				.filter(product -> product.getName().equals(name))
				.findAny()
				.orElseThrow(() -> new IllegalArgumentException());
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

	private void checkProductIsExist(String name) {
		boolean exist = products.stream()
				.anyMatch(p -> p.getName().equals(name));
		if (!exist) {
			throw new IllegalArgumentException(NO_SUCH_PRODUCT_EXIST);
		}
	}

	private boolean checkAnyProductRemain() {
		boolean remain = products.stream()
				.anyMatch(p -> p.isStockRemain() == true);
		if (remain) {
			return true;
		}
		return false;
	}
}
