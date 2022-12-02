package vendingmachine.model;

import camp.nextstep.edu.missionutils.Console;

import java.util.Map;

public class Validator {

    public static void validateProduct(String[] productInfo, Map<String, Product> products) throws IllegalArgumentException {
        if (productInfo.length != 3) {
            throw new IllegalArgumentException("형식에 맞지 않습니다.");
        }
        if (products.containsKey(productInfo[0])) {
            throw new IllegalArgumentException("같은 이름의 상품은 입력할 수 없습니다.");
        }
    }
    
}
