package vendingmachine.game;

import camp.nextstep.edu.missionutils.Console;

import vendingmachine.util.Constant;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class RunGame {
    private static int vendingmachineholdingPrice;
    private static String[] products;
    private static int insertMoney;

    public static void run(){
        checkVendingMachinePrice();
        OutputView.showCoins(vendingmachineholdingPrice);
        checkProduct();
        checkInsertMoney();
        OutputView.showAllProcess(products, insertMoney);

    }

    private static void checkVendingMachinePrice(){
        try{
            setPrice();
        } catch (IllegalArgumentException e){
            System.out.println(Constant.VENDING_MACHINE_HOLDING_PRICE_ERROR);
            checkVendingMachinePrice();
        }

    }

    private static void setPrice(){
        OutputView.askVendingMachinePrice();
        String input = Console.readLine();
        System.out.println();
        vendingmachineholdingPrice = InputView.parseInt(input);
    }

    private static void checkProduct(){
        try{
            setProduct();
        } catch (IllegalArgumentException e){
            System.out.println(Constant.PRODUCT_ERROR);
            checkProduct();
        }
    }

    private static void setProduct(){
        OutputView.askProduct();
        String input = Console.readLine();
        System.out.println();
        products = InputView.splitString(input);
    }

    private static void checkInsertMoney(){
        try {
            setInsertMoney();
        } catch (IllegalArgumentException e){
            System.out.println(Constant.INSERT_MONEY_ERROR);
            checkInsertMoney();
        }
    }

    private static void setInsertMoney(){
        OutputView.askInsertMoney();
        String input = Console.readLine();
        System.out.println();
        insertMoney = InputView.parseOnlyInt(input);
    }
}
