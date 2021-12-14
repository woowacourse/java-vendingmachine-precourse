package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class PrintUI {
    public static int InputChange() {
        int change;
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        try {
            change = Integer.parseInt(Console.readLine());
            if (change < 0 || !((change/10)*10 == change)) {
                throw new IllegalArgumentException();
            }
            System.out.println();
            return change;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] : 금액은 최소 10원 단위의 양의 정수로 입력해주세요");
            return InputChange();
        }
    }

    public static ArrayList<Juice> InputJuice() {
        System.out.println("상품명과 가격, 수량을 입력해 주세요.");
        String[] Juices = Console.readLine().split(";");
        System.out.println();
        return Utils.ClassifyJuice(Juices);
    }

    public static int InputMoney() {
        System.out.println("투입 금액을 입력해 주세요.");
        try {
            int money = Integer.parseInt(Console.readLine());
            if (money < 0) {
                throw new IllegalArgumentException();
            }
            System.out.println();
            return money;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] : 양의 정수를 입력해주세요");
            return InputMoney();
        }
    }

    public static String Ordering(int money) {
        System.out.println("투입 금액: " + money +"원");
        System.out.println("구매할 상품명을 입력해 주세요.");
        String orderJuice = Console.readLine();
        System.out.println();
        return orderJuice;
    }
}
