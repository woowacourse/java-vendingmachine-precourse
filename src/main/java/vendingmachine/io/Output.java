package vendingmachine.io;

import static vendingmachine.domain.Machine.*;
import static vendingmachine.domain.MachineClip.*;
import static vendingmachine.domain.RandomBox.*;
import static vendingmachine.domain.product.ProductFactory.*;
import static vendingmachine.domain.product.Products.*;
import static vendingmachine.utils.Printer.*;

import vendingmachine.service.MachineClipService;
import vendingmachine.service.VendingMachineService;
import vendingmachine.utils.Printer;

public enum Output {
	OUTPUT(PRINTER,
		new MachineClipService(MACHINE_CLIP, RANDOM_COIN_BOX, MACHINE),
		new VendingMachineService(PRODUCTS, MACHINE, PRODUCT_FACTORY));

	private Printer printer;
	private final MachineClipService machineClipService;
	private final VendingMachineService vendingMachineService;

	Output(Printer printer, MachineClipService machineClipService, VendingMachineService vendingMachineService) {
		this.printer = printer;
		this.machineClipService = machineClipService;
		this.vendingMachineService = vendingMachineService;
	}

	public void outputMachineNumOfCoins() {
		printer.printMachineNumOfCoinsNotice(machineClipService
			.sendMachineClipStat());
	}

	public boolean outputCustomerAmount() {
		printer.printCustomerCurrentAmount(vendingMachineService.sendMachineAmount());
		return vendingMachineService.checkMachineIsWorking();
	}

	public void outputCustomerChange() {
		printer.printCustomerChange(machineClipService.sendChanges());
	}

}
