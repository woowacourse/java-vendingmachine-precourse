package vendingmachine.service;

import java.util.Arrays;
import java.util.Map;

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

	private void initVendingMachine() {
		vendingMachine = new VendingMachine();
	}

	public String postVendingMachineCosts(String cost) {
		Validation.validateNull(cost);
		Validation.validateCostIsNumber(cost);

		result = new StringBuilder();
		result.append(Message.PRINT_COIN_IN_MACHINE.getMessage() + '\n');

		initVendingMachine();
		makeCoin(Integer.parseInt(cost));
		getCoinInVendingMachine();
		return result.toString();
	}

	public void postProductInfo(String inputStr) {
		//TODO: Validation 들 처리(inputStr)
		addProducts(inputStr);
	}

	public void postInputCosts(){

	}

	public void postProductName(){

	}

	public void getBalance(){

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

	private void getCoinInVendingMachine(){
		Map<Integer,Integer> map = vendingMachine.getCoinMap();
		map.keySet().forEach(key -> {
			result.append(key+"원" + " - " + map.get(key)+"개"+'\n');
		});
	}

	private void addProducts(String inputStr){
		String[] products= inputStr.replaceAll("\\[","").replaceAll("\\]","").split(";");

		for(String rowProduct: products){
			//TODO: Validation 처리(product)
			// 1. 이름, 가격, 수량 이상의 정보가 들어왔을 떄
			// 2. 문자열, 숫자 확인
			String[] product = rowProduct.split(",");
			//TODO: Validation 처리
			vendingMachine.addProduct(new Product(product[0], Integer.parseInt(product[1]), Integer.parseInt(product[2])));
		}
	}
}
