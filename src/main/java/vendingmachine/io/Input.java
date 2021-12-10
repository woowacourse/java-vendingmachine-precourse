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

import vendingmachine.domain.Machine;
import vendingmachine.domain.MachineClip;
import vendingmachine.domain.product.Product;
import vendingmachine.domain.product.ProductFactory;
import vendingmachine.domain.product.Products;
import vendingmachine.domain.RandomBox;
import vendingmachine.utils.Printer;
import vendingmachine.utils.Validator;

public enum Input {
	INPUT(PRINTER, RANDOM_COIN_BOX, MACHINE, MACHINE_CLIP, PRODUCT_FACTORY, PRODUCTS,VALIDATOR);

	private final Printer printer;
	private final RandomBox randomBox;
	private final Machine machine;
	private final MachineClip machineClip;
	private final ProductFactory productFactory;
	private final Products products;
	private final Validator validator;

	private String input;
	private String[] inputs;

	Input(Printer printer, RandomBox randomBox, Machine machine,
			MachineClip machineClip, ProductFactory productFactory, Products products, Validator validator){
		this.printer = printer;
		this.randomBox = randomBox;
		this.machine = machine;
		this.machineClip = machineClip;
		this.products = products;
		this.productFactory = productFactory;
		this.validator = validator;
	}

	public void inputMachineAmount() {
		printer.printMachineAmountNotice();

		while(!validator.validateNumberFormat(input=readLine())){
			// validateNumberFormat
		}
		machineClip.createMachineClip(randomBox.getNumOfCoins(Integer.parseInt(input)));
	}


	public void inputProducts() {
		printer.printProductsNotice();

		// [콜라,1500,20];[사이다,1000,10];[환타,800,10]
		while(!validator.validateProductInputFormat(input = readLine())) {
			// validateProductInputFormat, validateSemicolonFormat
		}
		inputs = input.split(SEMICOLON);
		for (int i = 0; i < inputs.length; i++) {
			String[] data = inputs[i].substring(1, inputs[i].length() - 1).split(COMMA);
			products.insertProductToList(productFactory.createProduct(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2])));
		}
	}

	public int inputCustomerAmount() {
		printer.printCustomerAmountNotice();

		while(!validator.validateNumberFormat(input=readLine())){
			// validateNumberFormat
		}

		machine.insertCoinToMachine(Integer.parseInt(input));

		return products.getMinPriceOfProducts();
	}

	public void inputCustomerBuyProduct() {
		printer.printCustomerBuyProductNotice();

		Product product = null;
		while(product == null){
			product = validator.validateProductExisted(input=readLine());
		}
		products.buyProduct(product);

	}

}
