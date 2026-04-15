public class Node {
    Object data;
    Node next;

    // Tambahan constructor kosong
    Node() {}

    // Tambahan constructor dengan parameter data (Sesuai modul Percobaan 2)
    Node(Object data) {
        this.data = data;
    }

    // Method main dari percobaan 1
    public static void main(String[] args) {
        
        Node node = new Node();
        node.data = "A";

        System.out.println("node    : " + node);
        System.out.println("data    : " + node.data);
        System.out.println("pointer : " + node.next);
    }
}