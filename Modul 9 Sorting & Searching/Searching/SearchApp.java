public class SearchApp {
    public static int linearSearch(int[] arr, int search) {
        int check = 0; // tambahan No. 6: Variabel Cek
        for (int i = 0; i < arr.length; i++) {
            check++; // Mencatat jumlah pemeriksaan
            if (arr[i] == search) {
                System.out.println("Linear Search memeriksa sebanyak: " + check + " kali.");
                return i;
            }
        }
        System.out.println("Linear Search memeriksa sebanyak: " + check + " kali.");
        return -1;
    }

    public static int binarySearch(int[] arr, int search ) {
        int check = 0; // tambahan No. 6: Variabel Cek
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            check++; // Mencatat jumlah pemeriksaan
            int mid = low + (high - low) / 2;
            if (arr[mid] == search) {
                System.out.println("Binary Search memeriksa sebanyak: " + check + " kali.");
                return mid;
            }
            if (arr[mid] < search) low = mid + 1;
            else high = mid - 1;
        }
        System.out.println("Binary Search memeriksa sebanyak: " + check + " kali.");
        return -1;
    }


    public static void main(String[] args) {
        // No.1 Mendefinisikan array 30 elemen, terurut ascending (menaik), dan dipastikan ada nilai 88
        int[] arr = {2, 5, 8, 12, 15, 18, 22, 25, 29, 31, 
                     35, 38, 42, 45, 49, 52, 56, 60, 63, 67, 
                     70, 74, 79, 83, 88, 91, 94, 96, 98, 100};
        
        System.out.print("Data Array: ");
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n");


         // No.2 Memanggil fungsi linearSearch mencari nilai 88
        int hasilPencarian = linearSearch(arr, 88);
        
        System.out.println("Mencari nilai 88 menggunakan Linear Search...");
        System.out.println("Nilai variabel hasilPencarian: " + hasilPencarian);
        System.out.println();


        // No.3 Memanggil fungsi linearSearch mencari nilai yang TIDAK ADA (misal: 10)
        int nilaiTidakAda = linearSearch(arr, 10);
        
        System.out.println("Mencari nilai 10 menggunakan Linear Search...");
        System.out.println("Nilai variabel nilaiTidakAda: " + nilaiTidakAda);
        System.out.println();

        // No.4 Memanggil fungsi binarySearch mencari nilai 88
        int hasilBinary = binarySearch(arr, 88);
        
        System.out.println("Mencari nilai 88 menggunakan Binary Search...");
        System.out.println("Nilai variabel hasilBinary: " + hasilBinary);
        System.out.println();


        // No.5 Memanggil fungsi binarySearch mencari nilai yang TIDAK ADA (misal: 10)
        int hasilBinaryTidakDitemukan = binarySearch(arr, 10);
        
        System.out.println("Mencari nilai 10 menggunakan Binary Search...");
        System.out.println("Nilai variabel hasilBinaryTidakDitemukan: " + hasilBinaryTidakDitemukan);
        System.out.println();

        // No.6 Mencari nilai 88 menggunakan kedua metode dan mencatat jumlah pemeriksaan
        System.out.println("--- Mencari nilai 88 ---");
        linearSearch(arr, 88);
        binarySearch(arr, 88);
        System.out.println();

        // No.7 Mencari nilai 10 menggunakan kedua metode dan mencatat jumlah pemeriksaan
        System.out.println("--- Mencari nilai 10 (Tidak ada di Array) ---");
        linearSearch(arr, 10);
        binarySearch(arr, 10);
        System.out.println();
        
    }
}
