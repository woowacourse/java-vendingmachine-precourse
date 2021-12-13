package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class InputView {
    private static String INPUT_MACHINE_MONEY_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    private static String INPUT_PRODUCT_LIST_MESSAGE = "\n상품명과 가격, 수량을 입력해 주세요.";
    private static String INPUT_MONEY_MESSAGE = "\n투입 금액을 입력해 주세요.";
    private static String INPUT_BUY_PRODUCT = "구매할 상품명을 입력해 주세요.";

    public static int inputMachineMoney() {
        String money = "";
        while (true) {
            System.out.println(INPUT_MACHINE_MONEY_MESSAGE);
            money = Console.readLine();
            try {
                Utils.validateNumber(money);
                Utils.validatePositiveNumber(Integer.parseInt(money));
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return Integer.parseInt(money);
    }

    public static ArrayList inputProductList() {
        ArrayList<Product> products = new ArrayList<Product>();
        while (true) {
            System.out.println(INPUT_PRODUCT_LIST_MESSAGE);
            String inputString = Console.readLine();
            try {
                products = Product.makeProductList(Utils.splitString(inputString));
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return products;
    }

    public static int inputMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
        return Integer.parseInt(Console.readLine());
    }

    public static String inputBuyProduct(ArrayList<Product> products) {
        String buyProduct = "";
        while (true) {
            System.out.println(INPUT_BUY_PRODUCT);
            buyProduct = Console.readLine();
            try {
                Utils.validateRegistered(products, buyProduct);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return buyProduct;
    }
}
