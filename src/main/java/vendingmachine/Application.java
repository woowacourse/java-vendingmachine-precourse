package vendingmachine;

import static camp.nextstep.edu.missionutils.Randoms.*;
import static camp.nextstep.edu.missionutils.Console.*;
import static vendingmachine.Coin.*;
import static vendingmachine.Machine.*;
import static vendingmachine.RandomBox.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.assertj.core.util.Lists;
import org.assertj.core.util.Sets;

public class Application {
    private static final String INPUT_MACHINE_AMOUNT = "자판기가 보유하고 있는 금액 입력해주세요.";
    private static final String INPUT_PRODUCTS = "상품명과 가격, 수량을 입력해 주세요.";
    private static final String INPUT_CUSTOMER_AMOUNT = "투입 금액을 입력해 주세요.";
    private static final String INPUT_CUSTOMER_BUY_PROUDCT = "구매할 상품명을 입력해 주세요.";
    private static final String OUTPUT_MACHINE_NUM_OF_COINS = "\n자판기가 보유한 동전";
    public static void main(String[] args) {

        // int input = 450;
        // Map<Integer, Integer> map = RANDOM_COIN_BOX.getNumOfCoins(input);
        // map.keySet().stream().forEach(
        //     (k) -> System.out.println(k+" - " + map.get(k))
        // );

        // MACHINE.initMachine(map);
        // System.out.println(MACHINE);

        System.out.println(INPUT_MACHINE_AMOUNT);
        int machineAmount = Integer.parseInt(readLine()); // 보유 금액

        Map<Integer, Integer> map = RANDOM_COIN_BOX.getNumOfCoins(machineAmount);
        MACHINE.initMachine(map);
        System.out.println(OUTPUT_MACHINE_NUM_OF_COINS);
        System.out.println(MACHINE);

        // System.out.println(INPUT_PRODUCTS);
        // readLine(); // 상품
        //
        // System.out.println(INPUT_CUSTOMER_AMOUNT);
        // readLine(); // 투입 금액
        //
        // System.out.println(INPUT_CUSTOMER_BUY_PROUDCT);







        // pickNumberInList(1);

    }
}
