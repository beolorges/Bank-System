public interface IBank {
    public void createAccount(String name, String cpf, String rg, String birthDate, String phoneNumber, String address, String password, String accountType) throws Exception;
    public void deleteAccount(String cpf, String password, IAccount account);
    public IAccount getAccount(String cpf, String password, String accountNumber) throws Exception;
    public ArrayList<IAccount> getAccounts(String cpf, String password);
    public void createUser(String name, String cpf, String rg, String birthDate, String phoneNumber, String address, String password);
    public void deleteUser(String cpf, String password);
    public IUser getUser(String cpf, String password);
    public void deposit(String cpf, String password, double amount, IAccount account);
    public void withdraw(String cpf, String password, double amount, IAccount account);
    public double getBalance(String cpf, String password, IAccount account);
    public void printExtract(String cpf, String password, IAccount account);
}