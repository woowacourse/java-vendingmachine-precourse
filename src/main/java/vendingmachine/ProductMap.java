package vendingmachine;

import java.util.HashMap;

public class ProductMap {
    public HashMap<String, ProductInfo> productMap = new HashMap<>();

    public static class ProductInfo {
        public int amount;
        public int count;

        public ProductInfo(int amount, int count) {
            this.amount = amount;
            this.count = count;
        }
    }

    public ProductMap() {
    }

    private static final String firstParser = ";";
    private static final String secondParser = ",";

    private static final boolean ERROR = true;
    private static final boolean NON_ERROR = false;

    private static final int PRODUCT_INFO_SIZE = 3;
    private static final int MIN_NAME_SIZE = 1;
    private static final int INDEX_NAME = 0;
    private static final int INDEX_AMOUNT = 1;
    private static final int INDEX_COUNT = 2;
    private static final int NUMBER_ERROR_VALUE = -1;
    private static final int AMOUNT_UNIT = 10;

    public void toProductMap(String productListString) {
        String[] productStrings = productListString.split(firstParser);
        for (String p : productStrings) {
            try {
                parseProductString(p);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void parseProductString(String productString) {
        int productStringLength = productString.length();

        if (productString.charAt(0) != '[' || productString.charAt(productStringLength) != ']') {
            throw new IllegalArgumentException();
        }
        try {
            String productInfoString = productString.substring(1, productStringLength - 1);
            parseProductInfoString(productInfoString);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    private void parseProductInfoString(String productInfoString) {
        String[] productInfoArray = productInfoString.split(secondParser);

        if (productInfoArray.length != PRODUCT_INFO_SIZE) {
            throw new IllegalArgumentException();
        }

        try {
            addProductToMap(productInfoArray);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    private void addProductToMap(String[] productInfoArray) {
        String name = productInfoArray[INDEX_NAME];
        int amount = getAmount(productInfoArray[INDEX_AMOUNT]);
        int count = getCount(productInfoArray[INDEX_COUNT]);

        if (isProductError(name, amount, count)) {
            throw new IllegalArgumentException();
        }
        ProductInfo info = new ProductInfo(amount, count);
        productMap.put(name, info);
    }

    private int getAmount(String amountString) {
        int amount;
        try {
            amount = Integer.parseInt(amountString);
            return amount;
        } catch (NumberFormatException e) {
            return NUMBER_ERROR_VALUE;
        }
    }

    private int getCount(String countString) {
        int count;
        try {
            count = Integer.parseInt(countString);
            return count;
        } catch (NumberFormatException e) {
            return NUMBER_ERROR_VALUE;
        }
    }

    private boolean isProductError(String name, int amount, int count) {
        if (name.length() < MIN_NAME_SIZE || productMap.containsKey(name)) {
            return ERROR;
        }
        if (amount < 0 || amount % AMOUNT_UNIT > 0) {
            return ERROR;
        }
        if (count < 0) {
            return ERROR;
        }
        return NON_ERROR;
    }
}
