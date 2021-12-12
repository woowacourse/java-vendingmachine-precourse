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
import vendingmachine.service.PurchaseService;
import vendingmachine.view.InputView;

public class VendingMachineController {

	private static List<Coin> coins = new ArrayList<>();
	private static int customerMoney;
	private InputView inputView;
	private CoinService coinService;
	private ItemService itemService;
	private MoneyService moneyService;
	private PurchaseService purchaseService;
	private List<Item> items;

	public VendingMachineController() {
		inputView = new InputView();
		coinService = new CoinService();
		itemService = new ItemService();
		moneyService = new MoneyService();
		purchaseService = new PurchaseService();
	}

	public void machineInit() {
		int savedMoney = moneyService.getSavedMoney();
		coinService.init(coins);
		coinService.pickRandomCoins(coins, savedMoney);
		for (Coin coin : coins) {
			System.out.println(coin.getAmount() + " : " + coin.getNumberOfCoin());
		}
		items = itemService.getItems();
	}

	public void customerInit() {
		customerMoney = moneyService.getCustomerMoney();
	}

	public void purchase() {
		do {
			customerMoney = purchaseService.purchaseItem(items, customerMoney);
			moneyService.isEnoughMoneyForMinPriceItem(items, customerMoney);
		} while (isContinuePurchase());
		coinService.getRemainingCoins(coins, customerMoney);
	}

	private boolean isContinuePurchase() {
		if (moneyService.isEnoughMoneyForMinPriceItem(items, customerMoney) && itemService.isEnoughQuantityForItems(
			items)) {
			return true;
		}
		return false;
	}
}
