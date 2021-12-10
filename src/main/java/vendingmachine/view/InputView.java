package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.utils.Message;

public class InputView {
	private static final char CHAR_NUMERIC_MIN = '0';
	private static final char CHAR_NUMERIC_MAX = '9';
	private static final String ZERO_HOLDING_MONEY = "0";

	public static int holdingMoneyInput(){
		String stringHoldingMoney = "";
		int holdingMoney = 0;

		do{
			System.out.println(Message.ASK_HOLDING_MONEY);
			stringHoldingMoney = Console.readLine();
		} while(!isRightHoldingMoney(stringHoldingMoney));

		holdingMoney = Integer.parseInt(stringHoldingMoney);
		return holdingMoney;
	}

	private static boolean isRightHoldingMoney(String stringHoldingMoney){
		boolean isRightHoldingMoney = true;
		try {
			nonNumericHoldingMoneyError(stringHoldingMoney);
			zeroHoldingMoneyError(stringHoldingMoney);
		} catch (IllegalArgumentException e){
			System.out.println(e.getMessage());
			isRightHoldingMoney = false;
		}
		return isRightHoldingMoney;
	}



	public static void nonNumericHoldingMoneyError(String stringHoldingMoney) {
		for (int i = 0; i < stringHoldingMoney.length(); i++) {
			if (stringHoldingMoney.charAt(i) < CHAR_NUMERIC_MIN || CHAR_NUMERIC_MAX < stringHoldingMoney.charAt(
					i)) {
				throw new IllegalArgumentException(Message.NON_NUMERIC_HOLDING_MONEY_ERROR);
			}
		}
	}

	public static void zeroHoldingMoneyError(String stringGameCount) {
		if (stringGameCount.equals(ZERO_HOLDING_MONEY)) {
			throw new IllegalArgumentException(Message.ZERO_HOLDING_MONEY_ERROR);
		}
	}
}
