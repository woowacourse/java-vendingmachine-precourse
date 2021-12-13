package vendingmachine.controller;

import vendingmachine.domain.Money;
import vendingmachine.service.ChangeSafeService;
import vendingmachine.service.PurchaseService;

public class ChangeBackController {

	private final PurchaseService purchaseService;
	private final ChangeSafeService changeSafeService;

	public ChangeBackController(PurchaseService purchaseService, ChangeSafeService changeSafeService) {
		this.purchaseService = purchaseService;
		this.changeSafeService = changeSafeService;
	}

	public String retrieveChangeSafe() {
		Money money = purchaseService.retrieveMoney();
		return changeSafeService.giveChange(money);
	}
}
