package vendingmachine.controller;

import vendingmachine.domain.Catalog;
import vendingmachine.domain.UserAccount;
import vendingmachine.repository.CatalogRepository;
import vendingmachine.service.PurchaseService;
import vendingmachine.view.PurchaseView;
import vendingmachine.view.UserAccountView;

public class PurchaseController {
	public static void doMainLoop() {

		while (!isEnd()) {
			// 투입 금액 출력
			UserAccountView.printUserAccount();
			// 구매할 상품명 입력
			Catalog catalogToPurchase = getCatalogInput();
			//투입 금액 차감
			UserAccount.purchase(catalogToPurchase);
			CatalogRepository.reduceAmount(catalogToPurchase);
		}
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
