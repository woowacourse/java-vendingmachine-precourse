package vendingmachine.io;

import static camp.nextstep.edu.missionutils.Console.*;
import static vendingmachine.utils.Constant.*;
import static vendingmachine.utils.Validator.*;

import vendingmachine.service.MachineService;
import vendingmachine.service.MachineWalletService;
import vendingmachine.service.ProductService;
import vendingmachine.utils.Printer;

public class Input {
	private final Printer printer;
	private final MachineWalletService machineWalletService;
	private final MachineService machineService;
	private final ProductService productService;

	private String input;

	public Input(Printer printer, MachineWalletService machineWalletService,
		MachineService machineService, ProductService productService) {
		this.printer = printer;
		this.machineWalletService = machineWalletService;
		this.machineService = machineService;
		this.productService = productService;
		VALIDATOR.addDependency(productService.getProductList());
	}

	public void inputMachineAmount() {
		printer.printMachineAmountNotice();

		while (!VALIDATOR.validateNumberFormat(input = readLine())) {
			// validateNumberFormat
		}
		machineWalletService.save(Integer.parseInt(input));
	}

	public void inputProducts() {
		printer.printProductsNotice();

		// [콜라,1500,20];[사이다,1000,10];[환타,800,10]
		while (!VALIDATOR.validateProductInputFormat(input = readLine())) {
			// validateProductInputFormat, validateSemicolonFormat
		}
		productService.save(input.split(SEMICOLON));
	}

	public void inputCustomerAmount() {
		printer.printCustomerAmountNotice();

		while (!VALIDATOR.validateNumberFormat(input = readLine())) {
			// validateNumberFormat
		}
		machineService.save(Integer.parseInt(input));
	}

	public void inputCustomerBuyProduct() {
		printer.printCustomerBuyProductNotice();

		while (!VALIDATOR.validateProductExisted(input = readLine())) {
			// validateProductExisted
		}

		productService.sellProduct(input);
	}

}
