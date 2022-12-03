package vendingmachine.Util;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.Domain.Product;

import java.util.List;

public class View extends Print {

    Validation validate = new Validation();

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
        // cast To List
        return null;
    }

    public int getPurchaseMoney() {
        inputPurchaseMoney();
        String input = Console.readLine();
        // validation
        // cast To number
        return 0;
    }

    public List<Product> buyProduct(List<Product> product) {
        inputProductToBuy();
        String productName = Console.readLine();
        // validation
        // remove target from list
        return null;
    }


}
