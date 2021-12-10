package vendingmachine;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Test {
    public static void main(String[] args) {
        System.out.println("상품 입력");
        String aa = Console.readLine();
        String[] bb = aa.split("\\[|,|;|\\]");
        for (int i = 0; i < bb.length; i++) {
            System.out.printf("%d번째 %s\n", i, bb[i]);
        }
    }
}
