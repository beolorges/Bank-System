
public abstract Account implements IAccount {
    private static int AGENCY_NUMBER = 1;
    private static int ACCOUNT_NUMBER = 1;
    
    protected double _amount;
    protected IUser _user;
    protected int _agency;
    protected String _accountNumber;
    
    public Account(IUser user) {
        this._amount = 0;
        this._agency = AGENCY_NUMBER++;
        this._accountNumber = String.format("%09d",ACCOUNT_NUMBER++);
        this._user = user;
    }
    
    public void deposit(double amount){
        this._amount += amount;
    };

    public void withdraw(double amount){
        if(this._amount >= amount){
            this._amount -= amount;
            return;
        }
        throw new Exception("Insufficient funds");
    };

    public double getBalance(){
        return this._amount;
    };


    public void printExtract(){
        System.out.println("Agency: " + this._agency);
        System.out.println("Account number: " + this._accountNumber);
        System.out.println("Balance: " + this._amount);
        System.out.println("User: " + this._user.getName());
    };

    public IUser getUser(){
        return this._user;
    };
}