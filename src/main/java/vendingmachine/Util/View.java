package vendingmachine.Util;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.Domain.Change;

import java.util.List;

public class View extends Print {

    Validation validate = new Validation();

    public int getInitChanges() {
        inputChanges();
        String input = Console.readLine();
        // validation
        // cast To number

        return 0;
    }

    public List<Change> getInitProducts() {
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

    public List<Change> buyProduct(List<Change> product, String target) {
        inputProductToBuy();
        // validation
        // remove target from list
        return null;
    }


}
