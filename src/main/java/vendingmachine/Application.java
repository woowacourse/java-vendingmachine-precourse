package vendingmachine;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.regex.Pattern;

import static vendingmachine.Validation.*;
import static vendingmachine.VendingMachine.startVendingMachine;

public class Application {
    static int USER_MONEY = 0;
    static int MACHINE_OWN_MONEY = 0;
    static int PRODUCT_NAME = 0;
    static int PRODUCT_PRICE = 1;
    static int PRODUCT_AMOUNT = 2;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        MACHINE_OWN_MONEY = inputMachineOwnMoney();
        setRandomCountToEachCoin();
        printCurrentMachineCoin();
        ArrayList<Product> products = inputProductNamePriceAmount();
        insertMoneyByUser();
        startVendingMachine(products);
    }


    public static Product findPurchaseProduct(ArrayList<Product> products, String purchaseProductName){
        Product purchaseProductObject= null;
        for(Product product: products){
            if(product.getName().equals(purchaseProductName)){
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

    public static void printCurrentMachineCoin(){
        System.out.println("자판기가 보유한 동전");
        Coin[] eachCoin = Coin.values();
        for(Coin c: eachCoin){
            System.out.println(c.getAmount()+"원 - " + c.getCount()+"개");
        }
    }

    public static void setRandomCountToEachCoin(){
        int tempMachineOwnMoney = MACHINE_OWN_MONEY;
        int selectedCoin;

        while(tempMachineOwnMoney != 0) {
            selectedCoin = Randoms.pickNumberInList(Coin.getCoinList());
            if(tempMachineOwnMoney / selectedCoin > 0){
                Coin.valueOf("COIN_" + selectedCoin).addCount();
                tempMachineOwnMoney -= selectedCoin;
            }
        }
    }

    public static int inputMachineOwnMoney(){
        String machineOwnMoney = "";
        while(machineOwnMoney.isEmpty()) {
            try {
                machineOwnMoney = inputMachineOwnMoneyAndValidation();
            } catch (IllegalArgumentException e){
                System.out.println("[ERROR] 금액은 숫자여야 합니다.");
            }
        }
        return Integer.parseInt(machineOwnMoney);
    }

    public static String inputMachineOwnMoneyAndValidation(){
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        String machineOwnMoney = Console.readLine();
        String regex = "^[0-9]{2,}$";
            if (!Pattern.matches(regex, machineOwnMoney)) throw new IllegalArgumentException();
        return machineOwnMoney;
    }
}
