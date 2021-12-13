package vendingmachine;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.ui.MachineUI;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Machine {

    private final MachineUI machineUI;
    private final Validator validator;
    private final Parser parser = new Parser();
    private final Exchanger exchanger = new Exchanger();
    private int amount = 0;
    private int inputMoney = 0;
    Map<String,Goods> goodsList;

    public Machine(MachineUI machineUI,Validator validator){
        this.machineUI = machineUI;
        this.validator = validator;
    }
    public void operate(){
        getVendingMachineAmount();
        generateRandomCoins();
        machineUI.showAmount();
        getGoodsList();
        getMoney();
        getUserOrder();
        machineUI.showExchange(exchanger.getExchangedCoins());
    }
    public void getVendingMachineAmount(){
        while (true){
            System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
            String amountInput = Console.readLine();
            System.out.println();
            try{
                validator.validateAmount(amountInput);
                amount = Integer.parseInt(amountInput.trim());
                break;
            }catch (Exception e){
                System.out.println();
            }
        }
    }
    private void generateRandomCoins(){
        int leftAmount = amount;
        while(leftAmount != 0){
            List<Integer> coinList = findAvailableCoins(leftAmount);
            int coinValue = Randoms.pickNumberInList(coinList);
            Coin.valueOf("COIN_"+coinValue).increaseNumber();
            leftAmount -= coinValue;
        }
    }

    private List<Integer> findAvailableCoins(int leftAmount){
        List<Integer> list = new ArrayList<>();
        if(leftAmount / Coin.COIN_500.getAmount() >=1) list.add(500);
        if(leftAmount / Coin.COIN_100.getAmount() >=1) list.add(100);
        if(leftAmount / Coin.COIN_50.getAmount() >=1) list.add(50);
        if(leftAmount / Coin.COIN_10.getAmount() >=1) list.add(10);
        return list;
    }
    private void getGoodsList(){
        while (true){
            System.out.println("상품명과 가격, 수량을 입력해 주세요.");
            String goodsListInput = Console.readLine();
            System.out.println();
            try{
                validator.validateGoodsList(goodsListInput);
                goodsList = parser.parseGoods(goodsListInput);
                break;
            }catch (Exception e){
                System.out.println();
            }
            System.out.println();
        }
    }
    private void getMoney(){
        while (true){
            System.out.println("투입 금액");
            String moneyInput = Console.readLine();
            System.out.println();
            try{
                validator.validateInputMoney(moneyInput);
                inputMoney = Integer.parseInt(moneyInput);
                break;
            }catch (Exception e){
                System.out.println();
            }
            System.out.println();
        }
    }
    private void getUserOrder(){
        int leftMoney = inputMoney;
        while (true){
            System.out.println("투입 금액: " + leftMoney + "원");
            if(isAllSoldOut() || findMinPrice() > leftMoney ) {
                exchanger.exchange(leftMoney);
                break;
            }
            System.out.println("구입할 상품명을 입력해 주세요.");
            String goodsInput = Console.readLine();
            if(!goodsList.containsKey(goodsInput)) {
                System.out.println("[ERROR] 상품 목록에 없는 제품입니다.");
                continue;
            }
            int goodsPrice = goodsList.get(goodsInput).getPrice();
            leftMoney -= goodsPrice;
            System.out.println();
        }
    }
    private int findMinPrice(){
        int minPrice = Integer.MAX_VALUE;
        for (Map.Entry<String,Goods> goodsEntry: goodsList.entrySet()){
            int price = goodsEntry.getValue().getPrice();
            if(goodsEntry.getValue().getNumber() == 0 ) continue;
            if(minPrice > price ) minPrice = price;
        }
        return minPrice;
    }
    private boolean isAllSoldOut(){
        for (Map.Entry<String,Goods> element: goodsList.entrySet()){
            if(element.getValue().getNumber() > 0) return false;
        }
        return true;
    }
}
