package vendingmachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Assistant {

    private static final String NOT_INTEGER_ERROR_MESSAGE = "알맞은 숫자를 입력해주세요.";
    private static final String PRODUCT_SIZE_ZERO_ERROR_MESSAGE = "상품은 하나 이상 등록해야 합니다.";
    private static final String DUPLICATED_NAME_ERROR_MESSAGE = "중복은 불가능 합니다.";
    private static final String PRICE_MIN_ERROR_MESSAGE = "상품 가격은 100원 이상이어야 합니다.";
    private static final String PRICE_NOT_TEN_MULTIPLE_ERROR_MESSAGE = "금액은 10으로 나누어 떨어져야 합니다.";
    private static final String NEGATIVE_NUMBER_ERROR_MESSAGE = "금액과 수량은 0 이상이어야 합니다.";
    private static final String PRODUCT_FORMAT_ERROR_MESSAGE = "상품 형식이 맞지 않습니다.";
    private static final String PRODUCT_INFO_SIZE_ERROR_MESSAGE = "상품 정보는 3개로 이루어져야 합니다.";
    private static final String NOT_FOUND_COIN = "동전을 찾을 수 없습니다.";
    private static final String NOT_FOUND_PRODUCT = "상품을 찾을 수 없습니다.";
    private static final int ZERO = 0;

    public Integer convertToInteger(String rawProduct) {
        try {
            return Integer.parseInt(rawProduct);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER_ERROR_MESSAGE);
        }
    }

    public void checkMoney(int asset) {
        isTenMultiple(asset);
        isNegativeNumber(asset);
    }

    public Coin findCoin(int randomCoin) {
        return Arrays.stream(Coin.values()).filter(coin -> coin.matchAmount(randomCoin)).findFirst()
            .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_COIN));
    }

    public List<Product> collectProducts(String inputProduct) {
        String[] rawProducts = inputProduct.split(";");
        checkProductsSize(rawProducts);
        List<Product> products = new ArrayList<>();
        for (String rawProduct : rawProducts) {
            checkProductFormat(rawProduct);
            rawProduct = removeSquareBrackets(rawProduct);
            String[] rawProductInformation = rawProduct.split(",");
            Product product = makeProduct(rawProductInformation, products);
            products.add(product);
        }
        return products;
    }

    private void isTenMultiple(Integer price) {
        if ((price % 10) != 0) {
            throw new IllegalArgumentException(PRICE_NOT_TEN_MULTIPLE_ERROR_MESSAGE);
        }
    }

    private void isNegativeNumber(Integer number) {
        if (number < 0) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_ERROR_MESSAGE);
        }
    }

    private void checkProductsSize(String[] sliceProductInformation) {
        if (sliceProductInformation.length == ZERO) {
            throw new IllegalArgumentException(PRODUCT_SIZE_ZERO_ERROR_MESSAGE);
        }
    }

    private void checkProductFormat(String rawProduct) {
        if (rawProduct.length() == 0) {
            throw new IllegalArgumentException(PRODUCT_SIZE_ZERO_ERROR_MESSAGE);
        }
        if (isNotSquareBracketFormat(rawProduct)) {
            throw new IllegalArgumentException(PRODUCT_FORMAT_ERROR_MESSAGE);
        }
    }

    private boolean isNotSquareBracketFormat(String rawProduct) {
        return rawProduct.charAt(0) != '[' || rawProduct.charAt(lastChar(rawProduct)) != ']';
    }

    private int lastChar(String rawProduct) {
        return rawProduct.length() - 1;
    }

    private String removeSquareBrackets(String rawProduct) {
        return rawProduct.substring(1, lastChar(rawProduct));
    }

    private Product makeProduct(String[] rawProductInformation, List<Product> products) {
        checkEachProductSize(rawProductInformation);
        String productName = rawProductInformation[0].trim();
        Integer productPrice = convertToInteger(rawProductInformation[1]);
        Integer productQuantity = convertToInteger(rawProductInformation[2]);
        checkDuplicatedProductName(productName, products);
        checkPrice(productPrice);
        checkQuantity(productQuantity);
        return new Product(productName, productPrice, productQuantity);
    }

    private void checkEachProductSize(String[] rawProductInformation) {
        if (rawProductInformation.length != 3) {
            throw new IllegalArgumentException(PRODUCT_INFO_SIZE_ERROR_MESSAGE);
        }
    }

    private void checkQuantity(Integer productQuantity) {
        isNegativeNumber(productQuantity);
    }

    private void checkPrice(Integer productPrice) {
        if (productPrice < 100) {
            throw new IllegalArgumentException(PRICE_MIN_ERROR_MESSAGE);
        }
        isTenMultiple(productPrice);
        isNegativeNumber(productPrice);
    }

    private void checkDuplicatedProductName(String productName, List<Product> products) {
        boolean isDuplicated = products.stream().anyMatch(product -> product.matchProductName(productName));
        if (isDuplicated) {
            throw new IllegalArgumentException(DUPLICATED_NAME_ERROR_MESSAGE);
        }
    }

    public Product findWantedProduct(List<Product> products, String wantedProduct) {
        return products.stream().filter(product -> product.matchProductName(wantedProduct)).findFirst()
            .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_PRODUCT));
    }
}
