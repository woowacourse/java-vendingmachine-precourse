package vendingmachine.controller;

import vendingmachine.domain.Money;
import vendingmachine.domain.Price;
import vendingmachine.service.ChangeSafeService;
import vendingmachine.service.DepositService;
import vendingmachine.service.PurchaseService;

public class PurchaseController {

	private final PurchaseService purchaseService;
	private final DepositService depositService;

	public PurchaseController(PurchaseService purchaseService, DepositService depositService) {
		this.purchaseService = purchaseService;
		this.depositService = depositService;
	}

	public String retrieveDeposit() {
		return depositService.retrieve().toString();
	}

	public boolean isAvailable() {
		Money money = depositService.retrieve();
		return purchaseService.isAvailable(money);
	}

	public String purchase(String input) {
		Price price = purchaseService.purchase(input);
		return depositService.decrease(price).toString();
	}

}
