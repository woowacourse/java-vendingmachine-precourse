package vendingmachine;

import java.util.HashMap;

import camp.nextstep.edu.missionutils.Console;

public class ProductList {
    private static final String PRODUCT_INSERT_MESSAGE = "상품명과 가격, 수량을 입력해주세요.";
    private static final HashMap<String, Product> productMap = new HashMap<>();

    /**
     * 1. 입력
     * 2. (;) 문자 적용 확인
     * 2-1. [] 개수 확인
     * 2-2. ; 개수 비교
     * 3. (;)을 통해 구분한 각 상품 추출
     * 4. 각 상품 (,) 구분
     * 4-1. (,)를 통해 나눠진 배열의 개수가 3개인지 확인
     * 4-2. 가격, 수량이 숫자인지 확인
     * 4-3. 상품이 중복되지 않았는지 확인
     */
    public void insertProduct() {
        System.out.println(PRODUCT_INSERT_MESSAGE);
        String productsInformation = Console.readLine();
//        String productsInformation = "[콜라,1200,10];[콜라,1100,100];[사이다,200,100]";
        initProductMap();
        String[] productInformationList = validateSplitRegex(productsInformation);
        setNumberOfProducts(productInformationList);
//        for (String product : productMap.keySet()) {
//            System.out.println(product + ", " + productMap.get(product).price + ", " + productMap.get(product).amount);
//        }
    }
    private void initProductMap(){
        productMap.clear();
    }
    private void setNumberOfProducts(String[] productInformationList) {
        for (String productInformation : productInformationList) {
            Product product = validateSplitProductInformation(productInformation);
            productMap.put(product.name, product);
        }
    }

    private Product validateSplitProductInformation(String productInformation) {
        productInformation = removeBracketInProduct(productInformation);
        String[] productInformationList = validateProductInfoSplitRegex(productInformation);
        String name = validateDuplicateProductName(productInformationList[0]);
        int price = validatePrice(productInformationList[1]);
        int amount = validateAmount(productInformationList[2]);
        return new Product(name, price, amount);
    }

    private String validateDuplicateProductName(String name) {
        if (productMap.get(name) != null) {
            throw new IllegalArgumentException("상품명은 중복될 수 없습니다.");
        }
        return name;
    }

    private int validatePrice(String price) {
        try {
            int integerPrice = validateOnlyNumber(price);
            validateGreaterThanZero(integerPrice);
            validateMultipleOfTen(integerPrice);
            return integerPrice;
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException("금액이 " + exception.getMessage());
        }
    }

    private int validateAmount(String amount) {
        try {
            int integerAmount = validateOnlyNumber(amount);
            validateGreaterThanZero(integerAmount);
            return integerAmount;
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException("수량이 " + exception.getMessage());
        }
    }

    private void validateMultipleOfTen(int price) {
        if (price % 10 != 0) {
            throw new IllegalArgumentException("1원 단위를 입력할 수 없습니다.");
        }
    }

    private void validateGreaterThanZero(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("1보다 작을 수 없습니다.");
        }
    }

    private int validateOnlyNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }

    }

    private String[] validateProductInfoSplitRegex(String productInformation) {
        String[] splitProductInfo = productInformation.split(",");
        if (splitProductInfo.length != 3) {
            throw new IllegalArgumentException("[상품명,가격,수량]의 형식으로 정확히 입력해주세요.");
        }
        return splitProductInfo;
    }

    private int getCountOfSquareBracket(String productsInformation) {
        int countOfBracketStart = 0;
        int countOfBracketEnd = 0;
        for (String productString : productsInformation.split("")) {
            if (productString.equals("[")) {
                countOfBracketStart++;
            }
            if (productString.equals("]")) {
                countOfBracketEnd++;
            }
        }
        if (countOfBracketStart != countOfBracketEnd) {
            throw new IllegalArgumentException("대괄호 쌍이 맞지않습니다.");
        }
        return countOfBracketStart;
    }

    private int getCountOfSplitRegex(String productsInformation) {
        int countOfSplitRegex = 0;
        for (String productString : productsInformation.split("")) {
            if (productString.equals(";")) {
                countOfSplitRegex++;
            }
        }
        return countOfSplitRegex;
    }

    private String[] validateSplitRegex(String productsInformation) {
        int countOfBracket = getCountOfSquareBracket(productsInformation);
        int countOfSplitRegex = getCountOfSplitRegex(productsInformation);
        if (countOfBracket < 1) {
            throw new IllegalArgumentException("상품이 입력되지 않았습니다.");
        }
        if (countOfBracket > 1 && countOfBracket - 1 != countOfSplitRegex) {
            throw new IllegalArgumentException("상품 구분은 세미콜론(;)을 통해 입력해야합니다.");
        }
        return productsInformation.split(";");
    }


    private String removeBracketInProduct(String productsInformation) {
        return productsInformation.substring(1, productsInformation.length() - 1);
    }
}
