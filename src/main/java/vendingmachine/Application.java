package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

public class Application {
	public static void main(String[] args) {
		System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
		String value = Console.readLine();

		if (!value.matches("[0-9]*")) {
            throw new IllegalArgumentException("[ERROR] 금액은 숫자여야 합니다.");
		}
	}
}
