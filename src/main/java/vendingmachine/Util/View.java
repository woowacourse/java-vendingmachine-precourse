package vendingmachine.Util;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.Domain.Change;
import vendingmachine.Domain.Product;

import java.util.List;

public class View extends Print {

    Validation validate = new Validation();
    Caster cast = new Caster();

    public Change getInitChanges() {
        inputChanges();
        String inputChangeCost = Console.readLine();
        // validation

        // cast To number
        int changeMoney = Integer.parseInt(inputChangeCost);
        // show result Of create Random
        return cast.toChangeCoins(changeMoney);
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
