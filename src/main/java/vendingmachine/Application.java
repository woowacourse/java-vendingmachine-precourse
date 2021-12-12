package vendingmachine;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    	String test= "200";
    	VendingMachine a= new VendingMachine(test);
    	System.out.println(a.totalCoin);
    	System.out.println(a.coinMap);
    }
}
