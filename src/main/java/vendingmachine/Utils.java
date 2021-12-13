package vendingmachine;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utils {

    public static int vendMoneyInput(){
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

    public static List<Product> prodInput(){
//        System.out.println(Message.INPUT_PROD_NAME);
//        Console.readLine();
        List<Product> parsedProdList = parseProd("[콜라,1500,20];[사이다,1000,10]");
        return parsedProdList;
    }

    public static List<Product> parseProd(String prodInput){
        List<String>splitList = Arrays.asList(prodInput.split(";"));
        List<Product> products = new ArrayList<Product>();
        for(String prod: splitList){
            String substringProd = prod.substring(1,prod.length()-1);
            List<String> splitSubstringProd = Arrays.asList(substringProd.split(","));
            Product newProduct = new Product(splitSubstringProd.get(0), Integer.parseInt(splitSubstringProd.get(1)), Integer.parseInt(splitSubstringProd.get(2)));
            products.add(newProduct);
        }
        return products;
    }
}
