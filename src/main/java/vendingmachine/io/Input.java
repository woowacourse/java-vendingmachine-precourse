package vendingmachine.io;

import static camp.nextstep.edu.missionutils.Console.*;
import static vendingmachine.domain.Machine.*;
import static vendingmachine.domain.MachineClip.*;
import static vendingmachine.domain.product.ProductFactory.*;
import static vendingmachine.domain.product.Products.*;
import static vendingmachine.domain.RandomBox.*;
import static vendingmachine.utils.Constant.*;
import static vendingmachine.utils.Printer.*;
import static vendingmachine.utils.Validator.*;

import vendingmachine.domain.product.Products;
import vendingmachine.service.MachineClipService;
import vendingmachine.service.VendingMachineService;
import vendingmachine.utils.Printer;
import vendingmachine.utils.Validator;

public enum Input {
	INPUT(PRINTER, VALIDATOR,
		new MachineClipService(MACHINE_CLIP, RANDOM_COIN_BOX, MACHINE),
		new VendingMachineService(PRODUCTS, MACHINE, PRODUCT_FACTORY));

	private final Printer printer;
	private final Validator validator;
	private final MachineClipService machineClipService;
	private final VendingMachineService vendingMachineService;

	private String input;

	Input(Printer printer, Validator validator, MachineClipService machineClipService,
		VendingMachineService productService) {
		this.printer = printer;
		this.validator = validator;
		this.machineClipService = machineClipService;
		this.vendingMachineService = productService;
	}

	public void inputMachineAmount() {
		printer.printMachineAmountNotice();

		while (!validator.validateNumberFormat(input = readLine())) {
			// validateNumberFormat
		}
		machineClipService.initMachineClip(Integer.parseInt(input));
	}

	public void inputProducts() {
		printer.printProductsNotice();

		// [콜라,1500,20];[사이다,1000,10];[환타,800,10]
		while (!validator.validateProductInputFormat(input = readLine())) {
			// validateProductInputFormat, validateSemicolonFormat
		}
		vendingMachineService.initProducts(input.split(SEMICOLON));
	}

	public void inputCustomerAmount() {
		printer.printCustomerAmountNotice();

		while (!validator.validateNumberFormat(input = readLine())) {
			// validateNumberFormat
		}
		vendingMachineService.initMachine(Integer.parseInt(input));
	}

	public void inputCustomerBuyProduct() {
		printer.printCustomerBuyProductNotice();

		while (!validator.validateProductExisted(input = readLine())) {
			// validateProductExisted
		}

		vendingMachineService.buyProduct(input);
	}

}
