package vendingmachine;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class View {
    public static int setMoney() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    public static void printCoins(List<Coin> coins) {
        System.out.println("자판기가 보유한 동전");
        for (int i=0; i<coins.size(); i++) {
            String result = "";
            result += coins.get(i).getAmount()+"원 - ";
            result += coins.get(i).getNumberOfCoins()+"개";
            System.out.println(result);
        }
    }

    public static String[] inputProduct() {
        System.out.println("상품명과 가격, 수량을 입력해 주세요.");
        String[] result;
        result = Console.readLine().split(";");
        return result;
    }
}
