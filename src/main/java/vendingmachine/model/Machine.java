package vendingmachine.model;

public class Machine {

    private final MachineMoney machineMoney;
    private final Products products;
    private Product purchaseProduct;
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

    public void purchaseProduct(Product product) {
        this.purchaseProduct = product;
    }

    public boolean isOutOfStock(){
        return !purchaseProduct.hasStock();
    }

    public boolean isOutOfBudget(){
        return !budget.isAffordable(purchaseProduct);
    }

    public boolean isAbleToBuy(){
        return purchaseProduct.hasStock() && budget.isAffordable(purchaseProduct);
    }

    public void purchase(){
        budget.buy(purchaseProduct);
        products.buy(purchaseProduct);
    }


}
