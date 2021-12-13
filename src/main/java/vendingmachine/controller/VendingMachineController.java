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
	InputView inputView = new InputView();
	OutputView outputView = new OutputView();
	Validator validator = new Validator();

	public void runMachine() {
		String machineMoney = enterMachineMoney();
		int convertedMachineMoney = Utils.moneyConverter(machineMoney);
		VendingMachine vendingMachine = new VendingMachine();
		vendingMachine.generateCoin(convertedMachineMoney);
		printCurrentCoin(vendingMachine);
		while(true) {
			try {
				String products = enterMachineProduct();
				vendingMachine.generateProduct(products);
				break;
			} catch(IllegalArgumentException error) {
				System.out.println(error.getMessage());
			}
		}
		String insertMoney = enterInsertMoney();
		int convertedInsertMoney = Utils.moneyConverter(insertMoney);
		vendingMachine.initInputMoney(convertedInsertMoney);
		purchaseProduct(vendingMachine);
		printRemainCoin(vendingMachine);
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
		System.out.println("자판기가 보유한 동전");
		outputView.printCoinChange(vendingMachine.getCoinMap());
	}

	private void printRemainCoin(VendingMachine vendingMachine) {
		Map<Coin, Integer> remainCoin = calculateRemainCoin(vendingMachine.getInputMoney(),
			vendingMachine.getCoinMap());
		System.out.println("잔돈");
		outputView.printCoinChange(remainCoin);
	}

	private Map<Coin, Integer> calculateRemainCoin(int restMoney, Map<Coin, Integer> coinMap) {
		Map<Coin, Integer> returnCoinMap = new LinkedHashMap<>();

		for (Coin coin : coinMap.keySet()) {
			int count = restMoney/coin.getAmount();
			if (coinMap.get(coin) == 0) {
				continue;
			}

			if (count < coinMap.get(coin)) {
				returnCoinMap.put(coin, count);
				restMoney -= (coin.getAmount() * count);
				continue;
			}
			returnCoinMap.put(coin, coinMap.get(coin));
			restMoney -= (coin.getAmount() * coinMap.get(coin));

			if (restMoney == 0) {
				break;
			}
		}

		return returnCoinMap;
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
