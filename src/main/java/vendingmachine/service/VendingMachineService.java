package vendingmachine.service;

import vendingmachine.Coin;
import vendingmachine.validation.Validation;

public class VendingMachineService {

	public void postVendingMachineCosts(String cost){
		Validation.validateNull(cost);
		Validation.validateCostIsNumber(cost);

		makeCoin(Integer.parseInt(cost));
		//TODO: cost 로 coin 무작위로 만들기
	}

	private void makeCoin(int cost){

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
