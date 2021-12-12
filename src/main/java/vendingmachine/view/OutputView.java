package vendingmachine.view;

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
}
