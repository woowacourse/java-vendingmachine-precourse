package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import vendingmachine.model.Coin;
import vendingmachine.util.Constant;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    private static List<String[]> productsInfo = new ArrayList<>();
    public static List<String> productsName = new ArrayList<>();

    public static void askVendingMachinePrice(){
        System.out.println(Constant.VENDING_MACHINE_HOLDING_PRICE);
    }

    public static void askProduct(){
        System.out.println(Constant.PRODUCT);
    }

    public static void askInsertMoney(){
        System.out.println(Constant.INSERT_MONEY);
    }

    public static void showCoins(int vendingmachineholdingPrice){
        getCoins(vendingmachineholdingPrice);
        System.out.println(Constant.VENDING_MACHINE_HOLDING_COIN);
        for(Coin coins : Coin.values()){
            System.out.println(coins.getAmount()+"원 - "+ coins.getNum()+"개");
        }
        System.out.println();
    }

    private static void getCoins(int vendingmachineholdingPrice){
        int remainMoney = vendingmachineholdingPrice;
        for(Coin coins : Coin.values()) {
            if (coins.getAmount() == 10) {coins.setNum(remainMoney / 10);
                break;
            }
            int maxNumCoin = remainMoney / coins.getAmount();
            List<Integer> NumCoinList = new ArrayList<>();
            for (int i = 0; i < maxNumCoin + 1; i++) {NumCoinList.add(i);}
            int numCoin = Randoms.pickNumberInList(NumCoinList);
            remainMoney -= numCoin * coins.getAmount();
            coins.setNum(numCoin);
        }
    }

    public static void showAllProcess(String[] products, int insertMoney){
        for (String product : products){
            makeProductInfo(product);
        }
        getProductNameList(productsInfo);
        int minProductPrice = getMinProductPrice(productsInfo);
        int nowMoney = insertMoney;

        while (minProductPrice<nowMoney){
            nowMoney = showProcess(productsInfo, nowMoney, productsName);
        }
        System.out.println(Constant.NOW_MONEY+nowMoney+Constant.WON);
        getChanges(nowMoney);
    }
    private static void getChanges(int nowMoney){

    }
    private static int showProcess(List<String[]> productsInfo, int nowMoney, List<String> productsName){
        String result;
        System.out.println(Constant.NOW_MONEY+nowMoney+Constant.WON);
        try{
            result = setProductsName();
        } catch (IllegalArgumentException e){
            System.out.println(Constant.CHOOSE_PRODUCT_ERROR);
            result = setProductsName();
        }
        int indexProduct = indexProduct(productsName,result);
        int productPrice = Integer.parseInt(productsInfo.get(indexProduct)[1]);
        nowMoney-=productPrice;
        return nowMoney;
    }

    private static int indexProduct(List<String> productsName, String result){
        int i;
        for (i = 0; i < productsName.size(); i++) {
            String item = productsName.get(i);
            if (item.equals(result)) {
                break;
            }
        }
        return i;
    }
    private static String setProductsName(){
        System.out.println(Constant.CHOOSE_PRODUCT);
        String input = Console.readLine();
        System.out.println();
        InputView.isValidProductName(input, productsName);
        return input;
    }

    private static void makeProductInfo(String product){
        product = product.substring(1, product.length() - 1);
        String[] productInfo = product.split(",");
        productsInfo.add(productInfo);
    }

    public static void getProductNameList(List<String[]> products){
        for (String[] product : products){
            productsName.add(product[0]);
        }
    }

    private static int getMinProductPrice(List<String[]> products){
        int minPrice = 10000000;
        for (String[] product : products){
            int result = Integer.parseInt(product[1]);
            if (result < minPrice){
                minPrice = result;
            }
        }
        return minPrice;
    }
}
