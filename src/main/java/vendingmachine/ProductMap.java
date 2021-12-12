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

    private static final int MIN_NAME_SIZE = 1;

    private static final int INDEX_NAME = 0;
    private static final int INDEX_AMOUNT = 1;
    private static final int INDEX_COUNT = 2;

    private static final boolean SELLABLE = true;
    private static final boolean NON_SELLABLE = false;

    public void resetProductMap() {
        productMap.clear();
    }

    public void toProductMap(String productListString) {
        String[] productStrings = ParsingManager.parseProductList(productListString);
        for (String productInfoString: productStrings) {
            String[] productInfoArray = ParsingManager.parseProductInfo(productInfoString);
            addProductToMap(productInfoArray);
        }
    }

    public int sellProduct(String productName) {
        ProductInfo soldProductInfo = productMap.get(productName);
        soldProductInfo.count--;
        productMap.put(productName, soldProductInfo);
        return soldProductInfo.amount;
    }

    private void addProductToMap(String[] productInfoArray) {
        String name = toName(productInfoArray[INDEX_NAME]);
        int amount = NumberManager.toNumber(productInfoArray[INDEX_AMOUNT], NumberManager.TYPE_AMOUNT);
        int count = NumberManager.toNumber(productInfoArray[INDEX_COUNT], NumberManager.TYPE_COUNT);

        ProductInfo info = new ProductInfo(amount, count);
        productMap.put(name, info);
    }

    private String toName(String name) {
        if (name.length() < MIN_NAME_SIZE) {
            System.out.println("[ERROR] 상품 이름은 한 글자 이상으로 입력해주세요.");
            throw new IllegalArgumentException();
        }
        if (productMap.containsKey(name)) {
            System.out.println("[ERROR] 상품 이름은 모두 다르게 입력해주세요.");
            throw new IllegalArgumentException();
        }
        return name;
    }

    public boolean isWorkable(int userAmount) {
        int minAmount = -1;
        for (ProductInfo p : productMap.values()) {
            if (p.count > 0 && (minAmount < 0 || minAmount > p.amount)) {
                minAmount = p.amount;
            }
        }
        if (minAmount < 0 || minAmount > userAmount) {
            return false;
        }
        return true;
    }

    public void checkProductExistence(String name) {
        if (productMap.containsKey(name) == NON_SELLABLE) {
            System.out.println("[ERROR] 존재하는 상품만 입력해주세요.");
            throw new IllegalArgumentException();
        }
    }

    public boolean isSellable(String name, int userAmount) {
        if (outOfStock(name) || excessAmount(name, userAmount)) {
            return NON_SELLABLE;
        }
        return SELLABLE;
    }

    private boolean outOfStock(String name) {
        if (productMap.get(name).count == 0) {
            System.out.println("해당 상품 재고가 없습니다!");
            return true;
        }
        return false;
    }

    private boolean excessAmount(String name, int userAmount) {
        if (productMap.get(name).amount > userAmount) {
            System.out.println("금액이 부족합니다!");
            return true;
        }
        return false;
    }
}
