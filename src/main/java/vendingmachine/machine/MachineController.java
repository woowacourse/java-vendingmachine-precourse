package vendingmachine.machine;

import vendingmachine.coin.Coin;

import vendingmachine.product.Product;

import vendingmachine.view.Input;
import vendingmachine.view.Output;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static vendingmachine.constant.Constant.PRODUCT_SPLITTER;

import javax.crypto.Mac;

public class MachineController {

    private final MachineService machineService = new MachineService();
    private final Input input = new Input();
    private final Output output = new Output();

    public void init(Machine machine){
        initMachine(machine);
        initMoney(machine);
    }

    private void initMachine(Machine machine){
        machineService.makeCoins(machine,input.inputMachineMoney());
        output.printCoins(machine);
        machineService.makeProductList(machine,input.inputProducts());

    }

    private void initMoney(Machine machine){
        machineService.insertMoney(machine,input.inputUserMoney());
    }

    public void buy(Machine machine){
        String product = input.inputBuyProduct(machine);
        machineService.buyProduct(machine,product);
    }

    public void end(Machine machine) {
        output.printEnd(machine);
        machineService.giveChanges(machine);
    }
}
