package vendingmachine.machine;

import vendingmachine.coin.Coin;
import vendingmachine.coin.CoinController;
import vendingmachine.product.Product;
import vendingmachine.product.ProductController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static vendingmachine.constant.Constant.PRODUCT_SPLITTER;

public class MachineController {
    private final CoinController coinController = new CoinController();
    private final ProductController productController = new ProductController();
    private final MachineService machineService = new MachineService();

    public void start(Machine machine,int money,String productList){
        machineService.makeCoins(machine,money);
        machineService.makeProductList(machine,productList);
    }

    public void run(Machine machine,int money){
        machineService.insertMoney(machine,money);
    }

}
