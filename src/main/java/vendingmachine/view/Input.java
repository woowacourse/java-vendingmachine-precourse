package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Input {

    public int readAmount() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        return Integer.parseInt(read());
    }

    public List<String[]> readItemInfos() {
        System.out.println("\n상품명과 가격, 수량을 입력해 주세요.");
        return Arrays.stream(read().split(";"))
                .map(itemInfo ->
                        itemInfo.replace("[]", "")
                                .split(","))
                .toList();
    }

    private String read() {
        return Console.readLine();
    }
}
