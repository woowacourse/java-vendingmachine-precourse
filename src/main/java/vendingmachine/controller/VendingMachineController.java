package vendingmachine.controller;

import vendingmachine.model.VendingMachine;
import vendingmachine.util.util;
import vendingmachine.validator.Validator;
import vendingmachine.view.InputView;

public class VendingMachineController {
	InputView inputView = new InputView();
	Validator validator = new Validator();

	public void runMachine() {
		//금액 입력받기
		String machineMoney = enterMachineMoney();
		//금액 int 로 변경
		int convertedMachineMoney = util.moneyConverter(machineMoney);
		//자판기에게 금액 셋팅
		VendingMachine vendingMachine = new VendingMachine();
		vendingMachine.initOwnMoney(convertedMachineMoney);
		//동전 생성
		//상품명 입력받기
		//상품 생성
		//투입 금액 입력받기
		String insertMoney = enterInsertMoney();
		//금액 int 로 변경
		int convertedInsertMoney = util.moneyConverter(insertMoney);
		//금액 셋팅
		vendingMachine.initInputMoney(convertedInsertMoney);
		//물건 구매하기
		//자판기 종료시 잔돈 계산하기
	}

	private String enterMachineMoney() {
		String machineMoney = inputView.enterMachineMoney();
		try {
			return validator.validateMoney(machineMoney);
		} catch (IllegalArgumentException error) {
			return enterMachineMoney();
		}
	}

	//리팰토링 할 수 있지 않을까?
	private String enterInsertMoney() {
		String insertMoney = inputView.enterBuyingMoney();
		try {
			return validator.validateMoney(insertMoney);
		} catch (IllegalArgumentException error) {
			return enterInsertMoney();
		}
	}
}
