package vendingmachine.view;

public class OutputView {

    public static void printVendingMachineCoins(int[] coins){
        String[] coinName = {"500","100","50","10"};
        System.out.println("자판기가 보유한 동전");
        for(int i = 0; i < 4; i++){
            System.out.printf("%s원 - %s개 \n",coinName[i],coins[i]);
        }
    }

}
