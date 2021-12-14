package vendingmachine;

import java.util.HashMap;
import java.util.List;

public class Vendingmachine {
    private Integer vendMoney;
    private Integer userMoney;
    private List<Product> productList;
    private HashMap<Coin, Integer> coinList;

    public Vendingmachine(){}

    public Integer getVendMoney(){
        return this.vendMoney;
    }

    public Integer getUserMoney(){
        return this.userMoney;
    }

    public void inputVendMoney(){
        while(true){
            try{
                this.vendMoney = Utils.vendMoneyInput();
                break;
            } catch(IllegalArgumentException e){
                System.out.println(Message.ERROR_INPUT_VEND_MONEY);
            }
        }
        return;
    }
}
