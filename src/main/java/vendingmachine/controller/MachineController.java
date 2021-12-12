package vendingmachine.controller;

import static vendingmachine.view.InputView.*;
import static vendingmachine.view.OutputView.*;

import java.util.Arrays;
import java.util.List;

import vendingmachine.domain.Machine;
import vendingmachine.repository.DepositRepository;
import vendingmachine.repository.ProductRepository;
import vendingmachine.service.MachineService;
import vendingmachine.validator.ProductListValidator;

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
		try {
			String input = inputDeposit();
			machineService.setDepositsRandomized(input);
		}
		catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			setDeposit();
		}
	}

	public void setProductList() {
		try {
			String input = inputProductList();
			machineService.setProducts(input);
		}
		catch (IllegalArgumentException e){
			System.out.println(e.getMessage());
			setProductList();
		}
	}

	public void setMoney() {
		try {
			String input = inputMoney();
			machineService.setMoney(input);
		}
		catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			setMoney();
		}
	}

	public void purchase() {
		try {
			String input = inputProductName();
			machineService.purchaseProduct(input);
		}
		catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			purchase();
		}
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
