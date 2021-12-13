package vendingmachine.controller;

import vendingmachine.domain.Catalog;
import vendingmachine.domain.UserAccount;
import vendingmachine.repository.CatalogRepository;
import vendingmachine.service.PurchaseService;
import vendingmachine.view.PurchaseView;
import vendingmachine.view.UserAccountView;

public class PurchaseController {
	public static void purchaseCatalogs() {

		while (!isEnd()) {
			UserAccountView.printUserAccount();
			Catalog catalogToPurchase = getCatalogInput();
			UserAccount.purchase(catalogToPurchase);
			CatalogRepository.reduceAmount(catalogToPurchase);
		}
		UserAccountView.printUserAccount();
	}

	private static Catalog getCatalogInput() {
		PurchaseView.printGuide();
		Catalog catalog = null;
		while (catalog == null) {
			catalog = PurchaseService.getCatalogInput();
		}
		return catalog;
	}

	private static boolean isEnd() {
		return PurchaseService.checkEndCondition();
	}
}
