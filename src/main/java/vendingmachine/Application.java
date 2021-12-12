package vendingmachine;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.regex.Pattern;

import static vendingmachine.Validation.*;
import static vendingmachine.VendingMachine.startVendingMachine;

public class Application {
    static int USER_MONEY = 0;
    static int MACHINE_OWN_MONEY = 0;
    static int PRODUCT_NAME = 0;
    static int PRODUCT_PRICE = 1;
    static int PRODUCT_AMOUNT = 2;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        MACHINE_OWN_MONEY = inputMachineOwnMoney();
        setRandomCountToEachCoin();
        printCurrentMachineCoin();
        ArrayList<Product> products = inputProductNamePriceAmount();
        insertMoneyByUser();
        startVendingMachine(products);
    }

}
