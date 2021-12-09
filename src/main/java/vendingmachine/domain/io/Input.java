package vendingmachine.domain.io;

import static camp.nextstep.edu.missionutils.Console.*;
import static vendingmachine.domain.Machine.*;
import static vendingmachine.domain.MachineClip.*;
import static vendingmachine.domain.ProductFactory.*;
import static vendingmachine.domain.RandomBox.*;
import static vendingmachine.utils.Printer.*;

import java.util.Map;

import vendingmachine.domain.MachineClip;
import vendingmachine.domain.ProductFactory;
import vendingmachine.domain.RandomBox;
import vendingmachine.utils.Printer;

public enum Input {
	INPUT(PRINTER, RANDOM_COIN_BOX, MACHINE_CLIP, PRODUCT_FACTORY);

	private final Printer printer;
	private final RandomBox randomBox;
	private final MachineClip machineClip;
	private final ProductFactory productFactory;

	Input(Printer printer, RandomBox randomBox, MachineClip machineClip, ProductFactory productFactory){
		this.printer = printer;
		this.randomBox = randomBox;
		this.machineClip = machineClip;
		this.productFactory = productFactory;
	}

	// 자판기 보유 금액 입력
	public void inputMachineAmount() {
		printer.printMachineAmountNotice();

		Map<Integer, Integer> map = randomBox.getNumOfCoins(Integer.parseInt(readLine()));
		machineClip.initMachine(map);
	}

	public void inputProducts() {
		printer.printProductsNotice();

		// [콜라,1500,20];[사이다,1000,10];[환타,800,10]
		String[] products = readLine().split(";");

		for (int i = 0; i < products.length; i++) {
			String[] data = products[i].substring(1, products[i].length() - 1).split(",");
			productFactory.createProduct(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]));
		}
	}

	// 투입 금액 입력
	public int inputCustomerAmount() {
		printer.printCustomerAmountNotice();
		MACHINE.insertCoinToMachine(Integer.parseInt(readLine()));

		return productFactory.getProductMinPrice();
	}

	public void inputCustomerBuyProduct() {
		printer.printCustomerAmountNotice();

		String name = readLine();
		if (productFactory.isProductExisted(name)) {
			productFactory.buyProduct(name);
		}
	}
}
