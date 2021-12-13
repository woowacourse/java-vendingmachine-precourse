package vendingmachine.controller;

import java.util.Map;

import vendingmachine.model.BeverageShop;
import vendingmachine.model.Beverages;
import vendingmachine.model.Coin;
import vendingmachine.model.CoinBucket;
import vendingmachine.view.InputView;
import vendingmachine.model.Money;
import vendingmachine.view.OutputView;
import vendingmachine.model.RandomCoinGenerator;

public class VendingMachine {
	private CoinBucket coinBucket;
	private Beverages beverages;
	private Money insertedMoney;

	public void powerOn() {
		init();
		start();
	}

	private void start() {
		while (canSell()) {
			sell();
		}
		printChanges();
	}

	private void printChanges() {
		OutputView.printInsertedMoney(insertedMoney);
		OutputView.printChanges(getChanges());
	}

	private Map<Coin, Integer> getChanges() {
		return coinBucket.getChanges(insertedMoney);
	}

	private boolean canSell() {
		return beverages.canSellMore(insertedMoney);
	}

	private void sell() {
		try {
			sellBeverage();
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			sell();
		}
	}

	private void sellBeverage() {
		OutputView.printInsertedMoney(insertedMoney);
		String beverageName = InputView.readBeverageName();
		beverages.sell(beverageName, insertedMoney);
	}

	private void init() {
		coinBucket = initCoinBucket();
		OutputView.printCoinBucket(coinBucket.getCoins());
		beverages = initBeverages();
		insertedMoney = insertMoney();
	}

	private CoinBucket initCoinBucket() {
		try {
			return getCoinBucketFromInput();
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			return initCoinBucket();
		}
	}

	private CoinBucket getCoinBucketFromInput() {
		int assetsInput = InputView.readInitialMachineAssets();
		Money machineAssets = Money.from(assetsInput);
		return CoinBucket.of(machineAssets, new RandomCoinGenerator());
	}

	private Beverages initBeverages() {
		try {
			return getBeveragesFromInput();
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			return initBeverages();
		}
	}

	private Beverages getBeveragesFromInput() {
		String beverageInfos = InputView.readBeverageInfos();
		return BeverageShop.getBeverages(beverageInfos);
	}

	private Money insertMoney() {
		try {
			int money = InputView.readInsertMoney();
			return Money.from(money);
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			return insertMoney();
		}
	}
}
