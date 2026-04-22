public class CustomQueue {
    private Node head, tail;
    private int size = 0;

    public void enqueue(int x) {
        Node n = new Node(x);
        if (tail != null) tail.next = n;
        tail = n;
        if (head == null) head = tail;
        size++;
    }

    public int dequeue() {
        if (head == null)
            throw new RuntimeException("Queue is empty.");
        int val = head.data;
        head = head.next;
        if (head == null) tail = null;
        size--;
        return val;
    }

    public boolean isEmpty() {
        return head == null;
    }

    // Tambahan Method No.3
    public void print() {
        Node current = head;
        System.out.print("Isi Queue saat ini: ");
        while (current != null) {
            System.out.print("[" + current.data + "] ");
            current = current.next;
        }
        System.out.println();
    }

    // Tambahan Method No.4
    public void peek() {
        if (head == null) {
            System.out.println("Tidak ada antrian");
        } else {
            System.out.println("Elemen terdepan: " + head.data);
        }
    }

    // // --- Jawaban Soal Nomor 1 ---
    public static void main(String[] args) {
    //     CustomQueue queue = new CustomQueue();
    //     queue.enqueue(5);
    //     queue.enqueue(15);
    //     queue.enqueue(25);
        

    //     // Tambahan untuk Nomor 2
    //     queue.dequeue(); // Mengeluarkan 1 elemen dari depan
    //     queue.enqueue(35); // Memasukkan 35 ke belakang
    //     queue.enqueue(45); // Memasukkan 45 ke belakang

    //     System.out.print("Custom Queue: ");
    //     while (!queue.isEmpty()) {
    //         System.out.print(queue.dequeue() + " ");
    //     }
    //     System.out.println();


        // // --Demo untuk Nomor 3--
        // CustomQueue queue = new CustomQueue();
        // queue.enqueue(10);
        // queue.enqueue(20);
        // queue.enqueue(30);

        // // memanggil fungsi prin
        // queue.print(); 


        // --Demo untuk Nomor 4--
        CustomQueue queue = new CustomQueue();

        // Demo saat kosong
        queue.peek(); 

        // Demo saat ada isinya
        queue.enqueue(100);
        queue.enqueue(200);
        queue.peek();

        // Bukti data tidak hilang setelah di-peek
        queue.print();
    }
}