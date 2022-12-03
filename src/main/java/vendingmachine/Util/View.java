package vendingmachine.Util;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.Domain.Product;

import java.util.List;

public class View extends Print {

    Validation validate = new Validation();
    Caster cast = new Caster();

    public int getInitChanges() {
        inputChanges();
        String input = Console.readLine();
        // validation
        // show result Of create Random
        // cast To number

        return 0;
    }

    public List<Product> getInitProducts() {
        inputProductInfo();
        String input = Console.readLine();
        // validation
        return cast.toProducts(input);
    }

    public int getPurchaseMoney() {
        inputPurchaseMoney();
        String input = Console.readLine();
        // validation
        // cast To number
        return Integer.parseInt(input);
    }

    public String getProductNameToBuy(List<Product> product) {
        inputProductToBuy();
        String input = Console.readLine();
        // validate
        return input;
    }

}
