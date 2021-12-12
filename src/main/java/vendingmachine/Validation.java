package vendingmachine;

import java.util.ArrayList;
import java.util.regex.Pattern;

import static vendingmachine.Application.USER_MONEY;

public class Validation {


    public static void productNotFound(Product purchaseProductObject){
        if(purchaseProductObject == null){
            throw new IllegalArgumentException("[ERROR] 찾으시는 상품이 없습니다.");
        }
    }
    public static void productAmountNotEnough(Product purchaseProductObject){
        if(purchaseProductObject.getAmount() == 0){
            throw new IllegalArgumentException("[ERROR] 상품의 재고가 없습니다.");
        }
    }
    public static void userMoneyNotEnough(Product purchaseProductObject) {
        if (purchaseProductObject.getPrice() > USER_MONEY) {
            throw new IllegalArgumentException("[ERROR] 투입 금액이 부족합니다.");
        }
    }

    public static boolean isUserMoneyAndMachineInventoryEnough(ArrayList<Product> products){
        System.out.println("투입 금액: " + USER_MONEY + "원");
        boolean enough = false;
        int amountCount = 0;
        for(Product product: products){
            if(product.getPrice() <= USER_MONEY){    // 현재 가진 금액으로 살 수 있는 음료가 하나라도 있는지 확인
                enough = true;
            }
            amountCount += product.getAmount();     // 자판기의 재고가 하나라도 있는지 확인
        }
        if(amountCount == 0){
            enough = false;
        }
        return enough;
    }

    public static void userMoneyValidation(String userMoney){
        String regex = "^[0-9]*$";
        if (!Pattern.matches(regex, userMoney)) throw new IllegalArgumentException("[ERROR] 금액은 숫자여야 합니다.");
    }

    public static void inputMachineOwnMoneyAndValidation(String machineOwnMoney){
        String regex = "^[0-9]{2,}$";
        if (!Pattern.matches(regex, machineOwnMoney)) throw new IllegalArgumentException("[ERROR] 금액은 숫자여야 합니다.");
    }
}
