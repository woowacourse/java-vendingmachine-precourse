package vendingmachine.job;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleProductJob implements ProductJob {
	@Override
	public void execute() {
		System.out.println("상품명과 가격, 수량을 입력해 주세요.");
		String inputProduct = Console.readLine();
	}
}
