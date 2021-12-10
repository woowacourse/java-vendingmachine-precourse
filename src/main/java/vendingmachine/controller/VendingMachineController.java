package vendingmachine.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import vendingmachine.domain.Coin;
import vendingmachine.domain.Item;
import vendingmachine.service.CoinService;
import vendingmachine.service.ItemService;
import vendingmachine.view.InputView;

public class VendingMachineController {

	private InputView inputView;
	private CoinService coinService;
	private ItemService itemService;
	private List<Coin> coins;

	public VendingMachineController() {
		inputView = new InputView();
		coinService = new CoinService();
		itemService = new ItemService();
	}

	public void machineInit() {
		int savedMoney = inputView.getSavedMoney();
		coins = Coin.init();
		HashMap<Coin, Integer> savedCoins = coinService.getRandomCoins(coins, savedMoney);
		String itemString = inputView.getItemInput();
		List<Item> items = itemService.getItems(itemString);
	}
}
