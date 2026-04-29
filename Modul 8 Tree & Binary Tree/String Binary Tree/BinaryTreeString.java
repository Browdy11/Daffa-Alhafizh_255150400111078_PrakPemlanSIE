public class BinaryTreeString {
    NodeString root;

    public void add(String data) {
        if (root == null) {
            root = new NodeString(data);
            return;
        }
        root.add(data);
    }

    // format printf dari %d menjadi %s
    public void inTraverse(NodeString node) {
        if (node == null) return;
        inTraverse(node.left);
        System.out.printf("[%s] ", node.data);
        inTraverse(node.right);
    }

    public static void main(String[] args) {
        BinaryTreeString tree = new BinaryTreeString();
        
        System.out.println("--- Proses Insert Data String ---");
        tree.add("Mangga");
        tree.add("Apel");
        tree.add("Zaitun");
        tree.add("Jeruk");
        tree.add("Pisang");
        tree.add("Anggur");
        System.out.println("Data berhasil dimasukkan!");

        System.out.println("\n--- Hasil Traversal InOrder (Abjad Otomatis Terurut) ---");
        tree.inTraverse(tree.root);
        System.out.println();
    }
}