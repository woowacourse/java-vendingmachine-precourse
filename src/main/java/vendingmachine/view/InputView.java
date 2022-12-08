package vendingmachine.view;

import vendingmachine.domain.Money;
import vendingmachine.util.ConvertInt;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public Money readMoney() {
        return Money.from(ConvertInt.convert(readLine()));
    }
}
