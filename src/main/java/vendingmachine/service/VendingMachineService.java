package vendingmachine.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.Coin;
import vendingmachine.domain.Product;
import vendingmachine.domain.VendingMachine;
import vendingmachine.message.Message;
import vendingmachine.message.dto.ResponseMessage;
import vendingmachine.validation.Validation;

public class VendingMachineService {

	private StringBuilder result;
	private VendingMachine vendingMachine;
	private int balance;

	private void initVendingMachine() {
		vendingMachine = new VendingMachine();
	}

	private void initResult() {
		result = new StringBuilder();
	}

	public String postVendingMachineCosts(String inputStr) {
		Validation.validateNull(inputStr);
		Validation.validateCostIsNaturalNumber(inputStr);
		Validation.validateDivideTen(Integer.parseInt(inputStr));

		initResult();
		result.append(Message.PRINT_COIN_IN_MACHINE.getMessage() + '\n');

		initVendingMachine();
		makeCoin(Integer.parseInt(inputStr));

		printCoinCount(vendingMachine.getCoinMap());
		return result.toString();
	}

	public void postProductInfo(String inputStr) {
		//TODO: Validation 들 처리(inputStr)
		addProducts(inputStr);
	}

	public String postInputCosts(String inputStr) {
		Validation.validateNull(inputStr);
		Validation.validateCostIsNaturalNumber(inputStr);
		Validation.validateDivideTen(Integer.parseInt(inputStr));

		result = new StringBuilder();
		vendingMachine.setInputCost(Integer.parseInt(inputStr));
		printInputCost();

		return result.toString();
	}

	public boolean postProductName(String inputStr) {
		//TODO: Validation 들 처리
		// 1. 문자열 아닐 때
		// 2. 상품 목록에 없을 때

		result = new StringBuilder();
		vendingMachine.subtractInputCostAndProductAmount(inputStr);
		printInputCost();

		if (vendingMachine.checkGetBalance()) {
			return true;
		}
		return false;
	}

	public String getBalance() {
		result = new StringBuilder();
		result.append(Message.PRINT_BALANCE.getMessage() + '\n');
		getMinimumBalance();

		return result.toString();
	}

	private void makeCoin(int cost) {
		while (cost > 0) {
			int randomCoin = Randoms.pickNumberInList(
				Arrays.asList(Coin.COIN_500.getAmount(), Coin.COIN_100.getAmount(),
					Coin.COIN_50.getAmount(), Coin.COIN_10.getAmount()));

			if (randomCoin > cost) {
				continue;
			}

			vendingMachine.addCoin(randomCoin);
			cost -= randomCoin;
		}
	}

	private void addProducts(String inputStr) {
		String[] products = inputStr.replaceAll("\\[", "").replaceAll("\\]", "").split(";");
		for (String rowProduct : products) {
			//TODO: Validation 처리(product)
			// 1. 이름, 가격, 수량 이상의 정보가 들어왔을 떄
			// 2. 문자열, 숫자 확인
			String[] product = rowProduct.split(",");
			// //TODO: Validation 처리
			vendingMachine.addProduct(
				new Product(product[0], Integer.parseInt(product[1]), Integer.parseInt(product[2])));
		}
	}

	private void getMinimumBalance() {
		balance = compareInputCostAndCoin();

		Map<Integer, Integer> coinMap = vendingMachine.getCoinMap();
		Map<Integer, Integer> balanceMap = new TreeMap<>(Collections.reverseOrder());

		for (Integer i : coinMap.keySet()) {
			balanceMap = addBalanceMapToValue(i, coinMap.get(i), balanceMap);
		}

		printCoinCount(balanceMap);
	}

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

	private int compareInputCostAndCoin() {
		if (vendingMachine.getInputCost() < vendingMachine.getSumCoinAmount()) {
			return vendingMachine.getSumCoinAmount() - vendingMachine.getInputCost();
		}

		return vendingMachine.getSumCoinAmount();
	}




	private void printInputCost() {
		ResponseMessage.of('\n' + Message.PRINT_INPUT_COSTS.getMessage() + vendingMachine.getInputCost() + "원");
	}

	private void printCoinCount(Map<Integer, Integer> map) {
		map.keySet().forEach(key -> {
			result.append(key + "원" + " - " + map.get(key) + "개" + '\n');
		});
	}
}



