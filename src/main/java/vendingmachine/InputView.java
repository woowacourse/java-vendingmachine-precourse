package vendingmachine;

import static camp.nextstep.edu.missionutils.Console.*;

public class InputView {
	private static final String INITIAL_MACHINE_ASSET_INPUT = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	private static final String INITIAL_BEVERAGES_INPUT = "상품명과 가격, 수량을 입력해 주세요.";

	private InputView() {
	}

	public static int readInitialMachineAssets() {
		System.out.println(INITIAL_MACHINE_ASSET_INPUT);
		return InputUtil.readInt();
	}

	public static String readBeverageInfos() {
		System.out.println(INITIAL_BEVERAGES_INPUT);
		return readLine();
	}
}
