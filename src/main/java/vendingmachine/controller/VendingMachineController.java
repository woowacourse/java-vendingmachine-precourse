package vendingmachine.controller;

import vendingmachine.domain.Changes;
import vendingmachine.domain.Money;
import vendingmachine.domain.Products;
import vendingmachine.domain.VendingMachine;
import vendingmachine.service.VendingMachineService;
import vendingmachine.view.ExceptionView;
import vendingmachine.view.OutputView;

import static vendingmachine.controller.RequestController.*;

public class VendingMachineController {
	private VendingMachine vendingMachine;

	public VendingMachineController(VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
	}

	public void run() {
		while (vendingMachine.isBuy()) {
			OutputView.insertMoneyUI(vendingMachine.getRemainingMoney());
			String productName = RequestController.requestProductName();
			VendingMachineService.buyForName(vendingMachine, productName);
		}
	}

	public void insertMoney() {
		try {
			Money insertMoney = RequestController.requestInsertMoney();
			VendingMachineService.insertMoney(vendingMachine, insertMoney);
		} catch (IllegalArgumentException e) {
			ExceptionView.errorUI(e.getMessage());
			insertMoney();
		}
	}

	public void returnChanges() {
		OutputView.insertMoneyUI(vendingMachine.getRemainingMoney());
		OutputView.returnChangesUI(VendingMachineService.returnChanges(vendingMachine));
	}

	public static VendingMachine createVendingMachine() {
		Changes changes = requestChanges();
		Products products = requestProducts();
		return new VendingMachine(changes, products);
	}
}
