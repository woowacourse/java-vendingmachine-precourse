package vendingmachine.controller;

import java.util.Map;
import java.util.Map.Entry;
import vendingmachine.Coin;
import vendingmachine.domain.CoinGenerator;
import vendingmachine.utils.Parser;
import vendingmachine.validator.InputMoneyValidator;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class MachineController {
    private final InputView inputView;
    private final OutputView outputView;

    public MachineController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run(){
        Map<Coin, Integer> coins = makeMachineCoins();
        outputView.printCoins(coins);
    }

    private Map<Coin, Integer> makeMachineCoins(){
        int money = inputMachineMoney();
        CoinGenerator coinGenerator = new CoinGenerator(money);
        return coinGenerator.getCoins();
    }
    private int inputMachineMoney(){
        boolean flag = false;
        String money = "";
        while(!flag){
            try{
                money = inputView.inputMachineMoney();
                InputMoneyValidator.validateInputMoney(money);
                flag = true;
            }catch (IllegalArgumentException e){
                outputView.printErrorMessage(e);
            }
        }
        return Parser.inputMoneyParser(money);
    }
}
