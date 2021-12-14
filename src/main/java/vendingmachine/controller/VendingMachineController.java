package vendingmachine.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.models.Coin;
import vendingmachine.models.Product;
import vendingmachine.models.VendingMachine;
import vendingmachine.utils.CoinTypeAmountGenerator;
import vendingmachine.view.VendingMachineInput;
import vendingmachine.view.VendingMachineOutput;

/**
 * <h1>자판기 동작 로직</h1>
 *
 * @author yunki kim
 * @version 1.0
 * @since 2021-12-14(V1.0)
 */

public class VendingMachineController {

	private VendingMachine vendingMachine;

	private final VendingMachineOutput vendingMachineOutput;

	private final VendingMachineInput vendingMachineInput;

	private final CoinTypeAmountGenerator coinTypeAmountGenerator;

	public VendingMachineController(final VendingMachineOutput vendingMachineOutput,
			final VendingMachineInput vendingMachineInput, final CoinTypeAmountGenerator coinTypeAmountGenerator) {
		this.vendingMachineOutput = vendingMachineOutput;
		this.vendingMachineInput = vendingMachineInput;
		this.coinTypeAmountGenerator = coinTypeAmountGenerator;
	}

	private void inputVendingMachineInformation() {
		final int amountMoney = vendingMachineInput.inputAmountOfMoney();
		final HashMap<Integer, Integer> coinTypesAmount =
			coinTypeAmountGenerator.generateCoinTypesAmount(amountMoney);
		vendingMachineOutput.printCoinTypesAmount(coinTypesAmount);
		ArrayList<Product> products = vendingMachineInput.inputProductsInformation();
		vendingMachine = new VendingMachine(coinTypesAmount, products);
		final int userInputtedMoney = vendingMachineInput.inputMoney();
		vendingMachine.setUserInputtedMoney(userInputtedMoney);
	}

	private boolean hasEnoughMoney(final int userInputtedMoney, final List<Integer> productPrice) {
		final List<Integer> ProductsCanBuy = productPrice.stream()
			.filter(price -> price <= userInputtedMoney)
			.collect(Collectors.toList());
		return ProductsCanBuy.size() > 0;
	}

	private boolean hasProduct(final List<Integer> productAmount) {
		final List<Integer> productsAvailableForSale = productAmount.stream()
			.filter(amount -> amount > 0)
			.collect(Collectors.toList());
		return productsAvailableForSale.size() > 0;
	}

	private boolean canPurchaseProduct() {
		final ArrayList<Product> products = vendingMachine.getProducts();
		final List<Integer> productPrices = products.stream()
			.map(Product::getPrice)
			.collect(Collectors.toList());
		final List<Integer> productAmount = products.stream()
			.map(Product::getAmount)
			.collect(Collectors.toList());

		return hasEnoughMoney(vendingMachine.getUserInputtedMoney(), productPrices)
			&& hasProduct(productAmount);
	}

	private ArrayList<Product> sellProduct(final String selectedProduct,
			final ArrayList<Product> products, final int userInputtedMoney) {
		return products.stream()
			.peek(product -> {
				if (product.getName().equals(selectedProduct)) {
					final int productAmount = product.getAmount();
					final int productPrice = product.getPrice();
					product.setAmount(productAmount - 1);
					vendingMachine.setUserInputtedMoney(userInputtedMoney - productPrice);
				}
			}).collect(Collectors.toCollection(ArrayList::new));
	}

	private void purchaseProduct() {
		while(canPurchaseProduct()) {
			vendingMachineOutput.printUserInputtedMoney(
				vendingMachine.getUserInputtedMoney());
			final String selectedProduct = vendingMachineInput.selectProduct();
			final ArrayList<Product> products = sellProduct(selectedProduct,
				vendingMachine.getProducts(), vendingMachine.getUserInputtedMoney());
			vendingMachine.setProducts(products);
		}
	}

	private ArrayList<Integer> getCoinTypes() {
		final ArrayList<Integer> coinTypes = new ArrayList<>();
		coinTypes.add(Coin.COIN_500.getAmount());
		coinTypes.add(Coin.COIN_100.getAmount());
		coinTypes.add(Coin.COIN_50.getAmount());
		coinTypes.add(Coin.COIN_10.getAmount());
		return coinTypes;
	}

	private int calculateUsedCoins(final int coins, final int coinTypeAmount) {
		return Math.min(coins, coinTypeAmount);
	}

	private HashMap<Integer, Integer> makeChanges(HashMap<Integer, Integer> coinTypesAmount) {
		final ArrayList<Integer> coinTypes = getCoinTypes();
		final HashMap<Integer, Integer> changes = new HashMap<>();
		coinTypes.forEach(coinType -> {
			final int restedMoney = vendingMachine.getUserInputtedMoney();
			final int coinTypeAmount = coinTypesAmount.get(coinType);
			final int coins = restedMoney / coinType;
			if(coinTypeAmount > 0 && coins > 0) {
				final int usedCoins = calculateUsedCoins(coins, coinTypeAmount);
				vendingMachine.setUserInputtedMoney(restedMoney - (coinType * usedCoins));
				changes.put(coinType, usedCoins);
			}
		});
		return changes;
	}

	public void turnOn() {
		inputVendingMachineInformation();
		purchaseProduct();
		vendingMachineOutput.printUserInputtedMoney(vendingMachine.getUserInputtedMoney());
		vendingMachineOutput.printChanges(
			makeChanges(vendingMachine.getCoinTypesAmount()));
	}

}
