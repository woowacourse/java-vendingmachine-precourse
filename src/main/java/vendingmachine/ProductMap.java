package vendingmachine;

import java.util.HashMap;

public class ProductMap {
    public NumberManager numberManager = new NumberManager();

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

    private static final String PARSER_LIST = ";";
    private static final String PARSER_INFO = ",";

    private static final int PRODUCT_INFO_SIZE = 3;
    private static final int MIN_PRODUCT_SIZE = 8;
    private static final int MIN_NAME_SIZE = 1;

    private static final int INDEX_NAME = 0;
    private static final int INDEX_AMOUNT = 1;
    private static final int INDEX_COUNT = 2;

    public void resetProductMap(){
        productMap.clear();
    }

    public void toProductMap(String productListString) {
        String[] productStrings = productListString.split(PARSER_LIST);
        for (String p : productStrings) {
            parseProductString(p);
        }
    }

    public int sellProduct(String productName){
        ProductInfo soldProductInfo=productMap.get(productName);
        soldProductInfo.count--;
        productMap.put(productName,soldProductInfo);
        return soldProductInfo.amount;
    }

    private void parseProductString(String productString) {
        int INDEX_FIRST = 0;
        int INDEX_LAST = productString.length()-1;

        if (productString.length()<MIN_PRODUCT_SIZE
            || productString.charAt(INDEX_FIRST) != '['
            || productString.charAt(INDEX_LAST) != ']') {
            System.out.println("[ERROR] 상품 입력 형식에 맞게 입력해주세요.");
            throw new IllegalArgumentException();
        }

        String productInfoString = productString.substring(INDEX_FIRST + 1, INDEX_LAST);
        parseProductInfoString(productInfoString);
    }

    private void parseProductInfoString(String productInfoString) {
        String[] productInfoArray = productInfoString.split(PARSER_INFO);

        if (productInfoArray.length != PRODUCT_INFO_SIZE) {
            System.out.println("[ERROR] 상품 입력 형식에 맞게 입력해주세요.");
            throw new IllegalArgumentException();
        }
        addProductToMap(productInfoArray);
    }

    private void addProductToMap(String[] productInfoArray) {
        String name = toName(productInfoArray[INDEX_NAME]);
        int amount = numberManager.toNumber(productInfoArray[INDEX_AMOUNT], numberManager.TYPE_AMOUNT);
        int count = numberManager.toNumber(productInfoArray[INDEX_COUNT], numberManager.TYPE_COUNT);

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

    public boolean isWorkable(int userAmount){
        int minAmount=-1;
        for(ProductInfo p:productMap.values()){
            if(p.count>0 && (minAmount<0 || minAmount>p.amount)){
                minAmount=p.amount;
            }
        }
        if(minAmount<0 || minAmount>userAmount){
            return false;
        }
        return true;
    }

    private static final boolean SELLABLE=true;
    private static final boolean NON_SELLABLE=false;

    public void checkProductExistence(String name){
        if(productMap.containsKey(name)==NON_SELLABLE){
            System.out.println("[ERROR] 존재하는 상품만 입력해주세요.");
            throw new IllegalArgumentException();
        }
    }

    public boolean isSellable(String name,int userAmount){
        if(outOfStock(name) || excessAmount(name,userAmount)){
            return NON_SELLABLE;
        }
        return SELLABLE;
    }

    private boolean outOfStock(String name){
        if(productMap.get(name).count==0){
            System.out.println("해당 상품 재고가 없습니다!");
            return true;
        }
        return false;
    }

    private boolean excessAmount(String name,int userAmount){
        if(productMap.get(name).amount>userAmount){
            System.out.println("금액이 부족합니다!");
            return true;
        }
        return false;
    }
}
