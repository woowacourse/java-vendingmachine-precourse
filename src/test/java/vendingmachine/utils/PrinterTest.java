package vendingmachine.utils;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static vendingmachine.domain.MachineClip.*;
import static vendingmachine.utils.Constant.*;
import static vendingmachine.utils.Printer.*;

import java.util.Map;
import java.util.TreeMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;
import vendingmachine.domain.MachineClip;
import vendingmachine.domain.RandomBox;

class PrinterTest extends NsTest {

	private Printer printer;
	private RandomBox randomBox;
	private MachineClip machineClip;

	@BeforeEach
	void beforeEach(){
		this.printer = PRINTER;
		this.machineClip = MACHINE_CLIP;
		randomBox = RandomBox.RANDOM_COIN_BOX;
		machineClip.initMachine(randomBox.getNumOfCoins(100000000));
	}

	@Test
	void 머신_보유금액입력_알림_테스트(){
		printer.printMachineAmountNotice();
		assertEquals(output().contains(INPUT_MACHINE_AMOUNT), true);
	}

	@Test
	void 머신_상품입력_알림_테스트(){
		printer.printProductsNotice();
		assertEquals(output().contains(INPUT_PRODUCTS), true);
	}

	@Test
	void 고객_투입금액입력_알림_테스트(){
		printer.printCustomerAmountNotice();
		assertEquals(output().contains(INPUT_CUSTOMER_AMOUNT), true);
	}

	@Test
	void 고객_상품구매입력_알림_테스트(){
		printer.printCustomerBuyProductNotice();
		assertEquals(output().contains(INPUT_CUSTOMER_BUY_PRODUCT), true);
	}

	@Test
	void 머신_동전_종류별출력_알림_테스트(){
		printer.printMachineNumOfCoinsNotice(machineClip);
		assertThat(output()).contains(OUTPUT_MACHINE_NUM_OF_COINS, "원 -", "개");
	}

	@Test
	void 머신_고객_현재투입금액출력_알림_테스트(){
		int amount = 100000;
		printer.printCustomerCurrentAmount(amount);
		assertEquals(output().contains(String.format(OUTPUT_CUSTOMER_AMOUNT, amount)), true);
	}

	@Test
	void 고객_잔돈반환출력_알림_테스트(){
		Map<Integer, Integer> amountToChanges = new TreeMap<>((o1,o2)->o2-o1);
		amountToChanges.put(10, 10);
		amountToChanges.put(100, 3);
		amountToChanges.put(500, 5);

		printer.printCustomerChange(amountToChanges);
		assertThat(output()).contains(OUTPUT_CUSTOMER_CHANGE, "10원 - 10개", "100원 - 3개", "500원 - 5개");
	}

	@Override
	protected void runMain() {

	}
}