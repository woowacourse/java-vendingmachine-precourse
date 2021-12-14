package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

public class MachineController {


	private Machine machine;
	private Customer customer;

	public void readyToOpen() {
		this.machine = new Machine();
		inputMachineMoney();
		setMachineCoin();
		inputMachineProduct();
		this.customer = new Customer();
		this.customer.readyToPurchase();
	}

	public void inputMachineMoney() {
		MachineView.requestMoney();
		String userInput = Console.readLine();
		try {
			Validator.isNumeric(userInput);
			Validator.coinMinimumCheck(userInput);
			Validator.multipleOfTen(userInput);
			machine.setMachineMoney(userInput);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			inputMachineMoney();
		}
	}

	public void setMachineCoin() {
		machine.setWallet();
		int target = machine.getMoney();
		while (target > 0) {
			Coin coin = Coin.pickRandomCoin();
			if (Coin.hasEnoughMoney(target, coin)) {
				target -= coin.getAmount();
				machine.updateWallet(coin);
			}
		}
		MachineView.openWallet(machine);
	}

	public void inputMachineProduct() {
		MachineView.requestProductList();
		String userInput = Console.readLine();
		String[] productList = userInput.split(";");
		try {
			for (String productInfo : productList) {
				Validator.productInput(Util.removeSquareBracket(productInfo));
			}
			machine.makeProductsList(productList);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			inputMachineProduct();
		}
	}

	public void startMachine() {
		do {
			this.customer.printCustomerMoney();
			machineOpen();
		} while (this.machine.minimumMoneyCheck(this.customer));
		this.customer.printCustomerMoney();
		MachineView.giveTheChange(customer, machine);
	}

	public void machineOpen() {
		String productName = inputProductName();
		try {
			Product product = machine.findProduct(productName);
			this.customer.isExpensive(product);
			product.isSoldOut();
			this.customer.purchaseProduct(product);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			machineOpen();
		}
	}

	public String inputProductName() {
		MachineView.requestProduct();
		String userInput = Console.readLine();
		try {
			Validator.isNull(userInput);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			inputProductName();
		}
		return userInput.trim();
	}

}
