package vendingmachine.view;

import java.util.Map;

import vendingmachine.constant.MessageConst;
import vendingmachine.domain.Changes;
import vendingmachine.domain.Coin;
import vendingmachine.domain.VendingMachine;

public class OutputView {
	public static void printInitMessage() {
		System.out.println(MessageConst.INIT_MESSAGE);
	}

	public static void printErrorMessage(String errorMessage) {
		System.out.println(errorMessage);
	}

	public static void printItemSettingMessage() {
		System.out.println(MessageConst.ITEM_SETTING_MESSAGE);
	}

	public static void printChanges(Changes changes) {
		Map<Coin, Integer> changesMap = changes.getChanges();
		System.out.println(MessageConst.MACHINE_HAVING_CHANGES);
		printChangeStatus(changesMap);
	}

	public static void printEnterInputAmount() {
		System.out.println(MessageConst.INPUT_AMOUNT_MESSAGE);
	}

	private static void printChangeStatus(Map<Coin, Integer> changesMap) {
		changesMap.forEach(OutputView::printCoinAndCoinNum);
	}

	private static void printCoinAndCoinNum(Coin coin, Integer coinNum) {
		System.out.println(coin + MessageConst.SEPARATOR + coinNum + MessageConst.UNIT);
	}

	public static void printInputAmount(int amount) {
		System.out.println(MessageConst.REMAIN_INPUT_MONEY_MESSAGE + amount + MessageConst.COIN_UNIT);
	}
}
