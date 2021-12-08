package vendingmachine.service;

import vendingmachine.domain.Beverage;
import vendingmachine.domain.Money;
import vendingmachine.domain.VendingMachine;

public class VendingMachineService {
    // 구매 상품 입력시, 구매 가능한지(존재하는 제품, 투입 금액 충분) -> 구매 가능하면 상품 개수, 보유 금액 빼주고 -> 상품 0개인지 확인 (목록에서 제거) ->
    //  종료 상황인지 확인 (목록이 비었는지, 투입 금액이 최소 금액보다 낮은지) -> 종료 상황 아니면 구매할 상품명 , 종료 상황이면 잔돈
    private static final int OUT_OF_STOCK = 0;
    private final VendingMachine vendingMachine;

    public VendingMachineService(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

//    public MoneyChecker purchaseBeverage(String beverageName) {
//        Beverage findBeverage = vendingMachine.getBeverageByName(beverageName);
//        Money currentMoney = vendingMachine.getMoney();
//        currentMoney.isInsertPriceUnderBeveragePrice(findBeverage.getPrice());
//
//        reduceBeverageAndMoney(findBeverage, currentMoney);
//
//    }

    private void reduceBeverageAndMoney(Beverage findBeverage, Money currentMoney) {
        int restBeverageCount = findBeverage.reduceCount();
        currentMoney.reducePrice(findBeverage.getPrice());

        if(restBeverageCount == OUT_OF_STOCK){

        }
    }
}
