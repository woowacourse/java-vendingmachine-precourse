package vendingmachine.utils.productchecker;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.constants.StringConstants;
import vendingmachine.servicesource.Product;
import vendingmachine.utils.datatypechecker.StringChecker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InputChecker {
    static final int MIN_PRODUCT_DATA_LENGTH = 4;
    static final int PRODUCT_CONTENTS_NUMBER = 3;
    static final int PRODUCT_NAME_INDEX = 0;
    static final int PRODUCT_PRICE_INDEX = 1;
    static final int PRODUCT_STOCK_INDEX = 2;

    static final char CONTENT_SEPARATOR = ',';
    static final char PRODUCT_SEPARATOR = ';';
    static final char PRODUCT_BIND_FORM_FRONT = '[';
    static final char PRODUCT_BIND_FORM_BACK = ']';

    //Message
    static final String PRODUCT_INPUT_REQUEST = "상품명과 가격, 수량을 입력해 주세요.";
    static final String TOO_SHORT_PRODUCT_DATA = "상품 정보의 길이가 너무 짧습니다.";
    static final String PRODUCT_DATA_NOT_BOUND = "상품의 정보가 대괄호로 묶여있지 않습니다.";
    static final String CONTENT_NUMBER_ERROR = "상품 정보는 상품명과 가격, 수량으로 3가지만 입력해주세요.";

    public static HashMap<Product, Integer> getProductStockHashMap(){
        HashMap<Product, Integer> productStockMap = new HashMap<>();
        List<String> products = getRightProductInput();

        for(String productData : products){
            List<String> parsedProductData = StringChecker.parseStringBySeparator(productData.substring(1,productData.length()-1), CONTENT_SEPARATOR);
            String productName = parsedProductData.get(PRODUCT_NAME_INDEX);
            int productPrice = Integer.parseInt(parsedProductData.get(PRODUCT_PRICE_INDEX));
            int productStock = Integer.parseInt(parsedProductData.get(PRODUCT_STOCK_INDEX));

            productStockMap.put(new Product(productName, productPrice), productStock);
        }

        return productStockMap;
    }
    
    private static List<String> getRightProductInput(){
        List<String> products;

        do{
            System.out.println(PRODUCT_INPUT_REQUEST);
            products = StringChecker.parseStringBySeparator(Console.readLine(), PRODUCT_SEPARATOR);
        }while(!IsRightProductsForm(products) || haveSameProductInput(products));

        return products;
    }

    private static boolean IsRightProductsForm(List<String> products){

        for(String productData : products){

            if(!checkProductDataForm(productData)){
                return false;
            }

        }

        return true;
    }

    private static boolean checkProductDataForm(String productData){
        boolean isRightData = true;

        try{
            checkProductDataLength(productData);
            checkBindForm(productData);
            checkProductContents(productData.substring(1,productData.length()-1));  //대괄호를 때어낸 문자열 전달
        }catch (IllegalArgumentException exception){
            isRightData = false;
            System.out.println(exception.getMessage());
        }

        return isRightData;
    }

    private static void checkProductDataLength(String productData) throws IllegalArgumentException{

        if(productData.length() <= MIN_PRODUCT_DATA_LENGTH){
            throw new IllegalArgumentException(StringConstants.ERROR_MESSAGE_PREFIX + TOO_SHORT_PRODUCT_DATA);
        }

    }

    private static void checkBindForm(String productData) throws IllegalArgumentException{

        if(productData.charAt(0) != PRODUCT_BIND_FORM_FRONT || productData.charAt(productData.length() -1) != PRODUCT_BIND_FORM_BACK){
            throw new IllegalArgumentException(StringConstants.ERROR_MESSAGE_PREFIX + PRODUCT_DATA_NOT_BOUND);
        }

    }

    private static void checkProductContents(String productData) throws IllegalArgumentException{
        List<String> parsedProductData = StringChecker.parseStringBySeparator(productData, ',');

        if(parsedProductData.size() != PRODUCT_CONTENTS_NUMBER ){
            throw new IllegalArgumentException(StringConstants.ERROR_MESSAGE_PREFIX + CONTENT_NUMBER_ERROR);
        }

        NameChecker.checkName(parsedProductData.get(0));
        PriceChecker.checkPrice(parsedProductData.get(1));
        QuantityChecker.checkQuantity(parsedProductData.get(2));
    }

    private static List<String> getSpecificContents(List<String> products, int contentsIndex){
        List<String> contents = new ArrayList<>();

        for (String productData : products){
            List<String> parsedProductData = StringChecker.parseStringBySeparator(productData.substring(1,productData.length()-1), CONTENT_SEPARATOR);
            contents.add(parsedProductData.get(contentsIndex));
        }

        return contents;
    }

    private static boolean haveSameProductInput(List<String> products){
        boolean haveSameProduct = false;

        try{
            NameChecker.checkSameName(getSpecificContents(products, PRODUCT_NAME_INDEX));
        }catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
            haveSameProduct = true;
        }

        return haveSameProduct;
    }

    public static boolean isRightNameInput(String input){
        boolean isRight = true;

        try{
            NameChecker.checkName(input);
        }catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
            isRight = false;
        }

        return isRight;
    }
}