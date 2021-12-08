package vendingmachine.domain;

public class VendingMachine {
    MachineMoney machineMoney;

    public void setMachineMoney(String money) {
        machineMoney = new MachineMoney(money);
    }

}
