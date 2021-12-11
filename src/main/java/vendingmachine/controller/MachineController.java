package vendingmachine.controller;

import static vendingmachine.view.InputView.*;

import vendingmachine.repository.DepositRepository;
import vendingmachine.service.MachineService;

public class MachineController {

	private final MachineService machineService;
	private final DepositRepository depositRepository;

	public MachineController(MachineService machineService, DepositRepository depositRepository) {
		this.machineService = machineService;
		this.depositRepository = depositRepository;
	}

	public void setDeposit() {
		String input = inputDeposit();
		int deposit = Integer.parseInt(input);
		machineService.setDepositsRandomized(deposit);
	}
}
