public Interface IAccount {
    public void deposit(double amount);
    public void withdraw(double amount);
    public double getBalance();
    public IUser getUser();
}