package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class InputView {

    public static int inputMachineMoney() {
        String money = "";
        while (true) {
            try {
                System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
                money = Console.readLine();
                Utils.validateNumber(money);
                break;
            } catch (Exception e) {
                System.out.println("[ERROR] 금액은 "+e.getMessage());
            }
        }
        return Integer.parseInt(money);
    }

    public static ArrayList inputProductList() {
        System.out.println();
        System.out.println("상품명과 가격, 수량을 입력해 주세요.");
        String inputString = Console.readLine();
        ArrayList<String> strings = Utils.splitString(inputString);
        ArrayList<Product> products = new ArrayList<Product>();
        for (String str : strings) {
            products.add(new Product(str.split(",")[0], Integer.parseInt(str.split(",")[1]), Integer.parseInt(str.split(",")[2])));
        }
        return products;
    }

    public static int inputMoney() {
        System.out.println();
        System.out.println("투입 금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    public static String inputProduct() {
        System.out.println("구매할 상품명을 입력해 주세요.");
        return Console.readLine();
    }
}
