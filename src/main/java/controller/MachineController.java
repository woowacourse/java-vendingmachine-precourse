package controller;

import view.Display;

public class MachineController {

	private MachineController() {
	}

	public static void turnOnMachine() {
		Display.askInputVendingMachineChange();
	}


}
