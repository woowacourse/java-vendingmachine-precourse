package vendingmachine;

import java.util.ArrayList;

public class Utils {
    static int totalNumberOfJuice;

    public static void MachineOn() {
        CheckChange();
        ArrayList<Juice> juiceIndex = PrintUI.InputJuice();
        int minPrice = FindMinPrice(juiceIndex);
        OrderJuice(minPrice, juiceIndex);
    }

    public static void CheckChange() {
        int change = PrintUI.InputChange();
        Coin.SettingCoin(change);
        Coin.PrintNumberOfCoin();
    }

    public static ArrayList<Juice> ClassifyJuice(String[] juices) {
        try {
            ArrayList<Juice> juiceIndex = new ArrayList<>();
            for (String juice : juices) {
                String[] juiceInfo = juice.substring(1,juice.length() - 1).split(",");
                juiceIndex.add(new Juice(juiceInfo[0], Integer.parseInt(juiceInfo[1]), Integer.parseInt(juiceInfo[2])));
            }
            if (SumNumberOfJuice(juiceIndex)) {
                return juiceIndex;
            }
            return PrintUI.InputJuice();
        } catch (Exception e) {
            System.out.println("[ERROR] : [제품명1,가격1,수량1];[제품명2,가격2,수량2]... 양식을 지켜주세요");
            return PrintUI.InputJuice();
        }
    }

    public static int FindMinPrice(ArrayList<Juice> juiceIndex) {
        int minPrice = 2147483647;
        for (Juice juice : juiceIndex) {
            minPrice = juice.MinPrice(minPrice);
        }
        return minPrice;
    }

    public static void OrderJuice(int minPrice, ArrayList<Juice> juiceIndex) {
        int money = PrintUI.InputMoney();
        SumNumberOfJuice(juiceIndex);
        while (money >= minPrice && totalNumberOfJuice != 0) {
            String juiceName = PrintUI.Ordering(money);
            money -= OrderCheck(money,juiceIndex,juiceName);
        }
        Coin.PrintChange(money);
    }

    public static boolean SumNumberOfJuice(ArrayList<Juice> juiceIndex) {
        try {
            for (Juice juice : juiceIndex) {
                totalNumberOfJuice = juice.SumNumber(totalNumberOfJuice);
            }
            if (totalNumberOfJuice == 0) {
                throw new IllegalArgumentException();
            }
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] : 재고를 채워주세요");
            totalNumberOfJuice = 0;
            return false;
        }
    }

    public static int OrderCheck(int money, ArrayList<Juice> juiceIndex, String orderJuice) {
        int price = 0;
        for (Juice juice : juiceIndex) {
            price = juice.EqualJuiceName(orderJuice);
            if (price != 0) {
                price = ExpensivePrice(juice, money, price);
                OneMinusTotalNumber(price);
                return price;
            }
        }
        MenuNameError();
        return price;
    }

    public static void MenuNameError() {
        try {
            throw  new IllegalArgumentException();

        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] : 그런 메뉴는 없어요");
        }
    }

    public static int ExpensivePrice(Juice juice, int money, int price) {
        try {
            if (money < price) {
                throw new IllegalArgumentException();
            }
            return juice.OutPutOneJuice();

        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] : 투입 금액보다 메뉴가 더 비싸요");
            return 0;
        }
    }

    public static void OneMinusTotalNumber(int price) {
        if (price != 0) {
            totalNumberOfJuice -= 1;
        }
    }

}
