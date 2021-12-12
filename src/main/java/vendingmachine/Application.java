package vendingmachine;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.regex.Pattern;

import static vendingmachine.Validation.*;

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

    public static HashMap<Integer, Integer> startVendingMachine(ArrayList<Product> products){
        while(isUserMoneyAndMachineInventoryEnough(products)){
            try {
                purchaseProduct(products);
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        return changesBack();
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

    public static void purchaseProduct(ArrayList<Product> products) throws IllegalArgumentException {
        System.out.println("구매할 상품명을 입력해 주세요.");
        String purchaseProductName = Console.readLine();
        Product purchaseProductObject = findPurchaseProduct(products, purchaseProductName);
        productNotFound(purchaseProductObject);
        productAmountNotEnough(purchaseProductObject);
        userMoneyNotEnough(purchaseProductObject);
        purchaseSuccess(purchaseProductObject);
    }

    public static void purchaseSuccess(Product product){
        product.sold();
        USER_MONEY -= product.getPrice();
    }

    public static HashMap<Integer, Integer> changesBack(){
        HashMap<Integer, Integer> changes = new HashMap<>();
        Coin[] eachCoin = Coin.values();
        for(Coin c: eachCoin){
            findChanges(c, changes);
        }
        printChanges(changes);
        return changes;
    }

    public static void printChanges(HashMap<Integer, Integer> changes){
        List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(changes.entrySet());
        entryList.sort((o1, o2) -> o2.getKey() - o1.getKey());
        System.out.println("잔");
        for(Map.Entry<Integer, Integer> entry : entryList){
            if(entry.getValue() != 0){
                System.out.println(entry.getKey() + "원 - " + entry.getValue() + "개");
            }
        }
    }

    public static void findChanges(Coin coin, HashMap<Integer, Integer> changes){
        if(coin.getAmount() < USER_MONEY && coin.getCount() > 0 && USER_MONEY >= 10){
            int coinCount = USER_MONEY / coin.getAmount();
            if(USER_MONEY / coin.getAmount() > coin.getCount()){
                coinCount = coin.getCount();
            }
            changes.put(coin.getAmount(), coinCount);
            USER_MONEY -= coinCount * coin.getAmount();
        }
    }



    public static void insertMoneyByUser(){
        String userMoney = "";
        while(userMoney.isEmpty()){
            try{
                userMoney = userMoneyValidation();
                USER_MONEY = Integer.parseInt(userMoney);
            }catch (IllegalArgumentException e){
                System.out.println("[ERROR] 금액은 숫자여야 합니다.");
            }
        }
    }

    public static String userMoneyValidation(){
        System.out.println("투입 금액을 입력해 주세요.");
        String userMoney = Console.readLine();
        String regex = "^[0-9]*$";
        if (!Pattern.matches(regex, userMoney)) throw new IllegalArgumentException();
        return userMoney;
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
