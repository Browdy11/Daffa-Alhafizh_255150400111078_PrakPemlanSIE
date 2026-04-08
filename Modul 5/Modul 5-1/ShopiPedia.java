public class ShopiPedia {
    public static void main(String[] args) {
        ShopiPay shopiCard = new ShopiPay();
        Customer miki = new Customer(shopiCard);
        miki.deposit(10000);
        miki.pay(2000);
        miki.pay(3000);
        miki.deposit(1000);
        miki.pay(7000);

        System.out.println("------------------");

        Opo opoCard = new Opo();
        Customer dono = new Customer(opoCard);
        dono.deposit(10000);
        dono.pay(2000);
        dono.pay(3000);
        dono.deposit(1000);
        dono.pay(7000);

        System.out.println("------------------");

        // Tambahan dari soal analisis nomor 4: Implementasi objek Kris (Anonymous Inner Class)
        Emoney krisCard = new Emoney() {
            // Blok inisialisasi (Initialization Block) untuk mengisi atribut nama
            { this.name = "Kris"; } 

            @Override
            public void topUp(double amount) {
                System.out.println("Top up: " + amount);
                this.balance += (amount + (0.05 * amount)); // Bonus 5%
                this.balance();
            }

            @Override
            public void pay(double amount) {
                double amountToPay = amount - (0.03 * amount); // Diskon 3%
                if (this.balance > amountToPay) {
                    this.balance -= amountToPay;
                    System.out.printf("Pay " + amount);
                    System.out.println(" using " + this.name);
                } else System.out.println("Not enough balance.");
                this.balance();
            }
        };

        // Menguji objek Kris dengan skenario transaksi yang sama (Misal pelanggannya bernama Joko)
        Customer joko = new Customer(krisCard);
        joko.deposit(10000);
        joko.pay(2000);
        joko.pay(3000);
        joko.deposit(1000);
        joko.pay(7000);
    }
}