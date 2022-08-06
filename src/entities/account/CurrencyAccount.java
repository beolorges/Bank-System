public class CurrencyAccount extends Account {
    public CurrencyAccount(IUser user) {
        super(user);
    }

    override public void withdraw(double amount) {
        this._amount -= amount;
    }

    override public void printExtract(){
        System.out.println("--------------- Extract Currency Account --------------")
        super.printExtract();
    }

}