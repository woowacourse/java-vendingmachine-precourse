package vendingmachine;

import java.util.HashMap;

import camp.nextstep.edu.missionutils.Console;

public class ProductList {
    private static final String PRODUCT_INSERT_MESSAGE = "상품명과 가격, 수량을 입력해주세요.";
    private static final String ERROR_MESSAGE_PRICE_PREFIX = "상품 가격이 ";
    private static final String ERROR_MESSAGE_AMOUNT_PREFIX = "수량이 ";
    private static final String ERROR_NOT_DUPLICATE = "상품명은 중복될 수 없습니다.";
    private static final String ERROR_LOWER_THAN_ZERO = "1보다 작을 수 없습니다.";
    private static final String ERROR_LOWER_THAN_HUNDRED = "100보다 작을 수 없습니다.";
    private static final String ERROR_ONLY_NUMBER = "숫자만 입력할 수 있습니다.";
    private static final String ERROR_PERMIT_ONLY_RULE = "[상품명,가격,수량]의 형식으로 정확히 입력해주세요.";
    private static final String ERROR_NOT_ALLOW_UNITS = "1원 단위를 입력할 수 없습니다.";
    private static final String ERROR_ONLY_ALLOW_SEMICOLON = "상품 구분은 세미콜론(;)을 통해 입력해야합니다.";
    private static final String ERROR_NOT_INSERTED_PRODUCT = "상품이 입력되지 않았습니다.";
    private static final String ERROR_NOT_PAIR_OF_BRACKET = "대괄호 쌍이 맞지않습니다.";
    private static final String BRACKET_START = "[";
    private static final String BRACKET_END = "]";
    private static final String PRODUCT_SPLIT_REGEX = ";";
    private static final String PRODUCT_INFO_SPLIT_REGEX = ",";
    private static final int TENS = 10;
    private static final int HUNDRED = 100;
    private static int MINIMUM_PRICE = Integer.MAX_VALUE;
    private static final HashMap<String, Product> productMap = new HashMap<>();

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

    public boolean checkAvailableState(int customerMoney) {
        return checkProductAmount() && checkAvailableBuyProduct(customerMoney);
    }
    private boolean checkAvailableBuyProduct(int customerMoney){
        return customerMoney > MINIMUM_PRICE;
    }
    private boolean checkProductAmount(){
        for(String name : productMap.keySet()){
            Product product = productMap.get(name);
            if(product.isAvailable()){
                return true;
            }
        }
        return false;
    }

    public int sellProduct(String product) {
        Product sellProduct = productMap.get(product);
        sellProduct.sell();
        return sellProduct.price;
    }

    private void initProductMap() {
        productMap.clear();
    }

    private void setNumberOfProducts(String[] productInformationList) {
        for (String productInformation : productInformationList) {
            Product product = validateSplitProductInformation(productInformation);
            compareMinimumPrice(product);
            productMap.put(product.name, product);
        }
    }

    private void compareMinimumPrice(Product product) {
        if (MINIMUM_PRICE > product.price) {
            MINIMUM_PRICE = product.price;
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
            throw new IllegalArgumentException(ERROR_NOT_DUPLICATE);
        }
        return name;
    }

    private int validatePrice(String price) {
        try {
            int integerPrice = validateOnlyNumber(price);
            validatePriceGreaterThanHundred(integerPrice);
            validateMultipleOfTen(integerPrice);
            return integerPrice;
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException(ERROR_MESSAGE_PRICE_PREFIX + exception.getMessage());
        }
    }

    private int validateAmount(String amount) {
        try {
            int integerAmount = validateOnlyNumber(amount);
            validateGreaterThanZero(integerAmount);
            return integerAmount;
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException(ERROR_MESSAGE_AMOUNT_PREFIX + exception.getMessage());
        }
    }

    private void validateMultipleOfTen(int price) {
        if (price % TENS != 0) {
            throw new IllegalArgumentException(ERROR_NOT_ALLOW_UNITS);
        }
    }

    private void validateGreaterThanZero(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(ERROR_LOWER_THAN_ZERO);
        }
    }

    private void validatePriceGreaterThanHundred(int price) {
        if (price < HUNDRED) {
            throw new IllegalArgumentException(ERROR_LOWER_THAN_HUNDRED);
        }
    }

    private int validateOnlyNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ERROR_ONLY_NUMBER);
        }

    }

    private String[] validateProductInfoSplitRegex(String productInformation) {
        String[] splitProductInfo = productInformation.split(PRODUCT_INFO_SPLIT_REGEX);
        if (splitProductInfo.length != 3) {
            throw new IllegalArgumentException(ERROR_PERMIT_ONLY_RULE);
        }
        return splitProductInfo;
    }

    private int getCountOfSquareBracket(String productsInformation) {
        int countOfBracketStart = 0;
        int countOfBracketEnd = 0;
        for (String productString : productsInformation.split("")) {
            if (productString.equals(BRACKET_START)) {
                countOfBracketStart++;
            }
            if (productString.equals(BRACKET_END)) {
                countOfBracketEnd++;
            }
        }
        if (countOfBracketStart != countOfBracketEnd) {
            throw new IllegalArgumentException(ERROR_NOT_PAIR_OF_BRACKET);
        }
        return countOfBracketStart;
    }

    private int getCountOfSplitRegex(String productsInformation) {
        int countOfSplitRegex = 0;
        for (String productString : productsInformation.split("")) {
            if (productString.equals(PRODUCT_SPLIT_REGEX)) {
                countOfSplitRegex++;
            }
        }
        return countOfSplitRegex;
    }

    private String[] validateSplitRegex(String productsInformation) {
        int countOfBracket = getCountOfSquareBracket(productsInformation);
        int countOfSplitRegex = getCountOfSplitRegex(productsInformation);
        if (countOfBracket < 1) {
            throw new IllegalArgumentException(ERROR_NOT_INSERTED_PRODUCT);
        }
        if (countOfBracket > 1 && countOfBracket - 1 != countOfSplitRegex) {
            throw new IllegalArgumentException(ERROR_ONLY_ALLOW_SEMICOLON);
        }
        return productsInformation.split(PRODUCT_SPLIT_REGEX);
    }

    private String removeBracketInProduct(String productsInformation) {
        return productsInformation.substring(1, productsInformation.length() - 1);
    }
}
