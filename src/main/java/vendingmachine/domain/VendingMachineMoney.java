package vendingmachine.domain;

public class VendingMachineMoney {
    int totalMoney = 0;
    int moneyCount500 = 0;
    int moneyCount100 = 0;
    int moneyCount50 = 0;
    int moneyCount10 = 0;

    public VendingMachineMoney(int inputMoney) {
        this.totalMoney = inputMoney;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }

    public int getMoneyCount500() {
        return moneyCount500;
    }

    public void setMoneyCount500(int moneyCount500) {
        this.moneyCount500 = moneyCount500;
    }

    public int getMoneyCount100() {
        return moneyCount100;
    }

    public void setMoneyCount100(int moneyCount100) {
        this.moneyCount100 = moneyCount100;
    }

    public int getMoneyCount50() {
        return moneyCount50;
    }

    public void setMoneyCount50(int moneyCount50) {
        this.moneyCount50 = moneyCount50;
    }

    public int getMoneyCount10() {
        return moneyCount10;
    }

    public void setMoneyCount10(int moneyCount10) {
        this.moneyCount10 = moneyCount10;
    }

    public void coinUpdate(int price){
        if (price == 500){
            moneyCount500 += 1;
        }
        if (price == 100){
            moneyCount100 += 1;
        }
        if (price == 50){
            moneyCount50 += 1;
        }
        if (price == 10){
            moneyCount10 += 1;
        }
    }
}
