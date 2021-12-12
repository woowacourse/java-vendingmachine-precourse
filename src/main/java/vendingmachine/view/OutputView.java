package vendingmachine.view;

import java.util.ArrayList;

import vendingmachine.models.Item;
import vendingmachine.utils.Messages;

public class OutputView {

	public static void noticeCoinInput() {
		System.out.print(
			Messages.OUTPUT_VIEW_NOTICE_COIN_INPUT_MSG.getValue() + Messages.COMMON_LINE_BREAK_MSG.getValue());
	}

	public static void noticeItemInput() {
		System.out.print(
			Messages.OUTPUT_VIEW_NOTICE_ITEM_INPUT_MSG.getValue() + Messages.COMMON_LINE_BREAK_MSG.getValue());
	}

	public static void noticePayMoneyInput() {
		System.out.print(
			Messages.OUTPUT_VIEW_NOTICE_PAY_MONEY_INPUT_MSG.getValue() + Messages.COMMON_LINE_BREAK_MSG.getValue());
	}

	public static void noticeBuyItemInput() {
		System.out.print(
			Messages.OUTPUT_VIEW_NOTICE_BUY_ITEM_INPUT_MSG.getValue() + Messages.COMMON_LINE_BREAK_MSG.getValue());
	}

	public static void viewNowPayMoney(int pay) {
		System.out.print(
			Messages.OUTPUT_VIEW_NOW_MONEY_MSG.getValue() + pay + Messages.OUTPUT_VIEW_WON_MSG.getValue()
				+ Messages.COMMON_LINE_BREAK_MSG.getValue());
	}

	public static void viewCoins(ArrayList<Item> coinList, String message) {
		System.out.print(message);
		for (Item eachCoin : coinList) {
			System.out.print(
				eachCoin.getPrice() + Messages.OUTPUT_VIEW_WON_MSG.getValue()
					+ Messages.OUTPUT_VIEW_DASH_MSG.getValue() + eachCoin.getAmount()
					+ Messages.OUTPUT_VIEW_COIN_COUNT_MSG.getValue() + Messages.COMMON_LINE_BREAK_MSG.getValue());
		}
	}
}
