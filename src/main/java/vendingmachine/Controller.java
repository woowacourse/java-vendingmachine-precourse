package vendingmachine;

import vendingmachine.domain.Coin;
import vendingmachine.domain.VendingMachine;

import java.util.List;

public class Controller {
    private final VendingMachine machine;
    private final ValidatedInput input;

    public Controller(VendingMachine machine, ValidatedInput input) {
        this.machine = machine;
        this.input = input;
    }

    public void setupMachine() {
        int machineMoney = input.requestMachineMoney();
        List<Coin> coins = Coin.generateCoinsBy(machineMoney);

        machine.insertCoins(coins);
        machine.registerProducts(input.requestMachineProduct());
        machine.insertMoney(input.requestUserMoney());
    }

    public void startBuying() {
        setupMachineIfNeeded();
        startProductBuyingProcess();
    }

    private void setupMachineIfNeeded() {
        if (!machine.isReadyToStartBuying()) {
            setupMachine();
        }
    }

    private void startProductBuyingProcess() {
        System.out.printf((Constant.REMAIN_MONEY) + "%n", machine.remainMoney());
        if (!machine.canBuyWith(machine.remainMoney())) {
            System.out.println(machine.returnChange().toStringWithoutEmptyCoin());
            return;
        }
        buyProduct();
    }

    private void buyProduct() {
        String nameToBuy = input.requestBuyingProduct();

        if (!machine.hasProduct(nameToBuy)) {
            System.out.println(Constant.MACHINE_DONT_HAVE_PRODUCT_ERROR_STRING);
            startProductBuyingProcess();
            return;
        }
        machine.buy(nameToBuy);
        startProductBuyingProcess();
    }
}
