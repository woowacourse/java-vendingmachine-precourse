package vendingmachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class Machine {

	private static final String REQUEST_MSG_MACHINE_MONEY = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	private static final String REQUEST_MSG_MACHINE_PRODUCT = "상품명과 가격, 수량을 입력해주세요.";
	private static final String ERROR_MSG_PURCHASE_PRODUCT_NAME = "[ERROR] 해당하는 상품이 없습니다.";
	private static final String INFORMATION_MSG_MACHINE_CHANGE = "자판기가 보유한 동전";
	private static final String INFORMATION_MSG_CHANGE = "잔돈";

	private int money;
	private HashMap<Coin, Integer> wallet;
	private List<Product> products;

	public Machine() {
		products = new ArrayList<>();
	}

	public void readyToOpen() {
		inputMachineMoney();
		setMachineCoin(this.money);
		inputMachineProduct();
	}

	public void inputMachineMoney() {
		System.out.println(REQUEST_MSG_MACHINE_MONEY);
		String userInput = Console.readLine();
		try {
			Validator.isNumeric(userInput);
			Validator.coinMinimumCheck(userInput);
			Validator.multipleOfTen(userInput);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			inputMachineMoney();
		}
		this.money = Integer.parseInt(userInput);
	}

	public void setWallet() {
		this.wallet = new HashMap<>();
		for (Coin coin : Arrays.stream(Coin.values()).collect(Collectors.toList())) {
			this.wallet.put(coin, 0);
		}
	}

	public void setMachineCoin(int money) {
		setWallet();
		int target = money;
		while (target > 0) {
			Coin coin = Coin.pickRandomCoin();
			if (Coin.hasEnoughMoney(target, coin)) {
				target -= coin.getAmount();
				this.wallet.put(coin, wallet.get(coin) + 1);
			}
		}
		openWallet();
	}

	public void openWallet() {
		System.out.println(INFORMATION_MSG_MACHINE_CHANGE);
		for (Coin coin : Arrays.stream(Coin.values()).collect(Collectors.toList())) {
			System.out.println(coin.getAmount() + "원 - " + this.wallet.get(coin) + "개");
		}
	}

	public void inputMachineProduct() {
		System.out.println(REQUEST_MSG_MACHINE_PRODUCT);
		String userInput = Console.readLine();
		String[] productList = userInput.split(";");
		try {
			for (String productInfo : productList) {
				Validator.productInput(removeSquareBracket(productInfo));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			inputMachineProduct();
		}
		makeProductsList(productList);
	}
	
	public void makeProductsList(String[] input) {
		for (String productInfo : input) {
			this.products.add(new Product(removeSquareBracket(productInfo)));
		}
	}

	public String removeSquareBracket(String input) {
		return input.substring(1, input.length() - 1);
	}

	public Product findProduct(String input) {
		for (Product product : products) {
			if (product.isThisName(input)) {
				return product;
			}
		}
		throw new IllegalArgumentException(ERROR_MSG_PURCHASE_PRODUCT_NAME);
	}

	public boolean minimumMoneyCheck(Customer customer) {
		for (Product product : products) {
			if (product.canSell(customer.getMoney())) {
				return true;
			}
		}
		return false;
	}

	public void giveTheChange(Customer customer) {
		System.out.println(INFORMATION_MSG_CHANGE);
		int target = customer.getMoney();
		for (Coin coin : Arrays.stream(Coin.values()).collect(Collectors.toList())) {
			if (coin.getAmount() > target) {
				continue;
			}
			if (this.wallet.get(coin) == 0) {
				continue;
			}
			int coinCount = Math.min(target / coin.getAmount(), this.wallet.get(coin));
			target -= coinCount * coin.getAmount();
			System.out.println(coin.getAmount() + "원 - " + coinCount + "개");
		}
	}

}
