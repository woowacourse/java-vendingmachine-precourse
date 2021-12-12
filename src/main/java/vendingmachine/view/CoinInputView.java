package vendingmachine.view;

import vendingmachine.utils.Validator;

public class CoinInputView implements InputView{

	public String checkAllConditions(String nowInput) {
		try {
			Validator.validatePriceInput(nowInput);
			return nowInput;
		} catch (IllegalArgumentException error) {
			System.out.print(error.getMessage());
			return BLANK_STRING;
		}
	}

	public String getInput() {
		OutputView.noticeCoinInput();
		String coinInput = BLANK_STRING;
		while (coinInput.isEmpty()) {
			String nowInput = camp.nextstep.edu.missionutils.Console.readLine();
			coinInput = checkAllConditions(nowInput);
		}
		return coinInput;
	}
}
