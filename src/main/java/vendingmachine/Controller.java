package vendingmachine;

import java.util.List;

public class Controller {
    private final VendingMachine machine;
    private final ValidatedInput input;

    public Controller(VendingMachine machine, ValidatedInput input) {
        this.machine = machine;
        this.input = input;
    }

    public void requestMachineInfo() {
        int machineMoney = input.requestMachineMoney();
        List<Coin> coins = Coin.generateCoinsBy(machineMoney);

        machine.insertCoins(coins);
        machine.registerProducts(input.requestMachineProduct());
        machine.insertMoney(input.requestUserMoney());
    }

    public void startBuying() {
        if (!machine.isReadyToStartBuying()) {
            requestMachineInfo();
        }
        buyProduct();
    }

    private void buyProduct() {
        System.out.printf((Constant.REMAIN_MONEY) + "%n", machine.remainMoney());
        if (!machine.canBuyWith(machine.remainMoney())) {
            return;
        }
        String nameToBuy = input.requestBuyingProduct();

        if (!machine.hasProduct(nameToBuy)) {
            System.out.println(Constant.MACHINE_DONT_HAVE_PRODUCT_ERROR_STRING);
            buyProduct();
            return;
        }
        machine.buy(nameToBuy);
        buyProduct();
    }
}
