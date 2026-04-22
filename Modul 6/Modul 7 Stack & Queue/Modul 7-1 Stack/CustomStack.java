public class CustomStack {
    Node top;
    int size = 0;

    public void push(int x) {
        Node n = new Node(x);
        n.next = top;
        top = n;
        size++;
    }

    public int pop() {
        if (top == null)
            throw new RuntimeException("Stack is empty.");
        int val = top.data;
        top = top.next;
        size--;
        return val;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int peek() {
    if (top == null)
        throw new RuntimeException("Stack is empty.");
    return top.data;
    }

    // Jawaban Data dan Analisis Nomor 1
    public static void main(String[] args) {
        // --Nomor 1--
        // CustomStack custom = new CustomStack();
        // custom.push(1);
        // custom.push(2);
        // custom.push(3);
        
        // System.out.print("Custom Stack: ");
        // while (!custom.isEmpty()) {
        //     System.out.print(" [" + custom.pop() + "]");
        // }
        // System.out.println("\nEnd.");

        
        // --Nomor 2: Demonstrasi peek() method--
        // CustomStack custom2 = new CustomStack();
        // custom2.push(10);
        // custom2.push(20);

        // System.out.println("Demo Peek (Melihat elemen atas): " + custom2.peek());
        // System.out.println("Elemen atas setelah di-peek tidak hilang. Buktinya, pop selanjutnya: " + custom2.pop());


        // --Nomor 3--
        // CustomStack custom = new CustomStack();
        // custom.push(1);
        // custom.push(2);
        // custom.push(3);
        
        // System.out.print("Custom Stack: ");
        // while (!custom.isEmpty()) {
        //     System.out.print(" [" + custom.pop() + "]");
        // }
        // System.out.println("\nEnd.");
        // System.out.println(custom.pop());


        // --Nomor 4--
        CustomStack custom = new CustomStack();

        // Kondisi awal (1, 2, 3, 4 masuk berurutan)
        custom.push(1);
        custom.push(2);
        custom.push(3);
        custom.push(4);

        // Misi: Menyisipkan angka 5 di antara 1 dan 2
        // Langkah 1: Mengeluarkan dan menyimpan 4, 3, dan 2 ke variabel sementara
        int temp4 = custom.pop();
        int temp3 = custom.pop();
        int temp2 = custom.pop();

        // Langkah 2: Menyisipkan angka 5
        custom.push(5);

        // Langkah 3: Memasukkan kembali 2, 3, dan 4
        custom.push(temp2);
        custom.push(temp3);
        custom.push(temp4);

        // Menampilkan hasil
        System.out.print("Custom Stack (Isi setelah disisipkan): ");
        while (!custom.isEmpty()) {
            System.out.print(" [" + custom.pop() + "]");
        }
    }
}