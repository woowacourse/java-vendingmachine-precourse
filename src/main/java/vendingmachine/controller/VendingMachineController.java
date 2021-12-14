package vendingmachine.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import vendingmachine.model.Coin;
import vendingmachine.model.VendingMachine;
import vendingmachine.util.Utils;
import vendingmachine.validator.Validator;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
	private static final String CHANGE = "잔돈";
	private static final String MACHINE_MONEY = "자판기가 보유한 동전";

	InputView inputView = new InputView();
	OutputView outputView = new OutputView();
	Validator validator = new Validator();

	public void runMachine() {
		String machineMoney = enterMachineMoney();
		int convertedMachineMoney = Utils.moneyConverter(machineMoney);
		VendingMachine vendingMachine = new VendingMachine();
		vendingMachine.generateCoin(convertedMachineMoney);
		printCurrentCoin(vendingMachine);
		enterAndGenerateMachineProduct(vendingMachine);
		String insertMoney = enterInsertMoney();
		int convertedInsertMoney = Utils.moneyConverter(insertMoney);
		vendingMachine.initInputMoney(convertedInsertMoney);
		purchaseProduct(vendingMachine);
		printRemainCoin(vendingMachine);
	}

	private void enterAndGenerateMachineProduct(VendingMachine vendingMachine) {
		while(true) {
			try {
				String products = enterMachineProduct();
				vendingMachine.generateProduct(products);
				break;
			} catch(IllegalArgumentException error) {
				System.out.println(error.getMessage());
			}
		}
	}

	private void purchaseProduct(VendingMachine vendingMachine) {
		outputView.printInsertMoney(vendingMachine.getInputMoney());

		while (vendingMachine.end()) {
			try {
				String productName = enterBuyingProduct();
				vendingMachine.purchase(productName);
				outputView.printInsertMoney(vendingMachine.getInputMoney());
			} catch (IllegalArgumentException error) {
				System.out.println(error.getMessage());
			}
		}
	}

	private void printCurrentCoin(VendingMachine vendingMachine) {
		System.out.println(MACHINE_MONEY);
		outputView.printCoinChange(vendingMachine.getCoinMap());
	}

	private void printRemainCoin(VendingMachine vendingMachine) {
		Map<Coin, Integer> remainCoin = calculateRemainCoin(vendingMachine.getInputMoney(),
			vendingMachine.getCoinMap());
		System.out.println(CHANGE);
		outputView.printCoinChange(remainCoin);
	}

	private Map<Coin, Integer> calculateRemainCoin(int restMoney, Map<Coin, Integer> coinMap) {
		Map<Coin, Integer> returnCoinMap = new LinkedHashMap<>();

		for (Coin coin : coinMap.keySet()) {
			int count = getCount(restMoney, coinMap, coin);

			if (count == 0 || restMoney == 0) {
				continue;
			}
			returnCoinMap.put(coin, count);
			restMoney -= (coin.getAmount() * count);
		}
		return returnCoinMap;
	}

	private int getCount(int restMoney, Map<Coin, Integer> coinMap, Coin coin) {
		int count = restMoney / coin.getAmount();
		if (count >= coinMap.get(coin)) {
			count = coinMap.get(coin);
		}
		return count;
	}

	private String enterMachineMoney() {
		String machineMoney = inputView.enterMachineMoney();
		try {
			return validator.validateMoney(machineMoney);
		} catch (IllegalArgumentException error) {
			System.out.println(error.getMessage());
			return enterMachineMoney();
		}
	}

	//위에꺼랑 합쳐서 리팰토링 할 수 있지 않을까?
	private String enterInsertMoney() {
		String insertMoney = inputView.enterBuyingMoney();
		try {
			return validator.validateMoney(insertMoney);
		} catch (IllegalArgumentException error) {
			System.out.println(error.getMessage());
			return enterInsertMoney();
		}
	}

	private String enterMachineProduct() {
		String machineProduct = inputView.enterMachineProduct();
		try {
			return validator.validateProduct(machineProduct);
		} catch (IllegalArgumentException error) {
			System.out.println(error.getMessage());
			return enterMachineProduct();
		}
	}

	private String enterBuyingProduct() {
		String buyingProduct = inputView.enterBuyingProduct();
		try {
			return validator.validateBuyingProduct(buyingProduct);
		} catch (IllegalArgumentException error) {
			System.out.println(error.getMessage());
			return enterBuyingProduct();
		}
	}
}
