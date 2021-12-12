package vendingmachine.utils.productchecker;

import camp.nextstep.edu.missionutils.Console;
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

    public static HashMap<Product, Integer> getProductHashMap(){
        HashMap<Product, Integer> productStockMap = new HashMap<>();
        List<String> products = getRightProductInput();

        for(String productData : products){
            List<String> parsedProductData = StringChecker.parseStringBySeparator(productData.substring(1,productData.length()-1), ',');
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
            System.out.println("상품명과 가격, 수량을 입력해 주세요.");
            products = StringChecker.parseStringBySeparator(Console.readLine(), ';');
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
            throw new IllegalArgumentException("[ERROR]: 상품 정보의 길이가 너무 짧습니다.");
        }

    }

    private static void checkBindForm(String productData) throws IllegalArgumentException{

        if(productData.charAt(0) != '[' || productData.charAt(productData.length() -1) != ']'){
            throw new IllegalArgumentException("[ERROR]: 상품의 정보가 대괄호로 묶여있지 않습니다.");
        }

    }

    private static void checkProductContents(String productData) throws IllegalArgumentException{
        List<String> parsedProductData = StringChecker.parseStringBySeparator(productData, ',');

        if(parsedProductData.size() != PRODUCT_CONTENTS_NUMBER ){
            throw new IllegalArgumentException("[ERROR]: 상품 정보는 상품명과 가격, 수량으로 3가지만 입력해주세요.");
        }

        NameChecker.checkName(parsedProductData.get(0));
        PriceChecker.checkPrice(parsedProductData.get(1));
        StockChecker.checkStock(parsedProductData.get(2));
    }

    private static List<String> getSpecificContents(List<String> products, int contentsIndex){
        List<String> contents = new ArrayList<>();

        for (String productData : products){
            List<String> parsedProductData = StringChecker.parseStringBySeparator(productData.substring(1,productData.length()-1), ',');
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
}