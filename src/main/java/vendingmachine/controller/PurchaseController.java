package vendingmachine.controller;

import vendingmachine.service.ChangeSafeService;
import vendingmachine.service.PurchaseService;

public class PurchaseController {

	private final PurchaseService purchaseService;
	private final ChangeSafeService changeSafeService;

	public PurchaseController(PurchaseService purchaseService, ChangeSafeService changeSafeService) {
		this.purchaseService = purchaseService;
		this.changeSafeService = changeSafeService;
	}

	public String retrieveDeposit() {
		return purchaseService.retrieveMoneyStatus();
	}

	public boolean isAvailable() {
		return purchaseService.isAvailable();
	}

	public void purchase(String input) {
		purchaseService.purchase(input);
	}

}
