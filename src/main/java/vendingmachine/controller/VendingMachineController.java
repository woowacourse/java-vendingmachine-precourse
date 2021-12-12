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
import vendingmachine.view.OutputView;

public class VendingMachineController {

	private static List<Coin> coins = new ArrayList<>();
	private static int customerMoney;
	private InputView inputView;
	private OutputView outputView;
	private CoinService coinService;
	private ItemService itemService;
	private MoneyService moneyService;
	private PurchaseService purchaseService;
	private List<Item> items;

	public VendingMachineController() {
		inputView = new InputView();
		outputView = new OutputView();
		coinService = new CoinService();
		itemService = new ItemService();
		moneyService = new MoneyService();
		purchaseService = new PurchaseService();
	}

	public void machineInit() {
		outputView.printInputSavedMoney();
		int savedMoney = moneyService.getSavedMoney();
		coinService.init(coins);
		coinService.pickRandomCoins(coins, savedMoney);
		outputView.printMachineSavedCoin(coins);
		outputView.printInputSavedItems();
		items = itemService.getItems();
	}

	public void customerInit() {
		outputView.printInputCustomerMoney();
		customerMoney = moneyService.getCustomerMoney();
	}

	public void purchase() {
		do {
			outputView.printCustomerMoney(customerMoney);
			outputView.printInputPurchaseItem();
			customerMoney = purchaseService.purchaseItem(items, customerMoney);
			moneyService.isEnoughMoneyForMinPriceItem(items, customerMoney);
		} while (isContinuePurchase());
		coinService.getRemainingCoins(coins, customerMoney);
		outputView.printCustomerMoney(customerMoney);
		outputView.printRemainingMessage();
		outputRemainingMoney();
	}

	private boolean isContinuePurchase() {
		if (moneyService.isEnoughMoneyForMinPriceItem(items, customerMoney) && itemService.isEnoughQuantityForItems(
			items)) {
			return true;
		}
		return false;
	}

	private void outputRemainingMoney() {
		coins.stream()
			.filter(coin -> coin.isNotZeroRemainingNumber() == true)
			.forEach(coin -> outputView.printRemainingCoin(coin));
	}
}
