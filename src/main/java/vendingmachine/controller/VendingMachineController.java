package vendingmachine.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import vendingmachine.domain.Coin;
import vendingmachine.domain.Item;
import vendingmachine.domain.service.CoinService;
import vendingmachine.domain.service.ItemService;
import vendingmachine.domain.service.MoneyService;
import vendingmachine.view.InputFirstMoneyView;
import vendingmachine.view.InputItemInfoView;
import vendingmachine.view.InputItemNameView;
import vendingmachine.view.InputMoneyView;
import vendingmachine.view.ReturnChangesView;
import vendingmachine.view.ShowFirstMoneyView;
import vendingmachine.view.View;

public class VendingMachineController {
	private final Map<ViewMappingKey, View> viewMapper = new HashMap<>();
	private final CoinService coinService = new CoinService();
	private final ItemService itemService = new ItemService();
	private final MoneyService moneyService = new MoneyService();

	public VendingMachineController() {
		viewMapper.put(ViewMappingKey.INPUT_FIRST_MONEY, new InputFirstMoneyView());
		viewMapper.put(ViewMappingKey.SHOW_FIRST_MONEY, new ShowFirstMoneyView());
		viewMapper.put(ViewMappingKey.INPUT_ITEM_INFO, new InputItemInfoView());
		viewMapper.put(ViewMappingKey.INPUT_MONEY, new InputMoneyView());
		viewMapper.put(ViewMappingKey.INPUT_ITEM_NAME, new InputItemNameView());
		viewMapper.put(ViewMappingKey.RETURN_CHANGES, new ReturnChangesView());
	}

	public void view(ViewMappingKey key) {
		viewMapper.get(key).printViewMessage();
		viewMapper.get(key).flow();
	}

	public void createFirstCoins(int firstMoney) {
		coinService.createFirstCoins(firstMoney);
	}

	public Map<Coin, Integer> getCoins() {
		return coinService.getCoins();
	}

	public void addItems(List<Item> items) {
		itemService.addItems(items);
	}

	public void inputMoney(int money) {
		moneyService.inputMoney(money);
	}

	public int getMoney() {
		return moneyService.getMoney();
	}

	public List<String> getItemStringsByMoney(int money) {
		return itemService.getItemStringsByMoney(money);
	}

	public Item searchItem(String itemName, int money) {
		return itemService.searchItem(itemName, money);
	}

	public void purchase(Item item) {
		itemService.deductItemAmount(item.getName());
		moneyService.useMoney(item.getPrice());
	}

	public boolean canPurchaseByMoney(int money) {
		return itemService.canPurchaseByMoney(money);
	}

	public Map<Coin, Integer> getChangesToBeReturned(int money) {
		Map<Coin, Integer> changes = coinService.getChangesToBeReturned(money);
		deductChanges(changes);
		return changes;
	}

	private void deductChanges(Map<Coin, Integer> changes) {
		int totalChanges = 0;

		for (Coin coin : changes.keySet())
			totalChanges += coin.getAmount() * changes.get(coin);

		moneyService.useMoney(totalChanges);
		coinService.deductCoins(changes);
	}
}
