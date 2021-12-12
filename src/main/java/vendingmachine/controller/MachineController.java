package vendingmachine.controller;

import static vendingmachine.view.InputView.*;
import static vendingmachine.view.OutputView.*;

import java.util.Arrays;
import java.util.List;

import vendingmachine.domain.Machine;
import vendingmachine.repository.DepositRepository;
import vendingmachine.repository.ProductRepository;
import vendingmachine.service.MachineService;

public class MachineController {

	private final MachineService machineService;
	private final DepositRepository depositRepository;
	private final ProductRepository productRepository;
	private final Machine machine;

	public MachineController() {
		this.depositRepository = new DepositRepository();
		this.productRepository = new ProductRepository();
		this.machine = new Machine();
		this.machineService = new MachineService(depositRepository, productRepository, machine);
	}

	public void setDeposit() {
		String input = inputDeposit();
		int deposit = Integer.parseInt(input);
		machineService.setDepositsRandomized(deposit);
	}

	public void setProductList() {
		String input = inputProductList();
		List<String> inputList = Arrays.asList(input.split(";", -1));
		machineService.setProducts(inputList);
	}

	public void setMoney() {
		String input = inputMoney();
		machineService.setMoney(input);
	}

	public void purchase() {
		String input = inputProductName();
		machineService.purchaseProduct(input);
	}

	public void operate() {
		setDeposit();
		printDeposits(depositRepository);
		setProductList();
		setMoney();
		printMoney(machine);
		while (machineService.getAffordableList().size() > 0){
			purchase();
			printMoney(machine);
		}
		printChanges(machineService.spitChanges());
	}
}
