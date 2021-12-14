package vendingmachine.controller;

import vendingmachine.domain.Money;
import vendingmachine.service.ChangeSafeService;
import vendingmachine.service.DepositService;
import vendingmachine.service.PurchaseService;

public class ChangeBackController {

	private final DepositService depositService;
	private final ChangeSafeService changeSafeService;

	public ChangeBackController(DepositService depositService, ChangeSafeService changeSafeService) {
		this.depositService = depositService;
		this.changeSafeService = changeSafeService;
	}

	public String retrieveChangeSafe() {
		Money money = depositService.retrieve();
		return changeSafeService.giveChange(money).toString();
	}
}
