package vendingmachine;

import java.util.Map;

public class View {
    public static void inputMsgOnVendingMachine(){
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
    }

    public static void noticeMsgOnCoins(){
        System.out.println("자판기가 보유한 동전");
    }

    public static void noticeMsgOnEachCoin(Coin coin){
        System.out.println(coin.getAmount()+"원 - " + coin.getCount()+"개");
    }

    public static void inputMsgOnProduct(){
        System.out.println("상품명과 가격, 수량을 입력해 주세요.");
    }

    public static void inputMsgOnPurchaseProduct(){
        System.out.println("구매할 상품명을 입력해 주세요.");
    }

    public static void inputMsgOnUser(){
        System.out.println("투입 금액을 입력해 주세요.");
    }

    public static void noticeMsgOnChanges(){
        System.out.println("잔돈");
    }

    public static void noticeMsgOnEachChanges(Map.Entry entry){
        System.out.println(entry.getKey() + "원 - " + entry.getValue() + "개");
    }

    public static void noticeMsgOnException(String exceptionMsg){
        System.out.println(exceptionMsg);
    }

    public static void noticeMsgOnUserOwnMoney(int userOwnMoney){
        System.out.println("투입 금액: " + userOwnMoney + "원");
    }
}
