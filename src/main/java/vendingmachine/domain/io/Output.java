package vendingmachine.domain.io;

import static vendingmachine.domain.Machine.*;
import static vendingmachine.domain.MachineClip.*;
import static vendingmachine.utils.Printer.*;

import vendingmachine.domain.Machine;
import vendingmachine.domain.MachineClip;
import vendingmachine.utils.Printer;

public enum Output {
	OUTPUT;

	private Printer printer;
	private Machine machine;
	private MachineClip machineClip;

	Output() {
		printer = PRINTER;
		machine = MACHINE;
		machineClip = MACHINE_CLIP;
	}

	public void outputMachineNumOfCoins() {
		printer.printMachineNumOfCoins();
	}

	public void outputCustomerAmount() {
		printer.printCustomerCurrentAmount();
	}

	public void outputCustomerChange() {
		printer.printCustomerChange();
		machineClip.getChange(machine.getAmount());
	}

}
