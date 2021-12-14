package vendingmachine.machine;

import vendingmachine.coin.Coin;

import vendingmachine.product.Product;

import vendingmachine.view.Input;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static vendingmachine.constant.Constant.PRODUCT_SPLITTER;

public class MachineController {

    private final MachineService machineService = new MachineService();
    private final Input input = new Input();
    public void start(Machine machine,int money,String productList){
        machineService.makeCoins(machine,money);
        machineService.makeProductList(machine,productList);
    }

    public void run(Machine machine,int money){
        machineService.insertMoney(machine,money);
    }

}
