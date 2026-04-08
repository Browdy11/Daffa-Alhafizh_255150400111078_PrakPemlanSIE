public class Customer {
    private final Emoney account;

    public Customer(Emoney account) {
        this.account = account;
    }

    public void pay(double amount) {
        this.account.pay(amount);
    }

    public void deposit(double amount) {
        this.account.topUp(amount);
    }

    public void getMoney() {
        this.account.balance();
    }
}