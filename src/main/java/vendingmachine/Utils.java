package vendingmachine;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utils {

    public int vendMoneyInput(){
        System.out.println(Message.INPUT_VEND_MONEY);
        String inputVendMoney = Console.readLine();
        return Integer.parseInt(inputVendMoney);
    }

    // 숫자가 아닌 경우 예외처리
    public void validateVendMoneyInput(){

    }

    public static int[] generateRandomCoin(List<Integer> coins, int amount){
        int[] vendMoneyArray = {0,0,0,0};
        while(amount>0){
            int selectedMoney = Randoms.pickNumberInList(coins);
            if(selectedMoney>amount){continue;}
            if(selectedMoney==500)  vendMoneyArray[0]++;
            if(selectedMoney==100)  vendMoneyArray[1]++;
            if(selectedMoney==50)  vendMoneyArray[2]++;
            if(selectedMoney==10)  vendMoneyArray[3]++;
            amount -= selectedMoney;
        }
        return vendMoneyArray;
    }

    public static void printRandomCoin(List<Integer> coins, int[] vendMoneyArray){
        System.out.println("자판기가 보유한 동전");
        for(int i=0; i<4; i++){
            System.out.println(coins.get(i)+"원 - "+vendMoneyArray[i]+"개");
        }
    }

    public void play(){

    }
}
