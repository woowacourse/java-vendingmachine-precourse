package vendingmachine.exception;

import static vendingmachine.constant.Constant.*;
import static vendingmachine.constant.Error.*;
import static vendingmachine.exception.PriceValidator.*;

import vendingmachine.machine.Machine;
import vendingmachine.product.Product;

public class ProductValidator {
    public static void validateSplitProduct(String input){
        if (input.split(PRODUCT_SPLITTER).length <=0){
            throw new IllegalArgumentException(ERROR_INPUT_PRODUCT_SPLITTER);
        }
    }

    public static void validateSplitInfos(String[] productList){
        for (String product: productList) {
            product=product.substring(1,product.length()-1);
            String[] infoList = product.split(INFO_SPLITTER);
            if (infoList.length !=INFO_NUM){
                throw new IllegalArgumentException(ERROR_INPUT_INFO_SPLITTER);
            }
            validateInfo(infoList);
        }
    }

    private static void validateInfo(String[] infoList) {
        // 이름 검사
        validateName(infoList[0]);
        // 가격 검사
        validatePrice(infoList[1]);
        // 재고 검사
        validateInt(infoList[2]);
    }

    private static void validateName(String name){
        if (name.length() <=0){
            throw new IllegalArgumentException(ERROR_INPUT_NAME);
        }
    }


    public static void validateIsIn(Machine machine,String product){
        if (!machine.isIn(product)){
            throw new IllegalArgumentException(ERROR_INPUT_IS_PRODUCT);
        }
    }

    public static void validateCanBuy(Machine machine, String productName){
        Product product = machine.findProduct(productName);
        if (product.getPrice() > machine.getMoney()){
            throw new IllegalArgumentException(ERROR_INPUT_BUY_PRODUCT);
        }
    }
}
