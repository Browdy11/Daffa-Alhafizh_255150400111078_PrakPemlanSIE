import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    Node root;

    public void add(int data) {
        if (root == null) {
            root = new Node(data);
            return;
        }
        root.add(data);
    }

    public void preTraverse(Node node) {
        if (node == null) return;
        System.out.printf("[%d]", node.data);
        preTraverse(node.left);
        preTraverse(node.right);
    }

    public void inTraverse(Node node) {
        if (node == null) return;
        inTraverse(node.left);
        System.out.printf("[%d]", node.data);
        inTraverse(node.right);
    }

    public void postTraverse(Node node) {
        if (node == null) return;
        postTraverse(node.left);
        postTraverse(node.right);
        System.out.printf("[%d]", node.data);
    }

    // --- Jawaban Nomor 5: Menghitung Total Node ---
    public int countNodes(Node node) {
        if (node == null) {
            return 0; // Jika kosong, kembalikan 0
        }
        // Hitung node ini (1) + jumlah node di cabang kiri + jumlah node di cabang kanan
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    // --- Jawaban Nomor 6: Menghitung Total Daun (Leaf) ---
    public int countLeaves(Node node) {
        if (node == null) {
            return 0; // Jika kosong, bukan daun
        }
        // Jika tidak punya anak kiri dan tidak punya anak kanan, maka ia adalah daun (1)
        if (node.left == null && node.right == null) {
            return 1;
        }
        // Jika bukan daun, cari terus ke bawah
        return countLeaves(node.left) + countLeaves(node.right);
    }

    // --- Jawaban Nomor 7: Menghitung Tinggi Pohon (Height) ---
    public int getHeight(Node node) {
        if (node == null) {
            return 0; // Jika kosong, tingginya 0
        }
        // Hitung tinggi cabang kiri dan kanan
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        
        // Ambil yang paling tinggi (max) lalu tambah 1 (untuk menghitung level root)
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // --- Jawaban Nomor 9: Level Order Traversal ---
    public void levelTraverse(Node root) {
        if (root == null) return;
        
        // 1. Create an empty queue Q
        Queue<Node> q = new LinkedList<>();
        
        // 2. Enqueue the root node
        q.add(root);
        
        // 3. Loop while Q is not empty
        while (!q.isEmpty()) {
            // a. Dequeue a node and visit it
            Node current = q.poll();
            System.out.printf("[%d]", current.data);
            
            // b. Enqueue the left child if it exists
            if (current.left != null) {
                q.add(current.left);
            }
            // c. Enqueue the right child if it exists
            if (current.right != null) {
                q.add(current.right);
            }
        }
    }

    // --- JAWABAN NOMOR 1 & 2 ---
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        // System.out.println("--- Proses Insert Data Random ---");
        
        // // Loop 10 kali untuk generate angka 1 s.d 100
        // for (int i = 0; i < 10; i++) {
        //     // Ditambah 1 agar nilainya 1-100 (tidak ada angka 0)
        //     int nilai = (int) (Math.random() * 100) + 1; 
        //     System.out.printf("Nilai %d dimasukkan.\n", nilai);
        //     tree.add(nilai);
        // }

        // Data random yang sudah digenerate pertama kali dipakai lagi
        // agar hasil soal selanjutnya konsisten
        tree.add(67);
        tree.add(65);
        tree.add(71);
        tree.add(36);
        tree.add(88);
        tree.add(7);
        tree.add(40);
        tree.add(79);
        tree.add(31);
        tree.add(51);
        
        
        // --- JAWABAN NOMOR 4 ---
        System.out.println("\n--- Traversal PreOrder ---");
        tree.preTraverse(tree.root);
        
        System.out.println("\n--- Traversal InOrder ---");
        tree.inTraverse(tree.root);
        
        System.out.println("\n--- Traversal PostOrder ---");
        tree.postTraverse(tree.root);
        

        // --- DEMO NOMOR 5, 6, 7 ---
        System.out.println("\n\n--- Hasil Perhitungan Pohon ---");
        System.out.println("Banyaknya Node   : " + tree.countNodes(tree.root));
        System.out.println("Banyaknya Daun   : " + tree.countLeaves(tree.root));
        System.out.println("Tinggi Pohon     : " + tree.getHeight(tree.root));

        // --- Demo Nomor 8 ada di folder String Binary Tree ---

        // --- DEMO NOMOR 9 ---
        System.out.println("\n--- Traversal Level Order ---");
        tree.levelTraverse(tree.root);
        System.out.println();

    }
}