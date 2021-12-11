package vendingmachine.controller;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.model.CoinModel;
import vendingmachine.model.ItemModel;
import vendingmachine.model.UserModel;
import vendingmachine.validator.InputValidator;
import vendingmachine.validator.QueryValidator;
import vendingmachine.view.VendingMachineOutputView;

public class VendingMachineController {
	private final static VendingMachineController vendingMachineController = new VendingMachineController();
	private final VendingMachineOutputView vendingMachineOutputView;
	private final InputValidator inputValidator;
	private QueryValidator queryValidator;
	private final CoinModel coinModel;
	private final ItemModel itemModel;
	private final UserModel userModel;

	private VendingMachineController() {
		vendingMachineOutputView = VendingMachineOutputView.getVendingMachineOutputView();
		inputValidator = InputValidator.getInputValidator();
		coinModel = CoinModel.getCoinModel();
		itemModel = ItemModel.getItemModel();
		userModel = UserModel.getUserModel();
		queryValidator = QueryValidator.getQueryValidator();
	}

	public static VendingMachineController getVendingMachineController() {
		return vendingMachineController;
	}

	public void run() {
		coinModel.generateCoins(getInitialAmount());
		vendingMachineOutputView.printVendingMachineInitialCoinsOutputMessage();
		vendingMachineOutputView.printVendingMachineCoins(coinModel.getNumberOfCoins());
		itemModel.createItems(getInitialItems());
		userModel.putMoney(getInputAmount());
		buyItems();
		giveChange();
	}

	private void giveChange() {
		vendingMachineOutputView.printRemainingAmount(userModel.getRemainingMoney());
		vendingMachineOutputView.printChangeOutputMessage();
		vendingMachineOutputView.printVendingMachineCoins(coinModel.getMinimumNumberCoins(userModel.getRemainingMoney()));

	}

	private void buyItems() {
		while (canBuyItem()) {
			vendingMachineOutputView.printRemainingAmount(userModel.getRemainingMoney());
			vendingMachineOutputView.printPurchasingInputMessage();
			String item = Console.readLine();
			if (!queryValidator.checkBuyItemErrorExceptions(item, userModel.getRemainingMoney())) {
				continue;
			}
			userModel.reduceMoney(itemModel.getPriceByName(item));
		}
	}

	private boolean canBuyItem() {
		return itemModel.getMinimumPrice() <= userModel.getRemainingMoney() && itemModel.hasExtraQuantity();
	}

	private String getInitialAmount() {
		String amount;
		do {
			vendingMachineOutputView.printAmountInputMessage();
			amount = Console.readLine();
		} while (!inputValidator.checkInitialAmountInputExceptions(amount));
		return amount;
	}

	private String getInitialItems() {
		String items;
		do {
			vendingMachineOutputView.printInitialItemsInputMessage();
			items = Console.readLine();
		} while (!inputValidator.checkInitialItemsInputExceptions(items));
		return items;
	}

	private String getInputAmount() {
		String inputAmount;
		do {
			vendingMachineOutputView.printUserInputAmountInputMessage();
			inputAmount = Console.readLine();
		} while (!inputValidator.checkInputAmountInputExceptions(inputAmount));
		return inputAmount;
	}
}
