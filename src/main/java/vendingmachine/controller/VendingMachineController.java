package vendingmachine.controller;

import vendingmachine.model.VendingMachine;
import vendingmachine.util.Utils;
import vendingmachine.validator.Validator;
import vendingmachine.view.InputView;

public class VendingMachineController {
	InputView inputView = new InputView();
	Validator validator = new Validator();

	public void runMachine() {
		//금액 입력받기
		String machineMoney = enterMachineMoney();
		//금액 int 로 변경
		int convertedMachineMoney = Utils.moneyConverter(machineMoney);
		//자판기에게 금액 셋팅
		VendingMachine vendingMachine = new VendingMachine();
		vendingMachine.initOwnMoney(convertedMachineMoney);
		//동전 생성
		vendingMachine.generateCoin();
		//상품명 입력받기
		String products = enterMachineProduct();
		//상품 생성
		vendingMachine.generateProduct(products);
		//투입 금액 입력받기
		String insertMoney = enterInsertMoney();
		//금액 int 로 변경
		int convertedInsertMoney = Utils.moneyConverter(insertMoney);
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

	//위에꺼랑 합쳐서 리팰토링 할 수 있지 않을까?
	private String enterInsertMoney() {
		String insertMoney = inputView.enterBuyingMoney();
		try {
			return validator.validateMoney(insertMoney);
		} catch (IllegalArgumentException error) {
			return enterInsertMoney();
		}
	}

	private String enterMachineProduct() {
		String machineProduct = inputView.enterMachineProduct();
		try {
			return validator.validateProduct(machineProduct);
		} catch (IllegalArgumentException error) {
			return enterMachineProduct();
		}
	}
}
