package vendingmachine.controller;

import vendingmachine.domain.Money;
import vendingmachine.service.ChangeSafeService;
import vendingmachine.service.MoneyService;

public class ChangeSafeController {

	private final MoneyService moneyService;
	private final ChangeSafeService changeSafeService;

	public ChangeSafeController(MoneyService moneyService, ChangeSafeService changeSafeService) {
		this.moneyService = moneyService;
		this.changeSafeService = changeSafeService;
	}

	public String generateChangeSafe(String input) {
		Money money = moneyService.generateMoney(input);
		return changeSafeService.generateChangeSafe(money).toString();
	}
}
