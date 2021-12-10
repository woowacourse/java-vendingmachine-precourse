package vendingmachine;

import static vendingmachine.domain.RandomBox.*;
import static vendingmachine.utils.Printer.*;

import vendingmachine.application.MachineLauncher;
import vendingmachine.domain.Machine;
import vendingmachine.domain.MachineWallet;
import vendingmachine.domain.product.ProductFactory;
import vendingmachine.domain.product.Products;
import vendingmachine.io.Input;
import vendingmachine.io.Output;
import vendingmachine.service.MachineService;
import vendingmachine.service.MachineWalletService;
import vendingmachine.service.ProductService;

public class Application {

    static Products products = new Products();
    static ProductFactory productFactory = new ProductFactory();
    static Machine machine = new Machine();
    static MachineWallet machineWallet = new MachineWallet();
    static MachineLauncher machineLauncher = new MachineLauncher();
    static {
        machineLauncher.addDependencies( new Input(PRINTER,
                new MachineWalletService(machine, machineWallet, RANDOM_BOX),
                new MachineService(machine, products),
                new ProductService(machine, products, productFactory)),
            new Output(PRINTER,
                new MachineWalletService(machine, machineWallet, RANDOM_BOX),
                new MachineService(machine, products)));
    }

    public static void main(String[] args) {
        machineLauncher.run();
    }
}
