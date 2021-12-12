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
			if (Coin.hasEnoughMoney(target,coin)) {
				target -= coin.getAmount();
				this.wallet.put(coin, wallet.get(coin) + 1);
			}
		}
		openWallet();
	}

	public void openWallet() {
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
		for (String productInfo : productList) {
			this.products.add(new Product(removeSquareBracket(productInfo)));
		}
	}

	public String removeSquareBracket(String input) {
		return input.substring(1,input.length() - 1);
	}

	public Product findProduct(String input) {
		for (Product product : products) {
			if (product.isThisName(input)) {
				return product;
			}
		}
		throw new IllegalArgumentException(ERROR_MSG_PURCHASE_PRODUCT_NAME);
	}


}
