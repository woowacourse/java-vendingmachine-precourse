package vendingmachine;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.regex.Pattern;

public class Application {

    public static void checkTotal(int total){
        if (total < 0){
            throw new IllegalArgumentException("[ERROR] 자판기가 보유하고 있는 금액은 0 이상이어야 합니다.");
        }
    }

    public static int getTotal(){

        while (true){
            try{
                System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
                String inputTotal = Console.readLine();

                int total = Integer.parseInt(inputTotal);

                checkTotal(total);
                return total;

            }catch (IllegalArgumentException e){
                System.out.println("[ERROR] 자판기가 보유하고 있는 금액은 0 이상이어야 합니다.");
            }
        }

    }

    public static int getCoinUnitReal(int coinUnitMax){

        List<Integer> range = new ArrayList<Integer>();
        for (int i = 0; i < coinUnitMax+1; i++){
            range.add(i);
        }

        int coinUnitReal = Randoms.pickNumberInList(range);

        return coinUnitReal;
    }

    public static Map<Coin, Integer> getCoins(int total){

        Map<Coin, Integer> coinBox = new LinkedHashMap<Coin, Integer>();

        List<Coin> coinUnitBox = Arrays.asList(Coin.COIN_500, Coin.COIN_100, Coin.COIN_50, Coin.COIN_10);

        for (int i=0; i < coinUnitBox.size() - 1; i++ ){

            Coin coinUnit = coinUnitBox.get(i);
            Integer coinUnitMax = total / coinUnit.valueOf();
            Integer coinUnitReal = getCoinUnitReal(coinUnitMax);

            coinBox.put(coinUnit, coinUnitReal);

            total -= coinUnitReal * coinUnit.valueOf();

        }

        coinBox.put(Coin.COIN_10, total/10);

        return coinBox;

    }

    public static void printCoins(Map<Coin, Integer> coinBox){

        StringBuilder sb = new StringBuilder();

        sb.append("\n자판기가 보유한 동전\n");

        for (Coin key : coinBox.keySet()){

            sb.append(key.valueOf()).append("원 - ").append(coinBox.get(key)).append("개\n");

        }

        System.out.println(sb);

    }

    public static void checkMenu(String inputMenu){

        String[] inputMenuDivided = inputMenu.split(",");
//        String inputName = inputMenuDivided[0];
        String inputPrice = inputMenuDivided[1];
        String inputLeft = inputMenuDivided[2];

        if (inputMenuDivided.length != 3) throw new IllegalArgumentException("[ERROR] 올바른 입력값이 아닙니다. 상품명과 가격과 수량을 입력해주세요");

        Integer price = Integer.parseInt(inputPrice);
        if (price < 100) throw new IllegalArgumentException("[ERROR] 올바른 입력 값이 아닙니다. 가격은 100원 이상이어야 합니다.");
        if( price%10 != 0 ) throw new IllegalArgumentException("[ERROR] 올바른 입력 값이 아닙니다. 가격은 10원으로 나누어져야 합니다.");

        Integer left = Integer.parseInt(inputLeft);
        if (left <= 0) throw new IllegalArgumentException("[ERROR] 올바른 입력 값이 아닙니다. 수량은 양수여야 합니다.");

    }

    public static void checkMenus(String inputMenus){
        String[] inputMenusDivided = inputMenus.split(";");

        String patternBracket = "^\\[[가-힣a-zA-Z]+,[0-9]+,[0-9]+\\]$";

        for(int i=0; i < inputMenusDivided.length; i++){
            boolean regex = Pattern.matches(patternBracket, inputMenusDivided[i]);
            if (!regex) throw new IllegalArgumentException("[ERROR] 올바른 입력 값이 아닙니다.");

            String inputMenu = inputMenusDivided[i].replace("[", "").replace("]", "");

            checkMenu(inputMenu);

        }

    }

    public static List<Menu> splitMenus(String inputMenus){

        List<Menu> menus = new ArrayList<Menu>();

        String[] inputMenusDivided = inputMenus.split(";");

        for(int i=0; i < inputMenusDivided.length; i++) {
            String[] inputMenuDivided = inputMenusDivided[i].replace("[", "").replace("]", "").split(",");

            String inputName = inputMenuDivided[0];
            Integer price = Integer.parseInt(inputMenuDivided[1]);
            Integer left = Integer.parseInt(inputMenuDivided[2]);

            Menu menu = new Menu(inputName, price, left);
            menus.add(menu);
        }

        return menus;
    }

    public static List<Menu> getMenus(){

        while (true){
            try{
                System.out.println("상품명과 가격, 수량을 입력해 주세요.");
                String inputMenus = Console.readLine();

                System.out.println();

                checkMenus(inputMenus);
                List<Menu> menus = splitMenus(inputMenus);

                return menus;

            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

    }

    public static void checkMoney(int money){
        if (money < 0){
            throw new IllegalArgumentException("[ERROR] 투입 금액은 0 이상이어야 합니다.");
        }
    }

    public static int getMoney(){

        while (true){
            try{
                System.out.println("투입 금액을 입력해 주세요.");
                String inputMoney = Console.readLine();

                System.out.println();

                int money = Integer.parseInt(inputMoney);

                checkMoney(money);
                return money;

            }catch (IllegalArgumentException e){
                System.out.println("[ERROR] 투입 금액은 0 이상이어야 합니다.");
            }
        }

    }

    public static void checkName(String inputName, List<Menu> menus){

        boolean isName = false;

        for (Menu menu: menus){
            if (menu.isName(inputName)){
                isName = true;
                break;
            };
        }

        if (!isName){
            throw new IllegalArgumentException("[ERROR] 판매하지 않는 메뉴입니다.");
        }

    }

    public static int getPrice(String inputName, List<Menu> menus){

        int price = -1;

        for (Menu menu: menus){
            if (menu.isName(inputName)){
                price = menu.getPrice();
                break;
            };
        }

        return price;

    }

    public static List<Menu> buyName(String inputName, List<Menu> menus){

        List<Menu> newMenu = new ArrayList<Menu>();

        for (Menu menu: menus){
            if (menu.isName(inputName)){
                menu.buy();
            };

            newMenu.add(menu);

        }

        return newMenu;

    }

    public static Pair sellName(List<Menu> menus){

        while (true){
            try{
                System.out.println("구매할 상품명을 입력해 주세요.");
                String inputName = Console.readLine();

                System.out.println();

                checkName(inputName, menus);
                int price = getPrice(inputName, menus);
                menus = buyName(inputName, menus);

                return new Pair(price, menus);

            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

    }

    public static int calcMinPrice(List<Menu> menus){

        int minPrice = -1;

        for (Menu menu : menus){
            minPrice = menu.smallerPrice(minPrice);
        }

        return minPrice;
    }

    public static boolean checkSoldOut(List<Menu> menus){


        for(Menu menu: menus){
            if(menu.isLeft()){
                return false;
            }
        }
        return true;

    }

    public static void giveChange(int money, Map<Coin, Integer> coinBox){

        StringBuilder sb = new StringBuilder();

        sb.append("잔돈\n");

        for (Coin key : coinBox.keySet()){
            int NumberOfMaxCoin = money / key.valueOf();

            int NumberOfLeftCoin = coinBox.get(key);

            int ChangeCoin = Math.min(NumberOfMaxCoin, NumberOfLeftCoin);

            money = money - ChangeCoin * key.valueOf();

            if (money <= 0) break;

            if (ChangeCoin != 0){
                sb.append(key.valueOf()).append("원 - ").append(ChangeCoin).append("개\n");
            }

        }

        System.out.println(sb);
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        int total = getTotal();

        Map<Coin, Integer> coinBox = getCoins(total);
        printCoins(coinBox);

        List<Menu> menus = getMenus();

        int money = getMoney();
        int meanPrice = calcMinPrice(menus);
        boolean soldOut = checkSoldOut(menus);
        System.out.println("투입 금액: " + money + "원");


        while (money >= meanPrice &&(!soldOut) ){

            Pair priceAndMenus = sellName(menus);
            menus = priceAndMenus.getMenus();
            Integer price = priceAndMenus.getPrice();

            money -= price;

            meanPrice = calcMinPrice(menus);
            soldOut = checkSoldOut(menus);
            System.out.println("투입 금액: " + money + "원");
        }

        giveChange(money, coinBox);

    }
}
