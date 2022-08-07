import java.util.ArrayList;

public class Bank implements IBank{
    private ArrayList<IAccount> _accounts;
    private ArrayList<IUser> _users;

    public Bank() {
        this._accounts = new ArrayList<IAccount>();
        this._users = new ArrayList<IUser>();
    }

    public void createAccount(String name, String cpf, String rg, String birthDate, String phoneNumber, String address, String password, String accountType, Double... initialFunds ) throws Exception {
        IUser user = new User(name, cpf, rg, birthDate, phoneNumber, address, password);
        IAccount account = null;
        switch (accountType) {
            case "SavingsAccount":
                account = new SavingsAccount(user, initialFunds[0]);
                break;

            case "CurrencyAccount":
                account = new CurrencyAccount(user);
                break;
        
            default:
                throw new Exception("Invalid account type");
        }
        this._accounts.add(account);
        this._users.add(user);
    }

    public void deleteAccount(String cpf, String password, IAccount account) throws Exception {
        IUser user = this.getUser(cpf, password);
        if (user == null) {
            throw new Exception("Invalid user");
        }
        if (this._accounts.contains(account)) {
            if(account.getUser() == user){
                this._accounts.remove(account);
            }
            throw new Exception("This account doesn't belong to this user");
        }
        throw new Exception("Invalid account");
    }

    public IAccount getAccount(String cpf, String password, String accountNumber) throws Exception {
        IUser user = this.getUser(cpf, password);
        if (user == null) {
            throw new Exception("Invalid user");
        }
        for (IAccount account : this._accounts) {
            if (account.getUser() == user && account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        throw new Exception("Invalid account");
    }

    public ArrayList<IAccount> getAccounts(String cpf, String password) {
        ArrayList<IAccount> accounts = new ArrayList<IAccount>();
        for (IAccount account : this._accounts) {
            if (account.getUser().getCPF().equals(cpf) && account.getUser().getPassword().equals(password)) {
                accounts.add(account);
            }
        }
        return accounts;
    }

    public void createUser(String name, String cpf, String rg, String birthDate, String phoneNumber, String address, String password) {
        IUser user = new User(name, cpf, rg, birthDate, phoneNumber, address, password);
        this._users.add(user);
    }

    public void deleteUser(String cpf, String password) {
        IUser user = this.getUser(cpf, password);
        if (user != null) {
            for (IAccount account : this._accounts) {
                if (account.getUser().getCPF().equals(cpf) && account.getUser().getPassword().equals(password)) {
                    this._accounts.remove(account);
                }
            }
            this._users.remove(user);
        }
    }

    public IUser getUser(String cpf, String password) {
        for (IUser user : this._users) {
            if (user.getCPF().equals(cpf) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public void deposit(String cpf, String password, double amount, IAccount account) throws Exception {
        validUserData(cpf, password, account);
        account.deposit(amount);
    }

    public void withdraw(String cpf, String password, double amount, IAccount account) throws Exception {
        validUserData(cpf, password, account);
        account.withdraw(amount);
    }

    public double getBalance(String cpf, String password, IAccount account) throws Exception {
        validUserData(cpf, password, account);
        return account.getBalance();
    }

    public void printExtract(String cpf, String password, IAccount account) throws Exception {
        validUserData(cpf, password, account);
        account.printExtract();
    }

    private void validUserData(String cpf, String password, IAccount account) throws Exception {
        IUser user = this.getUser(cpf, password);
        if (user == null) {
            throw new Exception("Invalid user");
        }
        if (this._accounts.contains(account)) {
            if(account.getUser() == user){
                return;
            }
            throw new Exception("This account doesn't belong to this user");
        }
        throw new Exception("Invalid account");
    }

}