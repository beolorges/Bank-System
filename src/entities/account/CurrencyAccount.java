public class CurrencyAccount extends Account {
    public CurrencyAccount(IUser user) {
        super(user);
    }

    @Override public void withdraw(double amount) {
        this._amount -= amount;
    }

    @Override public void printExtract(){
        System.out.println("--------------- Extract Currency Account --------------");
        super.printExtract();
    }

}