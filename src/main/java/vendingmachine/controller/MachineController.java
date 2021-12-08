package vendingmachine.controller;

import java.util.HashMap;

import vendingmachine.domain.Coin;
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
		// initMachineStatus();
		createAndSaveItem();
	}

	private void initMachineStatus(){
		int money = inputView.enterMachineMoney();
		service.changeMoneyToCoin(money);
		String currentSmallChange = service.getMachineSmallChange();
		outputView.printMachineSmallChange(currentSmallChange);
	}

	private void createAndSaveItem(){
		String itemInfo = inputView.enterItemInfo();
	}
}
