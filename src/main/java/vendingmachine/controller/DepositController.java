package vendingmachine.controller;

import vendingmachine.domain.Money;
import vendingmachine.service.DepositService;
import vendingmachine.service.MoneyService;

public class DepositController {

	private final MoneyService moneyService;
	private final DepositService depositService;

	public DepositController(MoneyService moneyService, DepositService depositService) {
		this.moneyService = moneyService;
		this.depositService = depositService;
	}

	public String depositMoney(String input) {
		Money money = moneyService.generateMoney(input);
		return depositService.deposit(money).toString();
	}
}
