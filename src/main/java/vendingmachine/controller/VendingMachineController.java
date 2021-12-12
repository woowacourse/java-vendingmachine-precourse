package vendingmachine.controller;

import vendingmachine.domain.Machine;
import vendingmachine.validation.InputValidator;
import vendingmachine.view.MachineView;

public class VendingMachineController {
	private final InputValidator validator = new InputValidator();
	private final MachineView view = new MachineView();
	private final Machine machine = new Machine();

	public void settingMachineChanges() {
		while (true) {
			String changes = view.inputChanges();
			if (validator.isValidChanges(changes)) {
				machine.setCoins(Integer.parseInt(changes));
				break;
			}
		}
		view.printChanges(machine.getSortedCoinCount());
	}

	public void settingMerchandise() {
		while (true) {
			String merchandiseList = view.inputMerchandise();
			if (validator.isValidMerchandise(merchandiseList)) {
				machine.setMerchandise(merchandiseList);
				break;
			}
		}
	}

}
