package vendingmachine;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashMap;

public class User {
    private String input;
    private String ERROR_MESSAGE;
    private int machineBalance;
    private int userAmount;
    private int price;
    private int quantity;
    private int allInventory = 0;
    private int minProduct = 999999999;
    ArrayList<String> goods = new ArrayList<>();
    HashMap<String, Integer> productPrices = new HashMap<>();
    HashMap<String, Integer> productQuantities = new HashMap<>();

    public boolean inputMachineBalance() {
        try {
            input();
            checkCorrectBalance();
        } catch (Exception e){
            System.out.println(ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    private void input() {
        input = String.valueOf(Console.readLine());
    }
    private void checkCorrectBalance() throws IllegalArgumentException{
        checkBlank(input);
        checkCharacter(input);
        machineBalance = Integer.parseInt(input);
        checkNegativeNumber(machineBalance);
        checkMultipleOfTen(machineBalance);
    }
    private void checkBlank(String input) throws IllegalArgumentException {
        if (input.equals("")) {
            ERROR_MESSAGE = Message.ERROR_MACHINE_BALANCE_BLANK;
            throw new IllegalArgumentException();
        }
    }
    private void checkCharacter(String input) throws IllegalArgumentException {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                ERROR_MESSAGE = Message.ERROR_MACHINE_BALANCE_CHARACTER;
                throw new IllegalArgumentException();
            }
        }
    }
    private void checkNegativeNumber(int number) throws IllegalArgumentException {
        if (number < 0) {
            ERROR_MESSAGE = Message.ERROR_MACHINE_BALANCE_NEGATIVE_NUMBER;
            throw new IllegalArgumentException();
        }
    }
    private void checkMultipleOfTen(int number) throws IllegalArgumentException {
        if (!(number % 10 == 0)) {
            ERROR_MESSAGE = Message.ERROR_MACHINE_BALANCE_MULTIPLE_OF_TEN;
            throw new IllegalArgumentException();
        }
    }
    public int getMachineBalance() {
        return machineBalance;
    }
    public boolean inputGoods() {
        try {
            input();
            checkCorrectGoods();
        } catch (Exception e){
            System.out.println(ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    private void checkCorrectGoods() throws IllegalArgumentException {
        checkBlank(input);
        goods.clear();
        for (String temp : input.split(String.valueOf(';'))) {
            goods.add(temp);
        }
        for (String temp : goods) {
            checkCorrectProduct(temp);
        }

    }
    private void checkCorrectProduct(String temp) throws IllegalArgumentException {
        checkSquareBrackets(temp);
        temp = temp.substring(1,temp.length()-1);
        String[] product = temp.split(",");
        checkProductElement(product);
        checkGoodsPrice(product[1]);
        checkGoodsQuantity(product[2]);
        productPrices.put(product[0], price);
        productQuantities.put(product[0], quantity);
    }
    private void checkSquareBrackets(String temp) throws IllegalArgumentException {
        if (!(temp.charAt(0) == '[' || temp.charAt(temp.length()-1) == ']')) {
            ERROR_MESSAGE = Message.ERROR_MACHINE_Goods_INVAILD_INPUT_SQUARE_BRACKETS;
            throw new IllegalArgumentException();
        }
    }
    private void checkProductElement(String[] temps) throws IllegalArgumentException {
        if (temps.length != 3) {
            ERROR_MESSAGE = Message.ERROR_MACHINE_Goods_INVAILD_INPUT_COMMA;
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < 3; i++) {
            if (temps[i].equals("")) {
                ERROR_MESSAGE = Message.ERROR_MACHINE_Goods_INVAILD;
                throw new IllegalArgumentException();
            }
        }
    }
    private void checkGoodsPrice(String temp) throws IllegalArgumentException {
        checkCharacter(temp);
        price = Integer.parseInt(temp);
        if (price < 100) {
            ERROR_MESSAGE = Message.ERROR_MACHINE_Goods_INVAILD_PRICE;
            throw new IllegalArgumentException();
        }
        checkMultipleOfTen(price);
    }
    private void checkGoodsQuantity(String temp) throws IllegalArgumentException {
        checkCharacter(temp);
        quantity = Integer.parseInt(temp);
        if (quantity < 0) {
            ERROR_MESSAGE = Message.ERROR_MACHINE_Goods_INVAILD_QUANTITY;
            throw new IllegalArgumentException();
        }
    }
    public boolean inputUserAmount() {
        try {
            input();
            checkCorrectAmount();
        } catch (Exception e){
            System.out.println(ERROR_MESSAGE);
            return false;
        }
        userAmount = machineBalance;
        return true;
    }
    private void checkCorrectAmount() throws IllegalArgumentException {
        checkCorrectBalance();
    }
    public void showRemainingAmount() {
        System.out.println();
        System.out.println(Message.REMAINING_AMOUNT + userAmount + Message.WON);
    }
    public boolean availablePurchase() {
        for(String product : productQuantities.keySet()) {
            if (productPrices.get(product) <= minProduct && productQuantities.get(product) >= 1) {
                minProduct = productPrices.get(product);
            }
            allInventory += productQuantities.get(product);
        }
        if (allInventory == 0 || userAmount < minProduct) {
            return true;
        }
        return false;
    }
    public boolean inputUserGoods() {
        try {
            input();
            checkCorrectUserGoods();
        } catch (Exception e){
            System.out.println(ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    private void checkCorrectUserGoods() throws IllegalArgumentException {
        checkBlank(input);
        if (!productPrices.containsKey(input)) {
            ERROR_MESSAGE = Message.ERROR_GOODS_NO_FIND;
            throw new IllegalArgumentException();
        }
        if (productQuantities.get(input) == 0) {
            ERROR_MESSAGE = Message.ERROR_GOODS_NO_INVENTORY;
            throw new IllegalArgumentException();
        }
    }
    public void userPurchase() {
        productQuantities.put(input, productQuantities.get(input) - 1);
        userAmount -= productPrices.get(input);
    }
    public int getUserAmount() {
        return userAmount;
    }
}
