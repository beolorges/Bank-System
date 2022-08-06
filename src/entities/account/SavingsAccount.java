public class SavingsAccount extends Account {
    private static double TAX = 0.01;
    private double _initialAmount;
        
    public SavingsAccount(IUser user, double initialAmount) {
        super(user);
        this._initialAmount = initialAmount;
    }

    public void yieldFunds() {
        this._amount += this._amount * TAX;
    }

    override public void printExtract(){
        System.out.println("--------------- Extract Savings Account --------------")
        super.printExtract();
        System.out.println("Your account yielded: " + (super.getBalance() - this._initialAmount));
    }

}