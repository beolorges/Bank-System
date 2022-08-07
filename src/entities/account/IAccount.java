public interface IAccount {
    public void deposit(double amount);
    public void withdraw(double amount) throws Exception;
    public double getBalance();
    public String getAccountNumber();
    public IUser getUser();
    public void printExtract();
}