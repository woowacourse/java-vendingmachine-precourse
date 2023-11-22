package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

import static vendingmachine.view.validate.CoinValidator.checkNumericInput;
import static vendingmachine.view.validate.DrinkValidator.checkDrinkInput;

public class InputView {
    public static String readLine(){
        return Console.readLine();
    }

    public static int readMoney(){
        String money = readLine();
        checkNumericInput(money);
        return Integer.parseInt(money);
    }

    public static String readDrinks() {
        String drinks = readLine();
        checkDrinkInput(drinks);
        return drinks;
    }
}
