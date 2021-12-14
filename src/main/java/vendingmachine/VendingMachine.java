package vendingmachine;

import java.util.LinkedHashMap;
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
        System.out.println();

        computer.PrintMachineCoin(machineCoin);
        System.out.println();

        computer.MSGInputProduct();
        productList = user.InputProduct();
        System.out.println();

        computer.MSGInputAmount();
        user.InputAmount();
        System.out.println();

        while (true) {
            computer.MSGCurrentAmount(user.getUserCoin());
            if (!isPurchase()) {
                break;
            }
            computer.MSGInputPurchase();
            String purchase = user.InputPurchase(productList);
            System.out.println();

            for(Product product : productList){
                if(product.getName().equals(purchase)){
                    product.setCount(product.getCount() - 1);
                    user.setUserCoin(user.getUserCoin() - product.getPrice());
                }
            }
        }

        System.out.println("잔돈");
        Map<Coin, Integer> machineCoinMap = machineCoin.getMachineCoin();
        Map<Coin, Integer> changes = new LinkedHashMap<>();
        for(Coin coin : Coin.values()){
            changes.put(coin, 0);
        }

        for(Map.Entry<Coin, Integer> m : machineCoinMap.entrySet()){
            if(m.getValue() == 0) {
                continue;
            }
            while(user.getUserCoin() - m.getKey().getAmount() >= 0){
                user.setUserCoin(user.getUserCoin()-m.getKey().getAmount());
                m.setValue(m.getValue() -1);
                changes.put(m.getKey(), changes.get(m.getKey())+1);
                if(m.getValue() == 0){
                    break;
                }
            }
        }

        for(Map.Entry<Coin,Integer> m : changes.entrySet()){
            if(m.getValue() != 0) {
                System.out.println(m.getKey().getAmount() + "원 - " + m.getValue() + "개");
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
