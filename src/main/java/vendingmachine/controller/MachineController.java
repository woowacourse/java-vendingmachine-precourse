package vendingmachine.controller;

import vendingmachine.input.CustomerInput;
import vendingmachine.input.MachineInput;
import vendingmachine.model.CoinStock;
import vendingmachine.model.Product;
import vendingmachine.util.CoinCalculator;
import vendingmachine.util.ProductBuilder;
import vendingmachine.util.RandomCoinSelector;
import vendingmachine.view.MachineViewer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static vendingmachine.message.Error.*;

public class MachineController {

	private static final String END_OPTION = "잔돈";

	private MachineInput machineInput = new MachineInput();
	private CustomerInput customerInput = new CustomerInput();
	private MachineViewer viewer = new MachineViewer();
	private List<CoinStock> coins = new ArrayList<>();
	private List<Product> products = new ArrayList<>();
	private int money = 0;

	public void setupVendingMachine() {
		setupChangeCoins();
		viewer.showCoinBoxStatus(coins);
		setupSellingProducts();
		money = customerInput.getInsertedMoney();
	}

	public void operate() {
		while (checkAnyProductRemain() && checkCanBuyCheapest()) {
			String customerInput = getCustomerInput();
			if (customerInput.equals(END_OPTION)) {
				break;
			}
			try {
				sell(customerInput);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public void returnMoney() {
		CoinCalculator coinCalculator = new CoinCalculator();
		List<CoinStock> returnCoins = coinCalculator.combineCoinsByGreedy(coins, money);
		viewer.showReturnCoins(returnCoins);
	}

	public void sell(String name) {
		Product product = getProductByName(name);
		purchaseProduct(product);
	}

	private String getCustomerInput() {
		viewer.showRemainMoney(money);
		return customerInput.getPurchaseName();
	}

	private Product getProductByName(String name) {
		return products.stream()
				.filter(product -> product.getName().equals(name))
				.findAny()
				.orElseThrow(() -> new IllegalArgumentException(NO_SUCH_PRODUCT_EXIST));
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
		return products.stream()
				.anyMatch(p -> p.isStockRemain() == true);
	}

	private boolean checkCanBuyCheapest() {
		return products.stream()
				.anyMatch(p -> p.enoughMoneyToBuy(money));
	}

	private void purchaseProduct(Product product) {
		if (!product.enoughMoneyToBuy(money)) {
			throw new IllegalArgumentException(NOT_ENOUGH_TO_BUY);
		}
		money = product.purchaseOne(money);
	}
}
