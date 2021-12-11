package vendingmachine.controller;

import static vendingmachine.view.InputView.*;

import java.util.Arrays;
import java.util.List;

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

	public void setProductList() {
		String input = inputProductList();
		List<String> inputList = Arrays.asList(input.split(";", -1));
	}

	public void setMoney() {
		String input = inputMoney();
		machineService.setMoney(input);
	}

	public void purchase() {
		String input = inputProductName();
		machineService.purchaseProduct(input);
	}
}
