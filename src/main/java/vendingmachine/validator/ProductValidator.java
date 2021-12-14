package vendingmachine.validator;

import vendingmachine.model.Product;
import vendingmachine.model.ProductTable;

/*
용어의미:
Product = 상품
ProductInfoList = 여러개의 상품정보가 포함된 문자열 ex
ProductInfo = 문자열로 표현된 상품정보  ex) "[name,1000,0]"
ProductData = 문자열배열로 표현된 상품정보 ex)  {"name", "1000", "0"}
 */

public class ProductValidator {
    public static final String PRODUCT_LIST_SPLITTER = ";";
    public static final String PRODUCT_DATA_SPLITTER = ",";
    public static final char PRODUCT_INFO_BEGIN = '[';
    public static final char PRODUCT_INFO_END = ']';
    public static final int PRODUCT_DATA_SIZE = 3;
    public static final int PRICE_MINIMUM = 100;
    public static final int PRICE_UNIT = 10;
    public static final int PRODUCT_NAME_MINIMUM = 1;
    public static final int PRODUCT_NAME_MAXIMUM = 30;
    public static final int NAME = 0;
    public static final int PRICE = 1;
    public static final int STOCK = 2;

    public int checkPrice(int money) {
        if (money % PRICE_UNIT != 0 || money < PRICE_MINIMUM) {
            throwIllegalArgumentException("상품의 가격은 최소 100, 10단위 이어야합니다.");
        }
        return money;
    }

    public int checkStock(int stock) {
        if (stock < 0) {
            throwIllegalArgumentException("수량은 양수이어야 합니다.");
        }
        return stock;
    }

    public String checkName(String name) {
        if (name.length() > PRODUCT_NAME_MAXIMUM || name.length() < PRODUCT_NAME_MINIMUM) {
            throwIllegalArgumentException("상품명은 1자이상 30자이하여야 합니다.");
        }
        if (name.contains(PRODUCT_DATA_SPLITTER) || name.contains(PRODUCT_LIST_SPLITTER)) {
            throwIllegalArgumentException("상품명에는 ','나 ';'는 불가합니다.");
        }
        return name;
    }

    public ProductTable checkStringOfProductTable(String input) {
        String[] productList = input.split(PRODUCT_LIST_SPLITTER);
        ProductTable productTable = new ProductTable();

        for (String productInfo : productList) {
            String[] productData = productInfo.split(PRODUCT_DATA_SPLITTER);
            Product product = convertProductInfoIntoProduct(productData);
            productTable.addProduct(product);
        }
        return productTable;
    }

    private Product convertProductInfoIntoProduct(String[] productData) {
        checkProductDataSize(productData);
        removeCover(productData);

        ConsoleValidator consoleValidator = new ConsoleValidator();
        int price = consoleValidator.checkNumeric(productData[PRICE]);
        int stock = consoleValidator.checkNumeric(productData[STOCK]);
        return new Product(productData[NAME], price, stock);
    }

    private void removeCover(String[] productData) {
        checkProductDataSize(productData);
        productData[NAME] = checkAndRemoveCoverBegin(productData[NAME]);
        productData[STOCK] = checkAndRemoveCoverEnd(productData[STOCK]);
    }

    private String checkAndRemoveCoverBegin(String productName) {
        int coverBegin = productName.indexOf(PRODUCT_INFO_BEGIN);
        if (coverBegin == -1) {
            throwIllegalArgumentException("상품정보는 '"+PRODUCT_INFO_BEGIN+"'로 시작해야 합니다.");
        }
        return productName.substring(coverBegin + 1);
    }

    private String checkAndRemoveCoverEnd(String productName) {
        int coverEnd = productName.indexOf(PRODUCT_INFO_END);
        if (coverEnd == -1) {
            throwIllegalArgumentException("상품정보는 '"+PRODUCT_INFO_END+"'로 끝나야 합니다.");
        }
        return productName.substring(0, coverEnd);
    }

    private void checkProductDataSize(String[] productData) {
        if (productData.length != PRODUCT_DATA_SIZE) {
            throwIllegalArgumentException("상품정보는 '"+ PRODUCT_DATA_SPLITTER+"'로 구분되어야 합니다.");
        }
    }

    private void throwIllegalArgumentException(String errorMessage) {
        throw new IllegalArgumentException(errorMessage);
    }
}
