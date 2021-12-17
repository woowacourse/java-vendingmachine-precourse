package vendingmachine.controller;

import vendingmachine.service.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class MachineController {
	private final InputView inputView = new InputView();
	private final OutputView outputView = new OutputView();
	private final VendingMachine vendingMachine;

	public MachineController(VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
	}

	public void start() {
		initMachineStatus();
		createAndSaveItem();
		int smallChangeResult = buyItems();
		printSmallChange(smallChangeResult);
	}

	private void initMachineStatus() {
		vendingMachine.toMachineCoin(inputView.enterMachineMoney());
		String currentSmallChange = vendingMachine.getInitialSmallChange();
		outputView.printMachineSmallChange(currentSmallChange);
	}

	private void createAndSaveItem() {
		vendingMachine.registItem(inputView.enterItemInfo());
	}

	private int buyItems() {
		int payMoney = Integer.parseInt(inputView.enterPayMoney());
		do{
			outputView.printPuttedMoney(payMoney);
			payMoney = vendingMachine.buyItem(payMoney, inputView.enterItemToBuy());
		}while(vendingMachine.canBuyAnything(payMoney));

		outputView.printPuttedMoney(payMoney);
		return payMoney;
	}

	private void printSmallChange(int smallChange){
		outputView.printRemainingSmallChange(vendingMachine.getResultSmallChange(smallChange));

	}

}
