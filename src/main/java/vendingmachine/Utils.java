package vendingmachine;

import java.util.ArrayList;
import java.util.Objects;

public class Utils {
    public static void MachineOn() {
        CheckChange();
        String[] juices = PrintUI.InputJuice();
        ArrayList<Juice> juiceIndex = ClassifyJuice(juices);
        int minPrice = FindMinPrice(juiceIndex);
        OrderJuice(minPrice, juiceIndex);
    }

    public static void CheckChange() {
        int change = PrintUI.InputChange();
        Coin.SettingCoin(change);
        Coin.PrintNumberOfCoin();
    }

    public static ArrayList<Juice> ClassifyJuice(String[] juices) {
        ArrayList<Juice> juiceIndex = new ArrayList<>();
        for (String juice : juices) {
            String[] juiceInfo = juice.substring(1,juice.length() - 1).split(",");
            juiceIndex.add(new Juice(juiceInfo[0], Integer.parseInt(juiceInfo[1]), Integer.parseInt(juiceInfo[2])));
        }
        return juiceIndex;
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
        while (true) {
            String juiceName = PrintUI.Ordering(money);
            money -= OrderCheck(juiceIndex,juiceName);
            if (money < minPrice) {
                break;
            }
        }
        Coin.PrintChange(money);
    }

    public static int OrderCheck(ArrayList<Juice> juiceIndex, String orderJuice) {
        for (Juice juice : juiceIndex) {
            if (Objects.equals(juice.getName(), orderJuice)) {
                return juice.getPrice();
            }
        }
        return 0;
    }

}
