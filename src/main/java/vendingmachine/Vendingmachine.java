package vendingmachine;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

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

    public HashMap<Coin, Integer> getCoinList(){
        return this.coinList;
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

        this.coinList = Utils.makeCoinHash();
        List<Integer> coins = Coin.getCoinList();
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
        return;
    }

    public void printRandomCoin(){
        List<Integer> coins = Coin.getCoinList();
        System.out.println("자판기가 보유한 동전");
        for(Coin coin: Coin.values()){
            System.out.println( coin.getAmount()+"원 - "+ this.coinList.get(coin)+"개");
        }
    }

    // 상품입력
    public void prodInput(){
        System.out.println(Message.INPUT_PROD_NAME);
        String prodInput = Console.readLine();
        this.productList = Utils.parseProd(prodInput);
        return;
    }

    // 유저의 돈 입력
    public void userMoneyInput() {
        System.out.println(Message.INPUT_USER_MONEY);
        this.userMoney = Integer.parseInt(Console.readLine());
        return;
    }

    public int play() {
        while(this.userMoney>0){
            System.out.println(Message.USER_MONEY+ this.userMoney + "원");

            // 종결조건 확인
            if(terminate(this.productList, this.userMoney)){
                break;
            }

            System.out.println(Message.INPUT_PROD_NAME);
            String prod = Console.readLine();
            int price = buyProduct(this.productList,  prod);
            this.userMoney-=price;
        }
        return  this.userMoney;
    }

    public static int buyProduct(List<Product> productList, String prod){
        if(checkStock(prod)){
            for(Product product: productList){
                if((product.getName()).equals(prod)){
                    product.minusStock();
                    return product.getPrice();
                }
            }
        }
        // 재고가 없는 경우 에러를 발생시킨다.
        return 0;
    }

    public static boolean terminate(List<Product> productList, int userMoney){
        if(lessThanCheapest(productList, userMoney))   return true;
        if(allStockOut(productList))   return true;
        return false;
    }


    public static boolean checkStock(String prod){return true;};

    public static boolean lessThanCheapest(List<Product> productList, int userMoney){
        int minPrice = 1000000;
        for(Product product: productList){
            minPrice = Math.min(product.getPrice(), minPrice);
        }
        return (minPrice>userMoney);
    }

    public static boolean allStockOut(List<Product> productList){
        for(Product product: productList){
            if(product.getStock()>0)    return false;
        }
        return true;
    }

    public void printLastMoney() {
        List<Integer> coins = Coin.getCoinList();
        // 유저의 돈이 전체돈보다 더 크다면 그냥 리턴한다.
        if(this.userMoney>=this.vendMoney){
            returnTotalInputMoney(this.coinList);
        }
        // 유저의 돈이 전체돈보다 작다면 그리디하게 리턴한다.
        HashMap<Coin, Integer> restUserMoney = returnGreedyMoney();
        returnTotalInputMoney(restUserMoney);
        return;
    }

    public void returnTotalInputMoney(HashMap<Coin, Integer> returnMoney){
        List<Integer> coins = Coin.getCoinList();
        for(Coin coin: Coin.values()){
            System.out.println( coin.getAmount()+"원 - "+ returnMoney.get(coin)+"개");
        }

    }

    public HashMap<Coin, Integer> returnGreedyMoney(){
        HashMap<Coin, Integer> restUserMoney = Utils.makeCoinHash();
        for(Coin coin: Coin.values()){
            while(this.userMoney< coin.getAmount()){
                if(this.coinList.get(coin)>0){
                    int current = this.coinList.get(coin);
                    int next = current-1;
                    this.coinList.put(coin, next);
                    int restCurrent = restUserMoney.get(coin);
                    int restNext = restCurrent + 1;
                    restUserMoney.put(coin, restNext);
                }
                else{
                    break;
                }
            }
        }
        return restUserMoney;
    };

}
