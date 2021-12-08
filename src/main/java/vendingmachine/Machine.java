package vendingmachine;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Machine {
    private StringManager stringManager=new StringManager();

    private Coin[] coins = Coin.values();

    public Machine() {}



    public void setHeldAmountInMachine() {
        int heldAmount=getHeldAmountInMachine();

    }

    private int getHeldAmountInMachine(){
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        while(true){
            String heldAmountInMachine = readLine();
            try{
                int heldAmount=stringManager.toAmount(heldAmountInMachine);
                return heldAmount;
            }
            catch(IllegalArgumentException e){
                System.out.println("[ERROR] 금액은 10으로 나누어 떨어지는 자연수여야 합니다.");
            }
        }
    }

}
