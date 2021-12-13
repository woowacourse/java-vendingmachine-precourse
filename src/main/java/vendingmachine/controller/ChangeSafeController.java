package vendingmachine.controller;

import java.util.Map;

import vendingmachine.domain.Coin;
import vendingmachine.domain.Money;
import vendingmachine.domain.Quantity;
import vendingmachine.service.ChangeSafeService;
import vendingmachine.service.CoinService;
import vendingmachine.service.MoneyService;

public class ChangeSafeController {

	private final MoneyService moneyService;
	private final CoinService coinService;
	private final ChangeSafeService changeSafeService;

	public ChangeSafeController(MoneyService moneyService,
		CoinService coinService,
		ChangeSafeService changeSafeService) {
		this.moneyService = moneyService;
		this.coinService = coinService;
		this.changeSafeService = changeSafeService;
	}

	public String generateChangeSafe(String input) {
		Map<Coin, Quantity> coinMap = generate(input);
		return changeSafeService.persist(coinMap);
	}

	private Map<Coin, Quantity> generate(String input) {
		Money money = moneyService.generateMoney(input);
		return coinService.generateCoinMap(money);
	}
}
