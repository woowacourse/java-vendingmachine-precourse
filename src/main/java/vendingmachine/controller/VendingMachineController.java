package vendingmachine.controller;

import vendingmachine.Parser;
import vendingmachine.domain.Machine;
import vendingmachine.validation.InputValidator;
import vendingmachine.validation.MachineValidator;
import vendingmachine.view.MachineView;

public class VendingMachineController {
	private final InputValidator validator = new InputValidator();
	private final MachineView view = new MachineView();
	private final Machine machine = new Machine();
	private final MachineValidator machineValidator = new MachineValidator(machine);

	public void settingMachineChanges() {
		while (true) {
			String changes = view.inputInitialCoins();
			if (validator.isValidMoney(changes)) {
				machine.setCoins(Integer.parseInt(changes));
				break;
			}
		}
		view.printInitialCoins(machine.getCoinList());
	}

	public void settingMerchandise() {
		while (true) {
			String merchandiseList = view.inputMerchandise();
			if (validator.isValidMerchandise(merchandiseList)) {
				machine.setMerchandise(Parser.parseToItemStringList(merchandiseList));
				break;
			}
		}
	}

	public void putMoneyIntoMachine() {
		while (true) {
			String payment = view.inputPayment();
			if (validator.isValidMoney(payment)) {
				machine.setPayment(payment);
				break;
			}
		}
	}

	public void chooseMerchandise() {
		view.printCurrentChanges(machine.getCurrentBalance());
		while (true) {
			String item = view.inputMerchandiseToBuy();
			if (machineValidator.isValidSelectedItem(item)) {
				machine.buyItem(item);
				break;
			}
		}
	}

	public void chooseUntilReturnBalance() {
		while (machine.checkAbleToBuyItem()) {
			chooseMerchandise();
		}
		view.printCurrentChanges(machine.getCurrentBalance());
		view.printChangeCoinsCount(machine.getReturnChange());
	}

}
