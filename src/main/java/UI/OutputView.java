package UI;

import static Constants.GuideMessages.*;

public class OutputView {
    public void enterVendingMachineMoney(){
        System.out.println(ENTER_VENDING_MACHINE_MONEY);
    }

    public void printVendingMachineCoins(){
        System.out.println(COIN_OWNED_BY_MACHINE);
        /*for(){

        }*/
    }
    public void enterProductInfo(){
        System.out.println(ENTER_PRODUCT_INFO);
    }
    public void enterInputPrice(){
        System.out.println(ENTER_INPUT_PRICE);
    }

    public void enterProductYouWillBuy(){
        //System.out.println(REMAINING_PRICE+돈+원);
        System.out.println(ENTER_PRODUCT_YOU_WILL_BUY);
    }

    public void returnChanges(){
        System.out.println(CHANGE);
        /*for(){

        }*/
    }

}
