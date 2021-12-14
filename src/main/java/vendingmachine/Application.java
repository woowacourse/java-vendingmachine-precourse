package vendingmachine;


import vendingmachine.machine.Machine;
import vendingmachine.machine.MachineController;
import vendingmachine.view.Input;
import vendingmachine.view.Output;

public class Application {

    public static void main(String[] args) {
       MachineController machineController = new MachineController();
       Machine machine = new Machine();
       machineController.init(machine);

       while(true){
           if (!machine.isRun()){
               machineController.end(machine);
               return;
           }
           machineController.buy(machine);
       }




    }
}
