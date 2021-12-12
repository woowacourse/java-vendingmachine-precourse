package vendingmachine.io;

import static camp.nextstep.edu.missionutils.Console.*;
import static vendingmachine.config.ConstantConfig.*;
import static vendingmachine.config.utils.Validator.*;

import vendingmachine.service.MachineService;
import vendingmachine.service.MachineWalletService;
import vendingmachine.service.ProductService;
import vendingmachine.config.utils.Printer;

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
		VALIDATOR.addDependency(productService);
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
		
		while (!VALIDATOR.validateProductInputFormat(input = readLine())) {
			// validateProductInputFormat, validateSemicolonFormat
		}
		productService.saveAll(input.replaceAll(PRODUCT_INPUT_SEMICOLON_FORMAT, SEMICOLON).split(SEMICOLON));
	}

	public void inputCustomerAmount() {
		printer.printCustomerAmountNotice();

		while (!VALIDATOR.validateNumberFormat(input = readLine())) {
			// validateNumberFormat
		}
		machineService.saveCustomerAmount(Integer.parseInt(input));
	}

	public void inputCustomerBuyProduct() {
		printer.printCustomerBuyProductNotice();

		while (!VALIDATOR.validateProductExisted(input = readLine())) {
			// validateProductExisted
		}

		productService.sellProduct(input);
	}

}
