package vendingmachine.item;

import camp.nextstep.edu.missionutils.Console;

public class ItemView {
    private final static String INPUT_MESSAGE = "상품명과 가격, 수량을 입력해 주세요.";

    public static String inputItems() {
        System.out.println(INPUT_MESSAGE);
        return Console.readLine();
    }
}
