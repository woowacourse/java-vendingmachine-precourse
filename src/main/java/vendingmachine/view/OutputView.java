package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import vendingmachine.model.Coin;
import vendingmachine.util.Constant;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    private static final List<String[]> productsInfo = new ArrayList<>();
    public static List<String> productsName = new ArrayList<>();
    public static List<Integer> productsNum = new ArrayList<>();
    private static String chooseProductName;
    private static final List<Integer> coinAmount = new ArrayList<>();
    private static int nowMoney;

    public static void askVendingMachinePrice(){
        System.out.println(Constant.VENDING_MACHINE_HOLDING_PRICE);
    }

    public static void askProduct(){
        System.out.println(Constant.PRODUCT);
    }

    public static void askInsertMoney(){
        System.out.println(Constant.INSERT_MONEY);
    }

    public static void showCoins(int vendingmachineholdingPrice) {
        getCoins(vendingmachineholdingPrice);
        System.out.println(Constant.VENDING_MACHINE_HOLDING_COIN);
        for(Coin coins : Coin.values()) {
            System.out.println(coins.getAmount()+"원 - "+ coins.getNum()+"개");
        }
        System.out.println();
    }

    private static void getCoins(int vendingmachineholdingPrice) {
        int remainMoney = vendingmachineholdingPrice;
        for (Coin coin : Coin.values()) {
            coinAmount.add(coin.getAmount());
        }
        Coin[] coinsNum = Coin.values();
        while (remainMoney!=0) {
            int coinAmountIndex=Randoms.pickNumberInList(coinAmount);
            if (remainMoney-coinAmountIndex<0) {
                continue;
            }
            remainMoney-=coinAmountIndex;
            coinsNum[coinAmount.indexOf(coinAmountIndex)].setNum(coinsNum[coinAmount.indexOf(coinAmountIndex)].getNum()+1);
        }
    }

    public static void showAllProcess(String[] products, int insertMoney) {
        for (String product : products) {makeProductInfo(product);}
        getProductNameList();
        getProductNumList();
        int minProductPrice = getMinProductPrice();
        nowMoney = insertMoney;
        while (minProductPrice <= nowMoney) {
            if (isSoldOut()) {break;}
            showProcess();
        }
        System.out.println(Constant.NOW_MONEY+nowMoney+Constant.WON);
        getChanges();
    }

    private static void getChanges() {
        System.out.println(Constant.CHANGES);
        int remainMoney = nowMoney;
        for(Coin coins : Coin.values()) {
            int maxNumCoin = remainMoney/coins.getAmount();
            if (maxNumCoin<=coins.getNum()){coins.setFinalNum(maxNumCoin);}
            if (maxNumCoin>coins.getNum()){coins.setFinalNum(coins.getNum());}
            remainMoney-=coins.getAmount()*coins.getFinalNum();
            if (coins.getFinalNum()>0){System.out.println(coins.getAmount()+"원 - "+ coins.getFinalNum()+"개");}
        }
    }

    private static void showProcess() {
        System.out.println(Constant.NOW_MONEY + nowMoney + Constant.WON);
        checkProduct();
    }

    private static void checkProduct() {
        try {
            setProductsName();
            getNowMoney(chooseProductName);
        } catch (IllegalArgumentException e) {
            System.out.println(Constant.CHOOSE_PRODUCT_NAME_ERROR);
            checkProduct();
        }
    }

    private static void getNowMoney(String chooseProductName) {
        int indexProduct = indexProduct(productsName, chooseProductName);
        int productPrice = Integer.parseInt(productsInfo.get(indexProduct)[1]);
        isValidProductNum(indexProduct, productPrice);
        productsNum.set(indexProduct,productsNum.get(indexProduct)-1);
        nowMoney -= productPrice;
    }

    private static void isValidProductNum(int indexProduct, int productPrice) {
        if (productsNum.get(indexProduct) < 1) {
            throw new IllegalArgumentException();
        }
        if (productPrice>nowMoney) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isSoldOut() {
        int totalNum=0;
        for (int productNum : productsNum) {
            totalNum += productNum;
        }
        return totalNum == 0;
    }

    private static int indexProduct(List<String> productsName, String result) {
        int i;
        for (i = 0; i < productsName.size(); i++) {
            String item = productsName.get(i);
            if (item.equals(result)) {
                break;
            }
        }
        return i;
    }

    private static void setProductsName() {
        System.out.println(Constant.CHOOSE_PRODUCT);
        String input = Console.readLine();
        System.out.println();
        InputView.isValidProductName(input, productsName);
        chooseProductName = input;
    }

    private static void makeProductInfo(String product) {
        product = product.substring(1, product.length() - 1);
        String[] productInfo = product.split(",");
        productsInfo.add(productInfo);
    }

    private static void getProductNameList() {
        for (String[] product : OutputView.productsInfo) {
            productsName.add(product[0]);
        }
    }

    private static void getProductNumList() {
        for (String[] product : OutputView.productsInfo) {
            int result = Integer.parseInt(product[2]);
            productsNum.add(result);
        }
    }

    private static int getMinProductPrice() {
        int minPrice = 10000000;
        for (String[] product : OutputView.productsInfo) {
            int result = Integer.parseInt(product[1]);
            if (result < minPrice) {
                minPrice = result;
            }
        }
        return minPrice;
    }
}
