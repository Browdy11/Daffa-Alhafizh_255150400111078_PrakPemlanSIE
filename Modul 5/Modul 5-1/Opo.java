public class Opo extends Emoney {
    public Opo() { this.name = "Opo"; }

    @Override
    public void topUp(double amount) {
        System.out.println("Top up: " + amount);
        this.balance += amount;
        this.balance();
    }

    @Override
    public void pay(double amount) {
        double amountToPay = amount - (0.1 * amount);
        if (this.balance > amountToPay) {
            this.balance -= amountToPay;
            System.out.printf("Pay " + amount);
            System.out.println(" using " + this.name);
        } else System.out.println("Not enough balance.");
        this.balance();
    }
}