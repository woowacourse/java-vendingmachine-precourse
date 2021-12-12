package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.model.Item.Items;
import vendingmachine.model.money.Money;

public class InputView {

    public static final String INPUT_REQUEST_INITIAL_ASSET = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    public static final String INPUT_REQUEST_ITEMS = "상품명과 가격, 수량을 입력해 주세요.";
    public static final String ITEM_DELIMITER = ";";

    public static Money getInitialAsset() {
        try {
            System.out.println(INPUT_REQUEST_INITIAL_ASSET);
            return new Money(Integer.parseInt(Console.readLine()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getInitialAsset();
        }
    }

    public static Items getInitialItems() {
        try {
            System.out.println(INPUT_REQUEST_ITEMS);
            return new Items(Console.readLine().split(ITEM_DELIMITER));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getInitialItems();
        }
    }
}
