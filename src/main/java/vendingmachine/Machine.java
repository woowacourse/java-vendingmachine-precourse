package vendingmachine;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.ui.MachineUI;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Machine {

    private final MachineUI machineUI;
    private final Validator validator;
    private final Parser parser = new Parser();
    private int amount = 0;
    private Coin coins;
    List<Goods> goodsList;
    public Machine(MachineUI machineUI,Validator validator){
        this.machineUI = machineUI;
        this.validator = validator;
    }
    public void operate(){
        getVendingMachineAmount();
        generateRandomCoins();
        machineUI.showAmount();
        getGoodsList();
    }
    private void getVendingMachineAmount(){
        while (true){
            System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
            String amountInput = Console.readLine();
            System.out.println();
            try{
                validator.validateAmount(amountInput);
                amount = Integer.parseInt(amountInput);
                break;
            }catch (Exception e){

            }
        }
    }
    private void generateRandomCoins(){
        int leftAmount = amount;
        leftAmount = setCoins(leftAmount,Coin.COIN_500.getAmount());
        if(leftAmount == 0) return;
        leftAmount = setCoins(leftAmount,Coin.COIN_100.getAmount());
        if(leftAmount == 0) return;
        leftAmount = setCoins(leftAmount,Coin.COIN_50.getAmount());
        if(leftAmount == 0) return;
        Coin.COIN_10.setNumber(leftAmount/Coin.COIN_10.getAmount());
    }
    private int setCoins(int leftAmount, int coin){
        int bound = leftAmount / coin;
        int number = 0;
        if( bound >=1){
            number = Randoms.pickNumberInList(IntStream.range(0,bound).boxed().collect(Collectors.toList()));
            Coin.valueOf("COIN_"+coin).setNumber(number);
        }
        return leftAmount  - coin * number;
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

            }
            System.out.println();
        }
    }

}
