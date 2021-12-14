package vendingmachine.controller;

import vendingmachine.domain.Money;
import vendingmachine.domain.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class Controller {
	public void runMachine() {
		//메인로직 시작
		VendingMachine vendingMachine = VendingMachine.getInstance();
		vendingMachine.init();

		OutputView.printInputMachineMoneyInstruction(); //자판기가 보유하고 있는 금액을 입력해 주세요.
		// Money money = Money.of(InputView.getMoney());
		Money machineMoney = Money.of("450");
		vendingMachine.insertMachineMoney(machineMoney);
		OutputView.printResultOfgenerateCoins(vendingMachine.generateCoins());

		OutputView.printInputProductsInstruction(); //상품명과 가격, 수량을 입력해 주세요.
		InputView.getProducts(); //[콜라,1500,20];[사이다,1000,10]

	}
}
