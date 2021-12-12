package vendingmachine;

import java.util.HashMap;

public class ProductMap {

    public HashMap<String, ProductInfo> productMap = new HashMap<>();

    private static class ProductInfo {
        public int amount;
        public int count;

        public ProductInfo(int amount, int count) {
            this.amount = amount;
            this.count = count;
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
            if(minAmount<0){
                return amount;
            }
            return Math.min(amount, minAmount);
        }
    }

    public ProductMap() {
    }

    private static final int MIN_NAME_SIZE = 1;

    private static final int INDEX_NAME = 0;
    private static final int INDEX_AMOUNT = 1;
    private static final int INDEX_COUNT = 2;

    private static final boolean SELLABLE = true;
    private static final boolean NON_SELLABLE = false;

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

    public boolean isSellable(String name, int userAmount) {
        ProductInfo targetProduct = productMap.get(name);

        if (targetProduct.outOfStock()) {
            System.out.println("해당 상품 재고가 없습니다!");
            return NON_SELLABLE;
        }
        if (targetProduct.excessAmount(userAmount)) {
            System.out.println("금액이 부족합니다!");
            return NON_SELLABLE;
        }
        return SELLABLE;
    }

    public int sellProduct(String productName) {
        ProductInfo targetProduct = productMap.get(productName);
        targetProduct.sell();
        productMap.put(productName, targetProduct);
        return targetProduct.amount;
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
            System.out.println("[ERROR] 상품 이름은 한 글자 이상으로 입력해주세요.");
            throw new IllegalArgumentException();
        }
        if (isExisting(name)) {
            System.out.println("[ERROR] 상품 이름은 모두 다르게 입력해주세요.");
            throw new IllegalArgumentException();
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

    private int getMinAmount(int userAmount){
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
