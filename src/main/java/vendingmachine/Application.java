package vendingmachine;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int i = Randoms.pickNumberInList(Arrays.asList(0, 4, 9, 45));
        System.out.println(i);
    }
}
