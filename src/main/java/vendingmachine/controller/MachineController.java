package vendingmachine.controller;

import static vendingmachine.view.InputView.*;
import static vendingmachine.view.OutputView.*;

import vendingmachine.repository.DepositRepository;
import vendingmachine.repository.ProductRepository;
import vendingmachine.service.MachineService;

public class MachineController {

	private final MachineService machineService;

	public MachineController() {
		this.machineService = new MachineService();
	}

	public void setDeposit() {
		try {
			String input = inputDeposit();
			machineService.setDepositsRandomized(input);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			setDeposit();
		}
	}

	public void setProductList() {
		try {
			String input = inputProductList();
			machineService.setProducts(input);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			setProductList();
		}
	}

	public void setMoney() {
		try {
			String input = inputMoney();
			machineService.addMoney(input);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			setMoney();
		}
	}

	public void purchase() {
		try {
			String input = inputProductName();
			machineService.purchaseProduct(input);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			purchase();
		}
	}

	public void operate() {
		setDeposit();
		printDeposits(machineService.getDeposits());
		setProductList();
		setMoney();
		printMoney(machineService.getMoney());
		while (machineService.getAffordableList().size() > 0) {
			purchase();
			printMoney(machineService.getMoney());
		}
		printChanges(machineService.spitChanges());
	}
}
