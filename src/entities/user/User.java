public class User implements IUser {
    private String _name;
    private String _cpf;
    private String _rg;
    private String _birthDate;
    private String _phoneNumber;
    private String _address;
    private String _password;

    public User(String name, String cpf, String rg, String birthDate, String phoneNumber, String address, String password) {
        this._name = name;
        this._cpf = cpf;
        this._rg = rg;
        this._birthDate = birthDate;
        this._phoneNumber = phoneNumber;
        this._address = address;
        this._password = password;
    }

    public String getName() {
        return this._name;
    }

    public String getCPF() {
        return this._cpf;
    }

    public String getRG() {
        return this._rg;
    }

    public String getBirthDate() {
        return this._birthDate;
    }

    public String getPhoneNumber() {
        return this._phoneNumber;
    }

    public String getAddress() {
        return this._address;
    }

    public String getPassword() {
        return this._password;
    }
}