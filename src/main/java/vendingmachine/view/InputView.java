package vendingmachine.view;

import static vendingmachine.validator.NumberValidator.*;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.Menu;
import vendingmachine.domain.Merchandise;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    public static int getTotalMoneyInput() {
        try {
            System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");

            String input = Console.readLine();
            validateTotalMoneyInput(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getTotalMoneyInput();
        }
    }

    public static Menu getMenuInput() {
        System.out.println("상품명과 가격, 수량을 입력해 주세요.");
        List<Merchandise> merchandiseList = new ArrayList<>();

        String input = Console.readLine();
        String[] merchandiseInfos = input.split(";");
        for (String m : merchandiseInfos) {
            String[] merchandiseInfo = m.substring(1, m.length() - 1).split(",");
            String name = merchandiseInfo[0];
            int price = Integer.parseInt(merchandiseInfo[1]);
            int number = Integer.parseInt(merchandiseInfo[2]);
            merchandiseList.add(new Merchandise(name, price, number));
        }
        return new Menu(merchandiseList);
    }

    public static int getCustomerMoneyInput() {
        System.out.println("\n투입 금액을 입력해 주세요.");

        String input = Console.readLine();
        return Integer.parseInt(input);
    }

    public static String getMerchandiseNameInput() {
        System.out.println("구매할 상품명을 입력해 주세요.");

        return Console.readLine();
    }
}
