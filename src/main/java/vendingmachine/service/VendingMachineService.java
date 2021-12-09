package vendingmachine.service;

import java.util.Arrays;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.Coin;
import vendingmachine.domain.VendingMachine;
import vendingmachine.message.Message;
import vendingmachine.message.dto.ResponseMessage;
import vendingmachine.validation.Validation;

public class VendingMachineService {

	private StringBuilder result;
	private VendingMachine vendingMachine;

	private void initVendingMachine(){
		vendingMachine = new VendingMachine();
	}

	public String postVendingMachineCosts(String cost){
		Validation.validateNull(cost);
		Validation.validateCostIsNumber(cost);

		result = new StringBuilder();
		result.append(Message.PRINT_COIN_IN_MACHINE.getMessage()+'\n');

		//TODO: cost 로 coin 무작위로 만들기
		initVendingMachine();
		makeCoin(Integer.parseInt(cost));
		getCoinInVendingMachine();
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

	private void getCoinInVendingMachine(){
		Map<Integer,Integer> map = vendingMachine.getCoinMap();
		map.keySet().forEach(key -> {
			result.append(key+"원" + " - " + map.get(key)+"개"+'\n');
		});
	}


	public void postProductInfo(){

	}

	public void postInputCosts(){

	}

	public void postProductName(){

	}

	public void getBalance(){

	}
}
