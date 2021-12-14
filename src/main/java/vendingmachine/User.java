package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

public class User {
    int sumCoin = 0;

    public int getCoin(){
        return sumCoin;
    }
    public void setCoin(int coin){
        this.sumCoin = coin;
    }

    public void InputMachineCoin(){
        String machineCoinString = Console.readLine();
        try{
            isInteger(machineCoinString);
            isPositive(machineCoinString);
            isDivide(machineCoinString);
        }catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            InputMachineCoin();
        }
        setCoin(Integer.parseInt(machineCoinString));
    }

    private void isInteger(String machineCoinString){
        try{
            Integer.parseInt(machineCoinString);
        }catch (Exception e){
            throw new IllegalArgumentException("[ERROR] 금액은 숫자여야 합니다.");
        }
    }

    private void isPositive(String machineCoinString){
        if(Integer.parseInt(machineCoinString) < 0){
            throw new IllegalArgumentException("[ERROR] 금액은 0이상이어야 합니다.");
        }
    }

    private void isDivide(String machineCoinString){
        if(Integer.parseInt(machineCoinString)%10 != 0){
            throw new IllegalArgumentException("[ERROR] 금액은 10원으로 나누어떨어져야 합니다.");
        }
    }
}