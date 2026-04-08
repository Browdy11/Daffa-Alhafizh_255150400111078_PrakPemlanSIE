public abstract class Emoney {
    protected double balance;
    protected String name;

    public abstract void topUp(double amount);
    public abstract void pay(double amount);

    public void balance() {
        System.out.print(this.name + " balance: ");
        System.out.println(String.valueOf(this.balance));
    }
}