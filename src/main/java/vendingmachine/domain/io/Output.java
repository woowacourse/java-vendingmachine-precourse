package vendingmachine.domain.io;

import static vendingmachine.domain.Machine.*;
import static vendingmachine.domain.MachineClip.*;
import static vendingmachine.utils.Printer.*;

import java.util.Map;

import vendingmachine.domain.Machine;
import vendingmachine.domain.MachineClip;
import vendingmachine.utils.Printer;

public enum Output {
	OUTPUT(PRINTER, MACHINE, MACHINE_CLIP);

	private Printer printer;
	private Machine machine;
	private MachineClip machineClip;

	Output(Printer printer, Machine machine, MachineClip machineClip) {
		this.printer = printer;
		this.machine = machine;
		this.machineClip = machineClip;
	}

	public void outputMachineNumOfCoins() {
		printer.printMachineNumOfCoins();
	}

	public boolean outputCustomerAmount(int min) {
		printer.printCustomerCurrentAmount(machine.getAmount());

		if(MACHINE.isAmountLessThanProductMinPrice(min)) {
			return true;
		}
		return false;
	}

	public void outputCustomerChange() {
		printer.printCustomerChange(machineClip.getAmountToChanges(machine.getAmount()));

	}

}
