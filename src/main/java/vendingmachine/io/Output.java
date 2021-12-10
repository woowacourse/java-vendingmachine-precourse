package vendingmachine.io;

import static vendingmachine.domain.Machine.*;
import static vendingmachine.domain.MachineWallet.*;
import static vendingmachine.domain.RandomBox.*;
import static vendingmachine.domain.product.Products.*;
import static vendingmachine.utils.Printer.*;

import vendingmachine.service.MachineService;
import vendingmachine.service.MachineWalletService;
import vendingmachine.utils.Printer;

public class Output {
	private final Printer printer;
	private final MachineWalletService machineWalletService;
	private final MachineService machineService;

	public Output(Printer printer, MachineWalletService machineWalletService, MachineService machineService) {
		this.printer = printer;
		this.machineWalletService = machineWalletService;
		this.machineService = machineService;
	}

	public void outputMachineNumOfCoins() {
		printer.printMachineNumOfCoinsNotice(machineWalletService.getMachineClipStatus());
	}

	public boolean outputCustomerAmount() {
		printer.printCustomerCurrentAmount(machineService.getAmount());
		return machineService.checkMachineIsWorking();
	}

	public void outputCustomerChange() {
		printer.printCustomerChange(machineWalletService.getChanges());
	}

}
