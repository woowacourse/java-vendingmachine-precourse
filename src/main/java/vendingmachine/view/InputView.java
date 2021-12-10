package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class InputView {
    public static int getVendingMachineTotalMoneyInput() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");

        String input = Console.readLine();
        return Integer.parseInt(input);
    }

    public static HashMap<String, List<Integer>> getMerchandiseInput() {
        HashMap<String, List<Integer>> merchandiseInfoMap = new HashMap<>();

        System.out.println("상품명과 가격, 수량을 입력해 주세요.");

        String input = Console.readLine();
        String[] merchandiseInfos = input.split(";");
        for (String m : merchandiseInfos) {
            String[] merchandiseInfo = m.substring(1, m.length() - 1).split(",");
            String name = merchandiseInfo[0];
            int price = Integer.parseInt(merchandiseInfo[1]);
            int number = Integer.parseInt(merchandiseInfo[2]);
            merchandiseInfoMap.put(name, Arrays.asList(price, number));
        }
        return merchandiseInfoMap;
    }

    public static int getCustomerMoneyInput() {
        System.out.println("투입 금액을 입력해 주세요.");

        String input = Console.readLine();
        return Integer.parseInt(input);
    }
}
