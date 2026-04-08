public class Crew implements ICrew {
    private String name;
    public boolean isDead = false; // Status awal hidup (Dari soal nomor 8)

    public Crew(String name) {
        this.name = name;
    }

    @Override
    public void doWork() {
        System.out.println("Crew " + this.name + " is doing work.");
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void kick() { // Implementasi dari IPlayer (Soal nomor 7)
        System.out.println(this.name + " was kicked from the spaceship.");
    }

    public void callMeeting() {
        // Cek apakah crew sudah mati (Soal nomor 8)
        if (this.isDead) {
            System.out.println(this.name + " is dead and cannot call a meeting.");
            return;
        }
        System.out.print(this.name + " found a corpse ");
        System.out.print("and calls a meeting. ");
        System.out.println("Let's find the impostor!");
    }
}