package vendingmachine;

import static camp.nextstep.edu.missionutils.Console.*;
import static vendingmachine.Machine.*;
import static vendingmachine.MachineClip.*;
import static vendingmachine.ProductFactory.*;
import static vendingmachine.RandomBox.*;

import java.util.Map;

public class Application {
    private static final String INPUT_MACHINE_AMOUNT = "자판기가 보유하고 있는 금액 입력해주세요.";
    private static final String INPUT_PRODUCTS = "상품명과 가격, 수량을 입력해 주세요.";
    private static final String INPUT_CUSTOMER_AMOUNT = "투입 금액을 입력해 주세요.";
    private static final String INPUT_CUSTOMER_BUY_PROUDCT = "구매할 상품명을 입력해 주세요.";
    private static final String OUTPUT_MACHINE_NUM_OF_COINS = "\n자판기가 보유한 동전";
    public static void main(String[] args) {

        // 자판기 보유 금액 입력
        System.out.println(INPUT_MACHINE_AMOUNT);
        int machineAmount = Integer.parseInt(readLine()); // 보유 금액
        Map<Integer, Integer> map = RANDOM_COIN_BOX.getNumOfCoins(machineAmount);
        MACHINE_CLIP.initMachine(map);
        System.out.println(OUTPUT_MACHINE_NUM_OF_COINS);
        System.out.println(MACHINE_CLIP);

        // 상품 입력
        System.out.println(INPUT_PRODUCTS);
        // [콜라,1500,20];[사이다,1000,10];[환타,800,10]
        String[] products = readLine().split(";"); // 상품
        for(int i=0; i<products.length; i++){
            String[] data = products[i].substring(1,products[i].length()-1).split(",");
            createProduct(data[0],Integer.parseInt(data[1]),Integer.parseInt(data[2]));
        }

        // System.out.println(PRODUCT_FACTORY.toString());

        // 투입 금액 입력
        System.out.println(INPUT_CUSTOMER_AMOUNT);
        int coin = Integer.parseInt(readLine());
        MACHINE.insertCoinToMachine(coin);
        int min = getProductMinPrice();
        // System.out.println(min);

        int amount;
        while(true){
            amount = MACHINE.getMachineAmount();
            System.out.println("투입 금액: " + amount);
            if(amount < min) break;
            System.out.println(INPUT_CUSTOMER_BUY_PROUDCT);
            String name = readLine();

            if(isProductExisted(name)){
                PRODUCT_FACTORY.buyProduct(name);
            }
        }

        System.out.println("잔돈");
        MACHINE_CLIP.getChange(amount);

        // System.out.println("----");
        // System.out.println(MACHINE_CLIP);
    }
}
