package vendingmachine.io;

import static vendingmachine.domain.Machine.*;
import static vendingmachine.domain.MachineClip.*;
import static vendingmachine.domain.product.Products.*;
import static vendingmachine.utils.Printer.*;

import vendingmachine.domain.Machine;
import vendingmachine.domain.MachineClip;
import vendingmachine.domain.product.Products;
import vendingmachine.utils.Printer;

public enum Output {
	OUTPUT(PRINTER, MACHINE, PRODUCTS, MACHINE_CLIP);

	private Printer printer;
	private Machine machine;
	private Products products;
	private MachineClip machineClip;

	Output(Printer printer, Machine machine, Products products, MachineClip machineClip) {
		this.printer = printer;
		this.machine = machine;
		this.products = products;
		this.machineClip = machineClip;
	}

	public void outputMachineNumOfCoins() {
		printer.printMachineNumOfCoinsNotice(machineClip);
	}

	public boolean outputCustomerAmount(int min) {
		printer.printCustomerCurrentAmount(machine.getAmount());

		if(machine.isAmountLessThanProductMinPrice(min) || !products.isProductExisted()) {
			return true;
		}
		return false;
	}

	public void outputCustomerChange() {
		printer.printCustomerChange(machineClip.getAmountToChanges(machine.getAmount()));

	}

}
