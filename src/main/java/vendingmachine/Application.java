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
