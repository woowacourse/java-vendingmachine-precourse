package vendingmachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Validation {
    static int PRODUCT_NAME = 0;
    static int PRODUCT_PRICE = 1;
    static int PRODUCT_AMOUNT = 2;
    static boolean VALIDATION_SUCCESS = true;

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
    public static void userMoneyNotEnough(Product purchaseProductObject, int userOwnMoney) {
        if (purchaseProductObject.getPrice() > userOwnMoney) {
            throw new IllegalArgumentException("[ERROR] 투입 금액이 부족합니다.");
        }
    }

    public static boolean isUserMoneyAndMachineInventoryEnough(ArrayList<Product> products, int userOwnMoney){
        boolean enough = false;
        int vendingMachineInventory = 0;
        View.noticeMsgOnUserOwnMoney(userOwnMoney);
        for(Product product: products){
            if(product.getPrice() <= userOwnMoney){    // 현재 가진 금액으로 살 수 있는 음료가 하나라도 있는지 확인
                enough = true;
            }
            vendingMachineInventory += product.getAmount();     // 자판기의 재고가 하나라도 있는지 확인
        }
        if(vendingMachineInventory == 0){
            enough = false;
        }
        return enough;
    }

    public static void userMoneyValidation(String userOwnMoney){
        String regex = "^[0-9]{2,}$";
        if (!Pattern.matches(regex, userOwnMoney)) throw new IllegalArgumentException("[ERROR] 금액은 숫자여야 합니다.");
    }

    public static void machineOwnMoneyValidation(String machineOwnMoney){
        String regex = "^[0-9]{2,}$";
        if (!Pattern.matches(regex, machineOwnMoney)) throw new IllegalArgumentException("[ERROR] 금액은 숫자여야 합니다.");
    }

    public static void inputProductValidation(ArrayList<String> stringList){
        String regex = "^[0-9]*$";
        for(int i = 0; i < stringList.size() - 2; i += 3){
            if (!Pattern.matches(regex, stringList.get(i+PRODUCT_PRICE))) throw new IllegalArgumentException("[ERROR] 가격은 숫자여야 합니다.");
            if (!Pattern.matches(regex, stringList.get(i+PRODUCT_AMOUNT))) throw new IllegalArgumentException("[ERROR] 수량은 숫자여야 합니다.");
            if (stringList.get(i+PRODUCT_AMOUNT).equals("0")) throw new IllegalArgumentException("[ERROR] 수량은 한 개 이상이어야 합니다.");
        }
    }

    public static ArrayList<String> stringParsingToList(String productString){
        ArrayList<String> totalProduct = new ArrayList<>();
        if(!productString.startsWith("[") || !productString.endsWith("]")) throw new IllegalArgumentException("[ERROR] 상품 정보 입력 형식이 올바르지 않습니다.");
        for(String pickOneProduct: productString.split(";")){
            String[] oneProductSplit = pickOneProduct.split(",");
            if(oneProductSplit.length != 3) throw new IllegalArgumentException("[ERROR] 상품 정보 입력 형식이 올바르지 않습니다.");
            oneProductSplit[PRODUCT_NAME] = oneProductSplit[PRODUCT_NAME].substring(1);
            oneProductSplit[PRODUCT_AMOUNT] = oneProductSplit[PRODUCT_AMOUNT].substring(0, oneProductSplit[PRODUCT_AMOUNT].length()-1);
            totalProduct.addAll(Arrays.asList(oneProductSplit));
        }
        return totalProduct;
    }

}
