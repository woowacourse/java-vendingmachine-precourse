package vendingmachine;

import java.util.HashMap;

public class ProductMap {
    public HashMap<String, ProductInfo> productMap = new HashMap<>();

    private static final int MIN_NAME_SIZE = 1;

    private static final int INDEX_NAME = 0;
    private static final int INDEX_AMOUNT = 1;
    private static final int INDEX_COUNT = 2;

    private static class ProductInfo {
        private final int amount;
        private int count;

        public ProductInfo(int amount, int count) {
            this.amount = amount;
            this.count = count;
        }

        public int trySell(int userAmount) {
            if (isSellable(userAmount)) {
                sell();
                return updateUserAmount(userAmount);
            }
            return userAmount;
        }

        public boolean isSellable(int userAmount) {
            if (outOfStock()) {
                Message.OUT_OF_STOCK.print();
                return false;
            }
            if (excessAmount(userAmount)) {
                Message.EXCESS_AMOUNT.print();
                return false;
            }
            return true;
        }

        public boolean outOfStock() {
            if (count == 0) {
                return true;
            }
            return false;
        }

        public boolean excessAmount(int userAmount) {
            if (amount > userAmount) {
                return true;
            }
            return false;
        }

        public void sell() {
            count--;
        }

        public int updateMinAmount(int minAmount) {
            if (minAmount < 0) {
                return amount;
            }
            return Math.min(amount, minAmount);
        }

        private int updateUserAmount(int userAmount) {
            return userAmount - amount;
        }
    }

    public ProductMap() {
    }

    public void toProductMap(String productListString) {
        resetProductMap();

        String[] productStrings = ParsingManager.parseProductList(productListString);
        for (String productInfoString : productStrings) {
            String[] productInfoArray = ParsingManager.parseProductInfo(productInfoString);
            addProductToMap(productInfoArray);
        }
    }

    public void checkExistence(String name) {
        if (isExisting(name)) {
            return;
        }
        Error.PRODUCT_NON_EXIST.generate();
    }

    public int trySellProduct(String name, int userAmount) {
        ProductInfo targetProduct = productMap.get(name);

        userAmount = targetProduct.trySell(userAmount);
        productMap.put(name, targetProduct);
        return userAmount;
    }

    public boolean isWorkable(int userAmount) {
        int minAmount = getMinAmount(userAmount);
        if (minAmount < 0 || minAmount > userAmount) {
            return false;
        }
        return true;
    }

    private void resetProductMap() {
        productMap.clear();
    }

    private void addProductToMap(String[] productInfoArray) {
        String name = toName(productInfoArray[INDEX_NAME]);
        int amount = NumberManager.toNumber(productInfoArray[INDEX_AMOUNT], NumberManager.TYPE_AMOUNT);
        int count = NumberManager.toNumber(productInfoArray[INDEX_COUNT], NumberManager.TYPE_COUNT);

        ProductInfo info = new ProductInfo(amount, count);
        productMap.put(name, info);
    }

    private String toName(String name) {
        if (isNullString(name)) {
            Error.NULL_STRING_NAME.generate();
        }
        if (isExisting(name)) {
            Error.REDUNDANT_NAME.generate();
        }
        return name;
    }

    private boolean isNullString(String name) {
        if (name.length() < MIN_NAME_SIZE) {
            return true;
        } else return false;
    }

    private boolean isExisting(String name) {
        if (productMap.containsKey(name)) {
            return true;
        }
        return false;
    }

    private int getMinAmount(int userAmount) {
        int minAmount = -1;
        for (ProductInfo p : productMap.values()) {
            if (p.outOfStock() || p.excessAmount(userAmount)) {
                continue;
            }
            minAmount = p.updateMinAmount(minAmount);
        }
        return minAmount;
    }

}
