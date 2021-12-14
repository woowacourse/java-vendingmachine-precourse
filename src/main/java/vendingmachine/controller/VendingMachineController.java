package vendingmachine.controller;

import java.util.List;

import vendingmachine.domain.VendingMachine;
import vendingmachine.utill.InputItemValidator;
import vendingmachine.utill.InputMoneyValidator;
import vendingmachine.view.InputFromAdminView;
import vendingmachine.view.InputFromUserView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
	private VendingMachine vendingMachine;
	private InputFromAdminView inputFromAdminView;
	private InputFromUserView inputFromUserView;
	private OutputView outputView;

	public VendingMachineController() {
		InputMoneyValidator inputMoneyValidator = new InputMoneyValidator();
		InputItemValidator inputItemValidator = new InputItemValidator();

		this.vendingMachine = new VendingMachine();
		this.inputFromAdminView = new InputFromAdminView(inputMoneyValidator, inputItemValidator);
		this.inputFromUserView = new InputFromUserView(inputMoneyValidator, inputItemValidator);
		this.outputView = new OutputView();
	}

	public void useMachine() {
		interactWithAdmin();
		interactWithUser();

		outputView.displayChange(vendingMachine.getChangeInfo());
	}

	private void interactWithAdmin() {
		int machineMoney = inputFromAdminView.inputMachineMoney();
		vendingMachine.generateMachineCoins(machineMoney);
		outputView.displayGeneratedCoin(vendingMachine.getCoinInfo());

		updateMachineItems(inputFromAdminView.inputItems());
	}

	private void updateMachineItems(List<String> itemList) {
		for (String item : itemList) {
			vendingMachine.updateItemList(item);
		}
	}

	private void interactWithUser() {
		int userMoney = inputFromUserView.inputMoneyFromUser();
		outputView.displayUserMoney(vendingMachine.insertUserMoney(userMoney));

		purchaseItems();
	}

	private void purchaseItems() {
		while (!vendingMachine.isExitPoint()) {
			int change = vendingMachine.purchaseItem(inputFromUserView.inputItemName());
			outputView.displayUserMoney(change);
		}
	}
}
