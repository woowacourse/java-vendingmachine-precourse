package vendingmachine.model;

public class Machine {

    private final MachineMoney machineMoney;
    private final Products products;
    private final Budget budget;
    private MachineStatus machineStatus;

    public Machine(MachineMoney machineMoney, Products products, Budget budget) {
        this.machineMoney = machineMoney;
        this.products = products;
        this.budget = budget;
        this.machineStatus = MachineStatus.AVAILABLE;
    }

    public static Machine by(MachineMoney machineMoney, Products products, Budget budget) {
        return new Machine(machineMoney, products, budget);
    }

    public boolean isAvailable() {
        return this.machineStatus.isAvailable();
    }

    public void updateMachineStatus(MachineStatus machineStatus) {
        this.machineStatus = machineStatus;
    }


}
