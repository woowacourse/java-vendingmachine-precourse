package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InputView {

    public String read() {
        return Console.readLine();
    }

    public String readCoins() {
        System.out.print("자판기가 보유하고 있는 금액을 입력하세요" + "\n");
        return Console.readLine();
    }

    public String purchaseproduct() {
        System.out.print("구매할 상품명을 입력해주세요" + "\n");
        return Console.readLine();
    }

    public int readbuyingAmount() {
        System.out.print("투입 금액을 입력해주세요" + "\n");
        return Integer.parseInt(Console.readLine());
    }

    public List<String> readproduct_list(String input) {
        List<String> list = new ArrayList<>();
        input = input.replace("[", "");
        input = input.replace("]", "");
        String[] buying = input.split(";");
        Collections.addAll(list, buying);
        return list;
    }

    public String readProductsformat() {
        System.out.print("상품명과 가격, 수량을 입력해주세요" + "\n");
        return read();
    }


}

