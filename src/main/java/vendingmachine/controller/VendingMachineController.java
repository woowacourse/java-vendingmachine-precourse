package vendingmachine.controller;

import vendingmachine.domain.Money;
import vendingmachine.domain.VendingMachine;
import vendingmachine.service.VendingMachineService;
import vendingmachine.utils.validator.RequestValidator;
import vendingmachine.view.ExceptionView;
import vendingmachine.view.InputView;

public class VendingMachineController {
	private VendingMachine vendingMachine;

	public VendingMachineController(VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
	}

	public void insertMoney() {
		try {
			String request = InputView.requestInsertMoney();
			RequestValidator.isNumber(request);
			Money insertMoney = new Money(Integer.parseInt(request));
			VendingMachineService.insertMoney(vendingMachine, insertMoney);
		} catch (IllegalArgumentException e) {
			ExceptionView.errorUI(e.getMessage());
			insertMoney();
		}
	}
}
