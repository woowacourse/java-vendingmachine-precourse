package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.regex.Pattern;

import static vendingmachine.Validation.*;

public class User {

    private int userOwnMoney;

    public User(int userOwnMoney){
        this.userOwnMoney = userOwnMoney;
    }


    public static void purchaseProduct(ArrayList<Product> products) throws IllegalArgumentException {
        System.out.println("구매할 상품명을 입력해 주세요.");
        String purchaseProductName = Console.readLine();
        Product purchaseProductObject = findPurchaseProduct(products, purchaseProductName);
        productNotFound(purchaseProductObject);
        productAmountNotEnough(purchaseProductObject);
        userMoneyNotEnough(purchaseProductObject);
        purchaseSuccess(purchaseProductObject);
    }


    public static void purchaseSuccess(Product product){
        product.sold();
        USER_MONEY -= product.getPrice();
    }

    public static void insertMoneyByUser(){
        String userMoney = "";
        while(userMoney.isEmpty()){
            try{
                userMoney = userMoneyValidation();
                USER_MONEY = Integer.parseInt(userMoney);
            }catch (IllegalArgumentException e){
                System.out.println("[ERROR] 금액은 숫자여야 합니다.");
            }
        }
    }

    public static String userMoneyValidation(){
        System.out.println("투입 금액을 입력해 주세요.");
        String userMoney = Console.readLine();
        String regex = "^[0-9]*$";
        if (!Pattern.matches(regex, userMoney)) throw new IllegalArgumentException();
        return userMoney;
    }

}
