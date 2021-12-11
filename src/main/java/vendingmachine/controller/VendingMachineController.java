package vendingmachine.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import vendingmachine.domain.Coin;
import vendingmachine.domain.Item;
import vendingmachine.service.CoinService;
import vendingmachine.service.ItemService;
import vendingmachine.service.MoneyService;
import vendingmachine.view.InputView;

public class VendingMachineController {

	private InputView inputView;
	private CoinService coinService;
	private ItemService itemService;
	private MoneyService moneyService;
	private List<Coin> coins;

	public VendingMachineController() {
		inputView = new InputView();
		coinService = new CoinService();
		itemService = new ItemService();
		moneyService = new MoneyService();
	}

	public void machineInit() {
		int savedMoney = moneyService.getSavedMoney();
		coins = Coin.init();
		HashMap<Coin, Integer> savedCoins = coinService.getRandomCoins(coins, savedMoney);
		List<Item> items = itemService.getItems();
		int customerMoney = moneyService.getCustomerMoney();
	}
}
