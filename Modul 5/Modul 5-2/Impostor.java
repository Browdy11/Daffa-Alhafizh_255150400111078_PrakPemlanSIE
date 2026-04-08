public class Impostor implements IImpostor, ICrew {
    private final String name;

    public Impostor(String name) {
        this.name = name;
    }

    @Override
    public void kill(ICrew crew) {
        System.out.println(crew.getName() + " has been killed!");
        // Mengubah status target menjadi mati (Soal nomor 8)
        if (crew instanceof Crew) {
            ((Crew) crew).isDead = true; 
        }
    }

    @Override
    public void doWork() {
        System.out.println("Impostor " + this.name + " is doing work.");
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void kick() { // Implementasi dari IPlayer (Soal nomor 7)
        System.out.println(this.name + " was kicked from the spaceship.");
    }
}