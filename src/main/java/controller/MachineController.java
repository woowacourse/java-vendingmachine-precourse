package controller;

import view.InputDisplay;

public class MachineController {

	private MachineController() {
	}

	public static void turnOnMachine() {
		InputDisplay.askInputVendingMachineChange();
		InputController.inputVendingMachineChange();
	}

}
