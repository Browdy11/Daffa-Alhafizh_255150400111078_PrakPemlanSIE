public class SingleLinkedList {
    Node head, tail;
    int size = 0;

    void init() { head = null; tail = null; size = 0; }
    boolean isEmpty() { return size == 0; }
    int size() { return size; }

    void addFirst(Node data) {
        if (isEmpty()) {
            head = data;
            tail = data;
        } else {
            data.next = head;
            head = data;
        }
        size++;
    }

    void addLast(Node data) {
        if (isEmpty()) {
            head = data;
            tail = data;
        } else {
            tail.next = data;
            tail = data;
        }
        size++;
    }

    // A. Mencari node dengan nilai tertentu
    Node findByValue(Object value) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(value)) return current;
            current = current.next;
        }
        return null;
    }

    // B. Mencari node di posisi (index) ke-n (index dimulai dari 0)
    Node findByIndex(int index) {
        if (index < 0 || index >= size) return null;
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    // C. Menghapus node di posisi (index) ke-n
    void deleteByIndex(int index) {
        if (index < 0 || index >= size) return;
        if (index == 0) {
            head = head.next;
            if (head == null) tail = null;
        } else {
            Node prev = findByIndex(index - 1);
            prev.next = prev.next.next;
            if (prev.next == null) tail = prev;
        }
        size--;
    }

    // D. Menghapus node dengan nilai data tertentu
    void deleteByValue(Object value) {
        if (isEmpty()) return;
        if (head.data.equals(value)) {
            head = head.next;
            if (head == null) tail = null;
            size--;
            return;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.data.equals(value)) {
                current.next = current.next.next;
                if (current.next == null) tail = current;
                size--;
                return;
            }
            current = current.next;
        }
    }

    // E. Menambah node di posisi (index) ke-n
    void insertAt(int index, Node data) {
        if (index < 0 || index > size) return;
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == size) {
            addLast(data);
            return;
        }
        Node prev = findByIndex(index - 1);
        data.next = prev.next;
        prev.next = data;
        size++;
    }

    // F. Menambah node SETELAH node dengan nilai data tertentu
    void insertAfter(Object value, Node data) {
        Node target = findByValue(value);
        if (target != null) {
            data.next = target.next;
            target.next = data;
            if (target == tail) tail = data;
            size++;
        }
    }

    // G. Menambah node SEBELUM node dengan nilai data tertentu
    void insertBefore(Object value, Node data) {
        if (isEmpty()) return;
        if (head.data.equals(value)) {
            addFirst(data);
            return;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.data.equals(value)) {
                data.next = current.next;
                current.next = data;
                size++;
                return;
            }
            current = current.next;
        }
    }

    // Method tambahan untuk mencetak isi list dengan mudah
    void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Uji coba 7 fungsi/method baru
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        
        System.out.println("--- Setup Awal ---");
        list.addLast(new Node("A"));
        list.addLast(new Node("B"));
        list.addLast(new Node("C"));
        list.printList(); // Harapan: A -> B -> C -> null

        System.out.println("\n--- A & B. Menguji Pencarian ---");
        System.out.println("Cari nilai 'B': " + (list.findByValue("B") != null ? "Ditemukan" : "Tidak"));
        System.out.println("Cari index ke-2: " + list.findByIndex(2).data);

        System.out.println("\n--- E. Insert At Index 1 (Nilai 'X') ---");
        list.insertAt(1, new Node("X"));
        list.printList();

        System.out.println("\n--- F. Insert After 'C' (Nilai 'D') ---");
        list.insertAfter("C", new Node("D"));
        list.printList();

        System.out.println("\n--- G. Insert Before 'B' (Nilai 'Y') ---");
        list.insertBefore("B", new Node("Y"));
        list.printList();

        System.out.println("\n--- C. Delete By Index 2 (Nilai 'Y' hilang) ---");
        list.deleteByIndex(2);
        list.printList();

        System.out.println("\n--- D. Delete By Value 'X' ---");
        list.deleteByValue("X");
        list.printList();
    }
}