package vendingmachine.service;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

import vendingmachine.domain.Product;
import vendingmachine.domain.VendingMachine;
import vendingmachine.message.Message;
import vendingmachine.message.dto.ResponseMessage;
import vendingmachine.utils.CoinUtil;
import vendingmachine.validation.Validation;

public class VendingMachineService {

	private ResponseMessage result;
	private VendingMachine vendingMachine;
	private int balance;

	public VendingMachineService() {
		this.vendingMachine = new VendingMachine();
		this.result = new ResponseMessage();
	}

	public String postVendingMachineCosts(String inputStr) {
		Validation.validateNull(inputStr);
		Validation.validateCostIsNaturalNumber(inputStr);
		Validation.validateDivideTen(Integer.parseInt(inputStr));

		result.init();
		result.addMessage(Message.PRINT_COIN_IN_MACHINE.getMessage() + '\n');

		vendingMachine = CoinUtil.makeCoin(Integer.parseInt(inputStr), vendingMachine);

		result.addCoinCountMessage(vendingMachine.getCoinMap());
		return result.getResult();
	}

	public void postProductInfo(String inputStr) {
		//TODO: Validation 들 처리
		addProducts(inputStr);
	}

	public String postInputCosts(String inputStr) {
		Validation.validateNull(inputStr);
		Validation.validateCostIsNaturalNumber(inputStr);
		Validation.validateDivideTen(Integer.parseInt(inputStr));

		result.init();
		vendingMachine.setInputCost(Integer.parseInt(inputStr));
		ResponseMessage.printInputCost(vendingMachine.getInputCost());

		return result.getResult();
	}

	public boolean postProductName(String inputStr) {
		//TODO: Validation 들 처리
		result.init();
		vendingMachine.subtractInputCostAndProductAmount(inputStr);
		ResponseMessage.printInputCost(vendingMachine.getInputCost());

		if (vendingMachine.checkGetBalance()) {
			return true;
		}
		return false;
	}

	public String getBalance() {
		result.init();
		result.addMessage(Message.PRINT_BALANCE.getMessage() + '\n');
		getMinimumBalance();

		return result.getResult();
	}

	// TODO: 비즈니스 로직
	private void addProducts(String inputStr) {
		String[] products = inputStr.replaceAll("\\[", "").replaceAll("\\]", "").split(";");
		for (String rowProduct : products) {
			//TODO: Validation 처리
			String[] product = rowProduct.split(",");
			vendingMachine.addProduct(
				new Product(product[0], Integer.parseInt(product[1]), Integer.parseInt(product[2])));
		}
	}

	// TODO: 비즈니스 로직
	private void getMinimumBalance() {
		balance = vendingMachine.compareInputCostAndCoinToBalance();

		Map<Integer, Integer> coinMap = vendingMachine.getCoinMap();
		Map<Integer, Integer> balanceMap = new TreeMap<>(Collections.reverseOrder());

		for (Integer i : coinMap.keySet()) {
			balanceMap = addBalanceMapToValue(i, coinMap.get(i), balanceMap);
		}

		result.addCoinCountMessage(balanceMap);
	}

	// TODO: 비즈니스 로직
	private Map<Integer, Integer> addBalanceMapToValue(int key, int value, Map<Integer, Integer> map) {
		for (int j = 0; j < value; j++) {

			if (balance >= key) {
				map.put(key, map.getOrDefault(key, 0) + 1);
				balance -= key;
			}

			if (balance < key || balance <= 0) {
				break;
			}
		}

		return map;
	}
}



