package vendingmachine;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;
import static vendingmachine.Validation.*;

public class VendingMachine {
    private int machineOwnMoney;

    public VendingMachine(){
        VALIDATION_SUCCESS = true;
        while(VALIDATION_SUCCESS) {
            try {
                View.inputMsgOnVendingMachine();
                String machineOwnMoney = Console.readLine();
                Validation.machineOwnMoneyValidation(machineOwnMoney);
                VALIDATION_SUCCESS = false;
                this.machineOwnMoney = Integer.parseInt(machineOwnMoney);
            } catch (IllegalArgumentException e){
                View.noticeMsgOnException(e.getMessage());
            }
        }
    } // 생성자 종료

    public void startVendingMachine(ArrayList<Product> productList, User user){
        while(isUserMoneyAndMachineInventoryEnough(productList, user.getUserOwnMoney())){
            try {
                user.purchaseProduct(productList);
            } catch (IllegalArgumentException e){
                View.noticeMsgOnException(e.getMessage());
            }
        }
        changesBackToUser(user);
    }

    public void changesBackToUser(User user){
        HashMap<Integer, Integer> changes = new HashMap<>();
        for(Coin coin: Coin.values()){
            changes.put(coin.getAmount(), coin.calculateChangesCoin(user));
        }
        List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(changes.entrySet());
        entryList.sort((o1, o2) -> o2.getKey() - o1.getKey());
        View.noticeMsgOnChanges();
        for(Map.Entry<Integer, Integer> entry : entryList){
            if(entry.getValue() != 0){
                View.noticeMsgOnEachChanges(entry);
            }
        }
    }

    public void setRandomValueToEachCoin(){
        int tempMachineOwnMoney = this.machineOwnMoney;
        while(tempMachineOwnMoney != 0) {
            int selectedCoin = Randoms.pickNumberInList(Coin.getCoinList());
            if(tempMachineOwnMoney / selectedCoin > 0){
                Coin.valueOf("COIN_" + selectedCoin).addCount();
                tempMachineOwnMoney -= selectedCoin;
            }
        }
        View.noticeMsgOnCoins();
        for(Coin c: Coin.values()){
            View.noticeMsgOnEachCoin(c);
        }
    }

    public ArrayList<Product> insertProductToVendingMachine(){
        ArrayList<String> productStringList = new ArrayList<>();
        VALIDATION_SUCCESS = true;
        while(VALIDATION_SUCCESS) {
            try {
                View.inputMsgOnProduct();
                productStringList = Validation.stringParsingToList(Console.readLine());
                Validation.inputProductValidation(productStringList); // 상품명은 한글, 영어, 숫자, 특수문자 모두 가능하다. (ex. 비타500, 토레타!, 2%)
                VALIDATION_SUCCESS = false;
            } catch (IllegalArgumentException e){
                View.noticeMsgOnException(e.getMessage());
            }
        }
        return Product.createProductList(productStringList);
    }

    public static Product isSelectedProductInVendingMachine(ArrayList<Product> productList, String selectedProduct) {
        Product foundProduct = null;
        for (Product product : productList) {
            if (product.getName().equals(selectedProduct)) {
                foundProduct = product;
                break;
            }
        }
        return foundProduct;
    }
}
