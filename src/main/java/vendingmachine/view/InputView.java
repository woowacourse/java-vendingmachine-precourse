package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

import static vendingmachine.view.constants.Regex.REGEX_SELECT_BRACKETS;
import static vendingmachine.view.validate.CoinValidator.checkNumericInput;
import static vendingmachine.view.validate.DrinkValidator.checkDrinkInput;
import static vendingmachine.view.validate.DrinkValidator.checkOnlyKoreanLetter;

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
        return drinks.replaceAll(REGEX_SELECT_BRACKETS, "");
    }

    public static String readPurchase() {
        String purchase = readLine();
        checkOnlyKoreanLetter(purchase);
        return purchase;
    }
}
