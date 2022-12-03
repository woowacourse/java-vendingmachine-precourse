package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.enums.Coin;

public class InputView {
    private final OutputView outputView = new OutputView();

    public int inputChange() {
        return getAndValidateChange();
    }

    private Integer getAndValidateChange() {
        String inputChange = "";
        while (!inputChange.equals("")) {
            outputView.askInputPricePrint();
            try {
                inputChange = Console.readLine();
                inputDigitValidation(inputChange);
                changeDivideTen(inputChange);
            } catch (IllegalArgumentException e) {
                inputChange = "";
            }
        }
        return Integer.parseInt(inputChange);
    }

    private void changeDivideTen(String inputChange) {
        if (!Coin.isDivideMinCoin(inputChange)) throw new IllegalArgumentException("[ERROR] 잔돈이 나눠지지 않습니다.");
    }

    private void inputDigitValidation(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 금액은 숫자여야합니다.");
        }
    }
}
