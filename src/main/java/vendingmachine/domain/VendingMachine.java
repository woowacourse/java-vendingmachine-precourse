package vendingmachine.domain;

public class VendingMachine {
    MachineMoney machineMoney;

    public void setMachineMoney(String money) throws IllegalArgumentException{
        machineMoney = new MachineMoney(money);
    }
}
