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
        ArrayList<Product> products = new ArrayList<Product>();
        while (true) {
            try {
                System.out.println("\n상품명과 가격, 수량을 입력해 주세요.");
                String inputString = Console.readLine();
                products = Product.makeProductList(Utils.splitString(inputString));
                break;
            } catch (Exception e) {
                System.out.println("[ERROR] 가격 혹은 수량이"+e.getMessage());
            }
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
