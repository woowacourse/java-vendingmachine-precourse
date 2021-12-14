package vendingmachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VendingMachine {
    Computer computer = new Computer();
    User user = new User();
    List<Product> productList;

    public void Machine() {
        computer.MSGInputMachineCoin();
        user.InputMachineCoin();
        int sumCoin = user.getCoin();
        MachineCoin machineCoin = new MachineCoin();
        machineCoin.CreateRandomCoin(sumCoin);
        computer.PrintMachineCoin(machineCoin);
        computer.MSGInputProduct();
        productList = user.InputProduct();
        computer.MSGInputAmount();
        user.InputAmount();

        while (true) {
            computer.MSGCurrentAmount(user.getUserCoin());
            if (!isPurchase()) {
                break;
            }
            computer.MSGInputPurchase();
            String purchase = user.InputPurchase(productList);
            for(Product product : productList){
                if(product.getName().equals(purchase)){
                    product.setCount(product.getCount() - 1);
                    user.setUserCoin(user.getUserCoin() - product.getPrice());
                }
            }
        }
    }

    private Boolean isPurchase(){
        for(Product product : productList){
            if(product.getCount() > 0 && user.getUserCoin() >= product.getPrice()){
                return true;
            }
        }
        return false;
    }
}
