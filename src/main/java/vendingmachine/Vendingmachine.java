package vendingmachine;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.List;

public class Vendingmachine {
    private Integer vendMoney;
    private Integer userMoney;
    private List<Product> productList;
    private HashMap<Coin, Integer> coinList;

    public Vendingmachine(){
        makeCoinHash();
    }

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

    public void getVendMoneyToCoin(){
        int tempVendMoney=vendMoney;
        while(tempVendMoney>0){
            int selectedMoney = Randoms.pickNumberInList(coins);
            if(selectedMoney>tempVendMoney){continue;}
            if(selectedMoney==500){
                int next = this.coinList.get(Coin.COIN_500) + 1;
                this.coinList.put(Coin.COIN_500, next);
            }
            if(selectedMoney==100){
                int next = this.coinList.get(Coin.COIN_100) + 1;
                this.coinList.put(Coin.COIN_100, next);
            }
            if(selectedMoney==50){
                int next = this.coinList.get(Coin.COIN_50) + 1;
                this.coinList.put(Coin.COIN_50, next);
            }
            if(selectedMoney==10){
                int next = this.coinList.get(Coin.COIN_10) + 1;
                this.coinList.put(Coin.COIN_10, next);
            }
            tempVendMoney -= selectedMoney;
        }
//        int[] randomList = Utils.generateRandomCoin(coins, this.vendMoney);

        return;
    }

    public void makeCoinHash(){
        this.coinList.put(Coin.COIN_500, 0);
        this.coinList.put(Coin.COIN_100, 0);
        this.coinList.put(Coin.COIN_50, 0);
        this.coinList.put(Coin.COIN_10, 0);
    }
}
