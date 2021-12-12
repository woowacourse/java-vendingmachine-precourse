package vendingmachine;

public class ParsingManager {
    private static final String PARSER_LIST = ";";
    private static final String PARSER_INFO = ",";

    private static final int PRODUCT_INFO_SIZE = 3;
    private static final int MIN_PRODUCT_INFO_SIZE = 8;

    public ParsingManager() {
    }

    public static String[] parseProductList(String productListString) {
        return productListString.split(PARSER_LIST);
    }

    public static String[] parseProductInfo(String productInfoString) {
        checkMinProductInfoSize(productInfoString);

        int INDEX_LAST = productInfoString.length() - 1;
        productInfoString = productInfoString.substring(1, INDEX_LAST);

        String[] productInfoArray = productInfoString.split(PARSER_INFO);
        checkProductInfoArraySize(productInfoArray);

        return productInfoArray;
    }

    private static void checkMinProductInfoSize(String productInfoString) {
        if (productInfoString.length() < MIN_PRODUCT_INFO_SIZE
            || firstCharOf(productInfoString) != '['
            || lastCharOf(productInfoString) != ']') {
            System.out.println("[ERROR] 상품 입력 형식에 맞게 입력해주세요.");
            throw new IllegalArgumentException();
        }
    }

    private static void checkProductInfoArraySize(String[] productInfoArray) {
        if (productInfoArray.length != PRODUCT_INFO_SIZE) {
            System.out.println("[ERROR] 상품 입력 형식에 맞게 입력해주세요.");
            throw new IllegalArgumentException();
        }
    }

    private static char firstCharOf(String string){
        return string.charAt(0);
    }

    private static char lastCharOf(String string){
        return string.charAt(string.length()-1);
    }
}
