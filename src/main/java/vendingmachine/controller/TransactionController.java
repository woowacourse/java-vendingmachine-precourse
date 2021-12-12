package vendingmachine.controller;

import java.util.ArrayList;

import vendingmachine.models.Coin;
import vendingmachine.models.Item;
import vendingmachine.models.ItemList;
import vendingmachine.models.User;
import vendingmachine.utils.Messages;
import vendingmachine.view.CoinInputView;
import vendingmachine.view.ItemInformationInputView;
import vendingmachine.view.OutputView;
import vendingmachine.view.UserMoneyInputView;

public class TransactionController {
	public static void run() {
		ArrayList<Item> coin = Coin.getInitialCoins(Integer.valueOf(new CoinInputView().getInput()));
		OutputView.viewCoins(coin,
			Messages.OUTPUT_VIEW_INITIAL_COIN_MSG.getValue() + Messages.COMMON_LINE_BREAK_MSG.getValue());
		ItemList itemList = new ItemList(
			new ItemInformationInputView().parse(new ItemInformationInputView().getInput()));
		User user = new User(Integer.valueOf(new UserMoneyInputView().getInput()));
		while (!itemList.isAllSoldOut() && !user.isBankrupt(itemList.getMinPrice())) {
			OutputView.viewNowPayMoney(user.getPayMoney());
			UserAndItemController.buy(user, itemList);
		}
		ArrayList<Item> returnedCoin = Coin.getReturnedCoin(coin, user.getPayMoney());
		OutputView.viewCoins(returnedCoin,
			Messages.OUTPUT_VIEW_RETURN_MONEY_MSG.getValue() + Messages.COMMON_LINE_BREAK_MSG.getValue());
	}
}
