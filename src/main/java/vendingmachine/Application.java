package vendingmachine;

import vendingmachine.controller.CatalogController;
import vendingmachine.controller.VendingMachineAccountController;
import vendingmachine.domain.VendingMachineAccount;
import vendingmachine.repository.CatalogRepository;

public class Application {

	private static VendingMachineAccount vendingMachineAccount;
	private static CatalogRepository catalogRepository = new CatalogRepository();

	public static void main(String[] args) {
		// TODO: 프로그램 구현
		vendingMachineAccount = new VendingMachineAccount(VendingMachineAccountController.getAccountInput());
		vendingMachineAccount.printCoinCount();
		CatalogController.getCatalogListInput();
		catalogRepository.printAll();
	}
}
