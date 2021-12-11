package vendingmachine.config;

import static vendingmachine.domain.RandomBox.*;
import static vendingmachine.config.utils.Printer.*;

import vendingmachine.application.MachineLauncher;
import vendingmachine.domain.Machine;
import vendingmachine.domain.MachineWallet;
import vendingmachine.domain.product.ProductFactory;
import vendingmachine.domain.product.ProductRepository;
import vendingmachine.domain.product.Products;
import vendingmachine.io.Input;
import vendingmachine.io.Output;
import vendingmachine.service.MachineService;
import vendingmachine.service.MachineWalletService;
import vendingmachine.service.ProductService;

// Machine 의존성 주입 파일
public class MachineConfig {
	private static Products products;
	private static ProductFactory productFactory;
	private static Machine machine;
	private static MachineWallet machineWallet;
	private static ProductRepository productRepository;

	public static void injectDependencies(MachineLauncher machineLauncher){
		createDomainObject();
		injectRepositoryDependencies();

		machineLauncher.addDependencies(
			new Input(PRINTER,
				new MachineWalletService(machine, machineWallet, RANDOM_BOX),
				new MachineService(machine, productRepository),
				new ProductService(machine, productRepository)),
			new Output(PRINTER,
				new MachineWalletService(machine, machineWallet, RANDOM_BOX),
				new MachineService(machine, productRepository))
		);
	}

	private static void createDomainObject(){
		products = new Products();
		productFactory = new ProductFactory();
		machine = new Machine();
		machineWallet = new MachineWallet();
	}

	private static void injectRepositoryDependencies(){
		productRepository = new ProductRepository(products,productFactory);
	}

}
