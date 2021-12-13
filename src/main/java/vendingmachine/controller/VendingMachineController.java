package vendingmachine.controller;

import vendingmachine.validator.Validator;
import vendingmachine.view.InputView;

public class VendingMachineController {
	InputView inputView = new InputView();
	Validator validator = new Validator();

	public void runMachine() {
		String machineMoney = enterMoney();
		//금액 입력받기
		//자판기에게 금액 센팅
		//동전 생성
		//상품명 입력받기
		//투입 금액 입력받기
		//물건 구매하기
		//자판기 종료시 잔돈 계산하기
	}

	private String enterMoney() {
		String machineMoney = inputView.enterMachineMoney();
		String validatedMoney;
		try {
			return validator.validateMoney(machineMoney);
		} catch (IllegalArgumentException error) {
			return enterMoney();
		}
	}
}
