package vendingmachine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private static List<Coin> coins;
    private View view;
    private static VendingMachine vendingMachine;

    public Controller(VendingMachine vendingMachine, View view) {
        this.view = view;
        this.vendingMachine = vendingMachine;
        this.coins = makeCoins();
    }

    public static List<Coin> makeCoins() {
        List<Coin> coins = new ArrayList<>();
        coins.add(Coin.COIN_500);
        coins.add(Coin.COIN_100);
        coins.add(Coin.COIN_50);
        coins.add(Coin.COIN_10);
        return coins;
    }

    public List<Coin> getCoins() {
        return this.coins;
    }

    public void setMoney() {
        vendingMachine.setMoney(view.setMoney());
    }

    public void printCoins() {
        System.out.println();
        changeCoins();
        view.printCoins(this.coins);
        System.out.println();
    }

    public static void changeCoins() {
        int money = vendingMachine.getMoney();
        int indexOfCOIN_10 = 3;
        for (int i=0; i<3; i++) {
            List<Integer> randomList = getRandomList(money, coins.get(i));
            int randomNumber = Randoms.pickNumberInList(randomList);
            coins.get(i).setNumberOfCoins(randomNumber);
            money -= randomNumber*coins.get(i).getAmount();
        }
        coins.get(indexOfCOIN_10).setNumberOfCoins(money/10);
    }

    private static List<Integer> getRandomList(int money, Coin coin) {
        List<Integer> randomList = new ArrayList<Integer>();
        for (int i=0; i<=money/coin.getAmount(); i++) {
            randomList.add(i);
        }
        return randomList;
    }

}
