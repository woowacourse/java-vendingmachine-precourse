package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.model.Item.Items;
import vendingmachine.model.buy.BuyItemName;
import vendingmachine.model.money.MoneyBill;

public class InputView {

    public static final String INPUT_REQUEST_INITIAL_ASSET = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    public static final String INPUT_REQUEST_ITEMS = "상품명과 가격, 수량을 입력해 주세요.";
    public static final String ITEM_DELIMITER = ";";
    public static final String INPUT_REQUEST_MONEY = "투입 금액을 입력해 주세요.";
    public static final String INPUT_REQUEST_ITEM_NAME = "구매할 상품명을 입력해 주세요.";

    public static String getInitialMoney() {
        // try {
        //     System.out.println(INPUT_REQUEST_INITIAL_ASSET);
        //     // String input = Console.readLine();
        //     // return new Money(Integer.parseInt(Console.readLine()));
        //     return Console.readLine();
        // } catch (Exception e) {
        //     System.out.println(e.getMessage());
        //     return getInitialMoney();
        // }
        System.out.println(INPUT_REQUEST_INITIAL_ASSET);
        return Console.readLine();
    }

    public static Items getInitialItems() {
        try {
            System.out.println(INPUT_REQUEST_ITEMS);
            return new Items(Console.readLine().split(ITEM_DELIMITER));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getInitialItems();
        }
    }

    public static MoneyBill getInputMoney() {
        try {
            System.out.println("tef222");
            System.out.println(INPUT_REQUEST_MONEY);
            return new MoneyBill(Integer.parseInt(Console.readLine()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getInputMoney();
        }
    }

    public static BuyItemName getBuyItemName() {
        try {
            System.out.println(INPUT_REQUEST_ITEM_NAME);
            return new BuyItemName(Console.readLine());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getBuyItemName();
        }
    }
}
