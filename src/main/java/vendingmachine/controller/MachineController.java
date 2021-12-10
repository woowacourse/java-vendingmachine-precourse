package vendingmachine.controller;

import java.util.ArrayList;
import java.util.Map;

import vendingmachine.domain.Beverage;
import vendingmachine.domain.Beverages;
import vendingmachine.domain.Change;
import vendingmachine.domain.Coin;
import vendingmachine.domain.Money;
import vendingmachine.validator.InputValidator;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class MachineController {
	private static final int itemIndex = 0;
	private static final int priceIndex = 1;
	private static final int stockIndex = 2;
	private static final String PRICE = "금액";
	private static final String STOCK = "수량";

	private Beverages beverages = new Beverages();
	private Map<Coin, Integer> changes;
	private Money inputMoney = new Money();

	public void run() {
		setting();
		progress();
	}

	private void setting() {
		Change change = new Change(InputView.getHavingMoney());
		changes = change.generateChanges();
		OutputView.printHavingMachineCoin();
		ArrayList<String> itemPriceStock = InputView.getItemPriceStock();
		beverages = splitItem(itemPriceStock);
		inputMoney = InputView.getUserInputMoney();
	}

	private void progress() {
		while (!inputMoney.isSame(0)) {
			OutputView.printInputMoney(inputMoney);
			String itemName = InputView.getItemName();
			Beverage beverage = beverages.findByName(itemName);
			calculate(beverage);
		}
	}

	private void calculate(Beverage beverage) {
		//구매한 음료에 따른 계산
		inputMoney.spend(beverage.getPrice());


	}

	private Beverages splitItem(ArrayList<String> itemPriceStock) {

		for (String s : itemPriceStock) {
			String[] itemInfo = s.split(",");
			String name = itemInfo[itemIndex];
			int price = InputValidator.checkNumberForm(itemInfo[priceIndex], PRICE);
			int stock = InputValidator.checkNumberForm(itemInfo[stockIndex], STOCK);
			beverages.add(new Beverage(name, price), stock);

		}
		return beverages;
	}

}
