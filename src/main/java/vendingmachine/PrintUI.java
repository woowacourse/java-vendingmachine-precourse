package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

public class PrintUI {
    public static int InputChange() {
        int change;
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        try {
            change = Integer.parseInt(Console.readLine());
            if (change < 0) {
                throw new IllegalArgumentException();
            }
            System.out.println();
            return change;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] : 음수는 넣을 수 없어요");
            return InputChange();
        }
    }

    public static String[] InputJuice() {
        System.out.println("상품명과 가격, 수량을 입력해 주세요.");
        String[] Juices = Console.readLine().split(";");
        System.out.println();
        return Juices;
    }

    public static int InputMoney() {
        System.out.println("투입 금액을 입력해 주세요.");
        int money = Integer.parseInt(Console.readLine());
        if (money < 0) {
            throw new IllegalArgumentException("[ERROR] : 음수는 넣을 수 없어요");
        }
        System.out.println();
        return money;
    }

    public static String Ordering(int money) {
        System.out.println("투입 금액: " + money +"원");
        System.out.println("구매할 상품명을 입력해 주세요.");
        String orderJuice = Console.readLine();
        System.out.println();
        return orderJuice;
    }
}
