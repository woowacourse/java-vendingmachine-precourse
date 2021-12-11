package vendingmachine.io;

import vendingmachine.service.MachineService;
import vendingmachine.service.MachineWalletService;
import vendingmachine.config.utils.Printer;

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
		printer.printMachineNumOfCoinsNotice(machineWalletService.getMachineWalletStatus());
	}

	public boolean outputCustomerAmount() {
		printer.printCustomerCurrentAmount(machineService.getCustomerAmount());
		return machineService.checkIsMachineAvailable();
	}

	public void outputCustomerChange() {
		printer.printCustomerChange(machineWalletService.getChanges());
	}

}
