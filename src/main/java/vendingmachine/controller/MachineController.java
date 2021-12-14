package vendingmachine.controller;

import static vendingmachine.view.InputView.*;
import static vendingmachine.view.OutputView.*;

import vendingmachine.service.DepositService;
import vendingmachine.service.MachineService;
import vendingmachine.service.ProductService;

public class MachineController {

	private final MachineService machineService;
	private final DepositService depositService;
	private final ProductService productService;

	public MachineController() {
		this.productService = new ProductService();
		this.depositService = new DepositService();
		this.machineService = new MachineService(depositService, productService);
	}

	public void setDeposit() {
		try {
			String input = inputDeposit();
			depositService.setDepositsRandomized(input);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			setDeposit();
		}
	}

	public void setProductList() {
		try {
			String input = inputProductList();
			productService.setProducts(input);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			setProductList();
		}
	}

	public void addMoney() {
		try {
			String input = inputMoney();
			machineService.addMoney(input);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			addMoney();
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
		printDeposits(depositService.getDeposits());
		setProductList();
		addMoney();
		printMoney(machineService.getMoney());
		while (productService.getAffordableList(machineService.getMoney()).size() > 0) {
			purchase();
			printMoney(machineService.getMoney());
		}
		printChanges(machineService.spitChanges());
	}
}
