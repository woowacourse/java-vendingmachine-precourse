package vendingmachine;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Application {
    static int MACHINE_OWN_MONEY = 0;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        MACHINE_OWN_MONEY = inputMachineOwnMoney();
        setVendingMachineOwnCoins();
        printCurrentMachineCoin();
    }

    public static void setVendingMachineOwnCoins(){
        Coin[] eachCoin = Coin.values();
        for(Coin c: eachCoin){
            setRandomCountToEachCoin(c);
        }
    }

    public static void printCurrentMachineCoin(){
        System.out.println("자판기가 보유한 동전");
        Coin[] eachCoin = Coin.values();
        for(Coin c: eachCoin){
            System.out.println(c.getAmount()+"원 - " + c.getCount()+"개");
        }
    }

    public static void setRandomCountToEachCoin(Coin coin){
        int maxCount = MACHINE_OWN_MONEY / coin.getAmount();
        List<Integer> possibleMoneyList = new ArrayList<>();

        if(maxCount <= 0) return;
        if(coin.getAmount() == 10){
            coin.setCount(maxCount);
            return;
        }

        for(int i = 0; i <= maxCount; i++){
            possibleMoneyList.add(i);
        }
        coin.setCount(Randoms.pickNumberInList(possibleMoneyList));
        MACHINE_OWN_MONEY -= coin.getCount() * coin.getAmount();
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
