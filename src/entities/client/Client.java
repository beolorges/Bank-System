
import javax.swing.JOptionPane;
public class Client implements IClient {
    private static IBank _bank;

    public Client() {
        _bank = new Bank();
    }

    private void createAccount() {
        String name = JOptionPane.showInputDialog("Name: ");
        String cpf = JOptionPane.showInputDialog("CPF: ");
        String rg = JOptionPane.showInputDialog("RG: ");
        String birthDate = JOptionPane.showInputDialog("Birth date: ");
        String phoneNumber = JOptionPane.showInputDialog("Phone number: ");
        String address = JOptionPane.showInputDialog("Address: ");
        String password = JOptionPane.showInputDialog("Password: ");
        String accountTypeSwitch = JOptionPane.showInputDialog("Account type:\n1 - Savings account\n2 - Currency account\n");
        String accountType = "";
        boolean validAccountType = false;
        
        do{
            switch(accountTypeSwitch){
                case "1":
                    accountType = "SavingsAccount";
                    validAccountType = true;
                    break;

                case "2":
                    accountType = "CurrencyAccount";
                    validAccountType = true;
                    break;

                default:
                    accountTypeSwitch = JOptionPane.showInputDialog("Invalid account type. Please, try again:\n1 - Savings account\n2 - Currency account\n");
                    break;
            }
        }while(!validAccountType);

        try {
            _bank.createAccount(name, cpf, rg, birthDate, phoneNumber, address, password, accountType);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        JOptionPane.showMessageDialog(null, "Account created successfully");
    }

    private void deleteAccount() {
        String cpf = JOptionPane.showInputDialog("CPF: ");
        String password = JOptionPane.showInputDialog("Password: ");
        String accountNumber = JOptionPane.showInputDialog("Account number: ");
        try {
            IAccount account = _bank.getAccount(cpf, password, accountNumber);
            _bank.deleteAccount(cpf, password, account);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        JOptionPane.showMessageDialog(null, "Account deleted");
    }


    private void deposit() {
        String cpf = JOptionPane.showInputDialog("CPF: ");
        String password = JOptionPane.showInputDialog("Password: ");
        String accountNumber = JOptionPane.showInputDialog("Account number: ");
        double amount = Double.parseDouble(JOptionPane.showInputDialog("Amount: "));
        try {
            IAccount account = _bank.getAccount(cpf, password, accountNumber);
            _bank.deposit(cpf, password, amount, account);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        JOptionPane.showMessageDialog(null, "Deposit successful");
    }

    private void withdraw() {
        String cpf = JOptionPane.showInputDialog("CPF: ");
        String password = JOptionPane.showInputDialog("Password: ");
        String accountNumber = JOptionPane.showInputDialog("Account number: ");
        double amount = Double.parseDouble(JOptionPane.showInputDialog("Amount: "));
        try {
            IAccount account = _bank.getAccount(cpf, password, accountNumber);
            _bank.withdraw(cpf, password, amount, account);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        JOptionPane.showMessageDialog(null, "Withdraw successful");
    }

    private void getBalance() {
        String cpf = JOptionPane.showInputDialog("CPF: ");
        String password = JOptionPane.showInputDialog("Password: ");
        String accountNumber = JOptionPane.showInputDialog("Account number: ");
        try {
            IAccount account = _bank.getAccount(cpf, password, accountNumber);
            double balance = _bank.getBalance(cpf, password, account);
            JOptionPane.showMessageDialog(null, "Balance: " + balance);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void printExtract() {
        String cpf = JOptionPane.showInputDialog("CPF: ");
        String password = JOptionPane.showInputDialog("Password: ");
        String accountNumber = JOptionPane.showInputDialog("Account number: ");
        try {
            IAccount account = _bank.getAccount(cpf, password, accountNumber);
            _bank.printExtract(cpf, password, account);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void menu() {
        while(true){

            String option = JOptionPane.showInputDialog("1 - Create account\n2 - Delete account\n3 - Deposit\n4 - Withdraw\n5 - Get balance\n6 - Print extract\n7 - Exit\n");
            boolean validOption = false;
            do{
                switch(option){
                    case "1":
                        this.createAccount();
                        validOption = true;
                        break;
    
                    case "2":
                        this.deleteAccount();
                        validOption = true;
                        break;
    
                    case "3":
                        this.deposit();
                        validOption = true;
                        break;
    
                    case "4":
                        this.withdraw();
                        validOption = true;
                        break;
    
                    case "5":
                        this.getBalance();
                        validOption = true;
                        break;
    
                    case "6":
                        this.printExtract();
                        validOption = true;
                        break;
    
                    case "7":
                        System.exit(0);
                        validOption = true;
                        break;
    
                    default:
                        option = JOptionPane.showInputDialog("Invalid option. Please, try again:\n1 - Create account\n2 - Delete account\n3 - Deposit\n4 - Withdraw\n5 - Get balance\n6 - Print extract\n7 - Exit\n");
                        break;
                }
            }while(!validOption);
        }
    }
}