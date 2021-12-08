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

	public void start() {
		// initMachineStatus();
		// createAndSaveItem();
		buy();
	}


	private void initMachineStatus() {
		int money = inputView.enterMachineMoney();
		service.changeMoneyToCoin(money);
		String currentSmallChange = service.getMachineSmallChange();
		outputView.printMachineSmallChange(currentSmallChange);
	}

	private void createAndSaveItem() {
		String itemInfo = inputView.enterItemInfo();
		service.saveItem(itemInfo);
	}

	private void buy() {
		int payMoney = Integer.parseInt(inputView.enterPayMoney());
		if (service.canBuyAnything(payMoney)) {
			String itemToBuy = inputView.enterItemToBuy();

		}
	}
}
