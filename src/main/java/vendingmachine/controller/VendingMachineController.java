package vendingmachine.controller;

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
		//금액 입력받기
		String machineMoney = enterMachineMoney();
		//금액 int 로 변경
		int convertedMachineMoney = Utils.moneyConverter(machineMoney);
		//자판기에게 금액 셋팅
		VendingMachine vendingMachine = new VendingMachine();
		vendingMachine.initOwnMoney(convertedMachineMoney);
		//동전 생성
		vendingMachine.generateCoin();
		//동전 출력
		calculateCoin(vendingMachine);
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
		purchaseProduct(vendingMachine);
		//TODO 잔돈 계산하는 로직 추가
		//자판기 종료시 잔돈 계산하기
		calculateCoin(vendingMachine);

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

	private void calculateCoin(VendingMachine vendingMachine) {
		outputView.printCoinChange(vendingMachine.getCoinMap());
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
