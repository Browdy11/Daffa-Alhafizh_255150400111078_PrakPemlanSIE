import java.util.Arrays;
public class SortApp {

    // // No .1 Membuat fungsi untuk masing-masing algoritma pengurutan (bubble, insertion, selection)
    // public static int[] bubble(int[] list) {
    //     for (int i = 0; i < list.length - 1; i++) {
    //         for (int k = i + 1; k < list.length; k++) {
    //             // System.out.printf("%d:%d\n", list[k], list[i]); //  dicomment agar output rapi nantinya
    //                         // Comment baris sesuai pengurutan yang diinginkan (ascending atau descending)
    //             if (list[k] < list[i]) { //Pengurutan ascending (awal)
    //             // if (list[k] > list[i]) { //Pengurutan descending (No.5 Modifikasi algoritma menjadi descending)
    //                 int t = list[i];
    //                 list[i] = list[k];
    //                 list[k] = t;
    //             }
    //         }
    //     }
    //     return list;
    // }

    // public static int[] insertion(int[] list) {
    //     for (int i = 1; i < list.length; ++i) {
    //         int key = list[i];
    //         int k = i - 1;
    //                  // Comment baris sesuai pengurutan yang diinginkan (ascending atau descending)
    //         while (k >= 0 && list[k] > key) { // Pengurutan ascending (awal)
    //         // while (k >= 0 && list[k] < key) { // Pengurutan descending (No.5 Modifikasi algoritma pengurutan menjadi descending)
    //             list[k + 1] = list[k];
    //             k = k - 1;
    //         }
    //         list[k + 1] = key;
    //     }
    //     return list;
    // }

    // public static int[] selection(int[] list) {
    //     for (int i = 0; i < list.length - 1; i++) {
    //         int minIndex = i;
    //         for (int k = i + 1; k < list.length; k++) {
    //                     // Comment baris sesuai pengurutan yang diinginkan (ascending atau descending)
    //             if (list[k] < list[minIndex]) // Pengurutan ascending (awal)
    //             // if (list[k] > list[minIndex]) // Pengurutan descending (No.5 Modifikasi algoritma pengurutan menjadi descending)
    //                 minIndex = k;
    //         }
    //         int t = list[minIndex];
    //         list[minIndex] = list[i];
    //         list[i] = t;
    //     }
    //     return list;
    // }

    // No. 6 Modifikasi algoritma untuk menghitung jumlah pertukaran (tukar) atau pergeseran (geser)
    // 1. Modifikasi Bubble Sort (kembali ke Ascending untuk standar perbandingan)
    public static int[] bubble(int[] list) {
        int tukarAtauGeser = 0; // Deklarasi variabel
        for (int i = 0; i < list.length - 1; i++) {
            for (int k = i + 1; k < list.length; k++) {
                if (list[k] < list[i]) {
                    int t = list[i];
                    list[i] = list[k];
                    list[k] = t;
                    tukarAtauGeser++; // Mencatat jumlah pertukaran
                }
            }
        }
        System.out.println("\nJumlah tukar Bubble Sort: " + tukarAtauGeser);
        return list;
    }

    // 2. Modifikasi Insertion Sort
    public static int[] insertion(int[] list) {
        int tukarAtauGeser = 0; // Deklarasi variabel
        for (int i = 1; i < list.length; ++i) {
            int key = list[i];
            int k = i - 1;
            while (k >= 0 && list[k] > key) {
                list[k + 1] = list[k];
                k = k - 1;
                tukarAtauGeser++; // Mencatat jumlah pergeseran
            }
            list[k + 1] = key;
        }
        System.out.println("\nJumlah geser Insertion Sort: " + tukarAtauGeser);
        return list;
    }

    // 3. Modifikasi Selection Sort
    public static int[] selection(int[] list) {
        int tukarAtauGeser = 0; // Deklarasi variabel
        for (int i = 0; i < list.length - 1; i++) {
            int minIndex = i;
            for (int k = i + 1; k < list.length; k++) {
                if (list[k] < list[minIndex])
                    minIndex = k;
            }
            // Swap
            int t = list[minIndex];
            list[minIndex] = list[i];
            list[i] = t;
            tukarAtauGeser++; // Mencatat jumlah pertukaran
        }
        System.out.println("\nJumlah tukar Selection Sort: " + tukarAtauGeser);
        return list;
    }



public static void main(String[] args) {
        // No.2 Mendeklarasikan dan mendefinisikan array dengan 30 elemen unik (acak dari 1-100)
        int arr[] = {45, 12, 89, 33, 76, 2, 99, 54, 21, 67, 3, 88, 14, 56, 78, 1, 90, 43, 22, 65, 8, 39, 71, 19, 50, 9, 81, 27, 60, 31};
        
        // No. 3 Menampilkan array sebelum diurutkan
        System.out.println("Array Belum Terurut:");
        System.out.println(Arrays.toString(arr));

        // No. 4 memanggil fungsi insertion, bubble, dan selection
            // Menggunakan .clone() agar array 'data' asli tidak ikut berubah saat diuji coba berulang kali
        int[] sortedBubble = bubble(arr.clone());
        System.out.println("Setelah Bubble Sort:");
        System.out.println(Arrays.toString(sortedBubble));

        int[] sortedInsertion = insertion(arr.clone());
        System.out.println("Setelah Insertion Sort:");
        System.out.println(Arrays.toString(sortedInsertion));

        int[] sortedSelection = selection(arr.clone());
        System.out.println("Setelah Selection Sort:");
        System.out.println(Arrays.toString(sortedSelection));


    }
}