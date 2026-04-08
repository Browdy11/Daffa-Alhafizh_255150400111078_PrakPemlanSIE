public class AmongUsGame {
    public static void main(String[] args) {
        Crew brian, cindy, david;
        Impostor jacky;

        brian = new Crew("Brian");
        cindy = new Crew("Cindy");
        david = new Crew("David");
        jacky = new Impostor("Jacky");

        brian.doWork();
        cindy.doWork();
        david.doWork();
        jacky.doWork();

        // Jacky membunuh Cindy
        jacky.kill(cindy);

        // Menguji soal nomor 8: Cindy (yang sudah mati) mencoba memanggil meeting
        cindy.callMeeting();

        // David (yang masih hidup) memanggil meeting
        david.callMeeting();

        AmongUsGame.check(brian);
        AmongUsGame.check(david);
        AmongUsGame.check(jacky);

        // Menguji soal nomor 7: Mengeluarkan impostor
        jacky.kick();
    }

    public static void check(ICrew crew) {
        if (AmongUsGame.isImpostor(crew)) {
            System.out.println(crew.getName() + " is the impostor!");
        } else {
            System.out.println(crew.getName() + " is not the impostor.");
        }
    }

    public static boolean isImpostor(ICrew crew) {
        return (crew instanceof Impostor);
    }
}