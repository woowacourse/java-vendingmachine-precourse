package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Product {
    private final String name;
    private final int price;
    private int amount;

    public Product(String name, int price, int amount){
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public void sold(){
        this.amount--;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }


    public static Product findPurchaseProduct(ArrayList<Product> products, String purchaseProductName) {
        Product purchaseProductObject = null;
        for (Product product : products) {
            if (product.getName().equals(purchaseProductName)) {
                purchaseProductObject = product;
                break;
            }
        }
        return purchaseProductObject;
    }

    public static ArrayList<Product> createProduct(ArrayList<String> products){
        ArrayList<Product> productList = new ArrayList<>();
        for(int i = 0; i < products.size()-2; i+=3){
            productList.add(new Product(products.get(i+PRODUCT_NAME), Integer.parseInt(products.get(i+PRODUCT_PRICE)), Integer.parseInt(products.get(i+PRODUCT_AMOUNT))));
        }
        return productList;
    }

    public static ArrayList<Product> inputProductNamePriceAmount(){
        ArrayList<String> products = new ArrayList<>();
        ArrayList<Product> productList = new ArrayList<>();
        while(products.isEmpty()) {
            try {
                products = inputProductValidation();
                productList = createProduct(products);
            } catch (IllegalArgumentException e){
                System.out.println("[ERROR] 가격과 수량은 숫자여야 합니다.");
            }
        }
        return productList;
    }

    public static ArrayList<String> inputProductValidation(){
        String regex = "^[0-9]*$";
        String regexLength = "^[0-9]{2,}$";
        ArrayList<String> products = new ArrayList<>();
        System.out.println("상품명과 가격, 수량을 입력해 주세요.");
        String product = Console.readLine();    // 상품명은 한글, 영어, 숫자, 특수문자 모두 가능하다. (ex. 비타500, 토레타!, 2%)
        for(String oneProduct: product.split(";")){
            String[] productForValidation = oneProduct.substring(1, oneProduct.length()-1).split(",");
            if (!Pattern.matches(regex, productForValidation[PRODUCT_PRICE])) throw new IllegalArgumentException();
            if (!Pattern.matches(regex, productForValidation[PRODUCT_AMOUNT])) throw new IllegalArgumentException();
            if (!Pattern.matches(regexLength, productForValidation[PRODUCT_PRICE])) throw new IllegalArgumentException();
            products.add(productForValidation[PRODUCT_NAME]);
            products.add(productForValidation[PRODUCT_PRICE]);
            products.add(productForValidation[PRODUCT_AMOUNT]);
        }
        return products;
    }

}
