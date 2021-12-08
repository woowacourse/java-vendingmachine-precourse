package vendingmachine.controller;

import vendingmachine.service.VendingMachineService;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class MachineController {
	private final InputView inputView;
	private final OutputView outputView;
	private final VendingMachineService service;

	public MachineController() {
		this.inputView = new InputView();
		this.outputView = new OutputView();
		this.service = new VendingMachineService();
	}

	public void start(){
		initMachineStatus();
	}

	private void initMachineStatus(){
		int money = inputView.enterMachineMoney();
		System.out.println(money);
	}
}
