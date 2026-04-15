public class DoubleLinkedList {
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
            head.prev = data;
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
            data.prev = tail;
            tail = data;
        }
        size++;
    }

    void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Jawaban Nomor 7: Print dari belakang
    void printFromBack() {
        Node current = tail;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.prev;
        }
        System.out.println("null");
    }

    // 8.A. Mencari node dengan nilai tertentu
    Node findByValue(Object value) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(value)) return current;
            current = current.next;
        }
        return null;
    }

    // 8.B. Mencari node di posisi (index) ke-n
    Node findByIndex(int index) {
        if (index < 0 || index >= size) return null;
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    // 8.C. Menghapus node di posisi (index) ke-n
    void deleteByIndex(int index) {
        if (index < 0 || index >= size) return;
        if (index == 0) {
            head = head.next;
            if (head != null) head.prev = null;
            else tail = null;
        } else {
            Node target = findByIndex(index);
            Node prevNode = target.prev;
            Node nextNode = target.next;
            
            prevNode.next = nextNode;
            if (nextNode != null) nextNode.prev = prevNode;
            else tail = prevNode;
        }
        size--;
    }

    // 8.D. Menghapus node dengan nilai data tertentu
    void deleteByValue(Object value) {
        Node target = findByValue(value);
        if (target == null) return;
        
        if (target == head) {
            head = head.next;
            if (head != null) head.prev = null;
            else tail = null;
        } else {
            Node prevNode = target.prev;
            Node nextNode = target.next;
            
            prevNode.next = nextNode;
            if (nextNode != null) nextNode.prev = prevNode;
            else tail = prevNode;
        }
        size--;
    }

    // 8.E. Menambah node di posisi (index) ke-n
    void insertAt(int index, Node data) {
        if (index < 0 || index > size) return;
        if (index == 0) { addFirst(data); return; }
        if (index == size) { addLast(data); return; }
        
        Node target = findByIndex(index);
        Node prevNode = target.prev;
        
        prevNode.next = data;
        data.prev = prevNode;
        data.next = target;
        target.prev = data;
        size++;
    }

    // 8.F. Menambah node setelah node dengan nilai data tertentu
    void insertAfter(Object value, Node data) {
        Node target = findByValue(value);
        if (target != null) {
            Node nextNode = target.next;
            target.next = data;
            data.prev = target;
            data.next = nextNode;
            
            if (nextNode != null) nextNode.prev = data;
            else tail = data;
            size++;
        }
    }

    // 8.G. Menambah node sebelum node yang memiliki nilai data tertentu
    void insertBefore(Object value, Node data) {
        Node target = findByValue(value);
        if (target != null) {
            if (target == head) {
                addFirst(data);
            } else {
                Node prevNode = target.prev;
                prevNode.next = data;
                data.prev = prevNode;
                data.next = target;
                target.prev = data;
                size++;
            }
        }
    }

    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();

        System.out.println("--- Setup Awal ---");
        list.addLast(new Node("A"));
        list.addLast(new Node("B"));
        list.addLast(new Node("C"));
        list.print();

        System.out.println("\n--- Jawaban No 6: Test Prev/Next B ---");
        Node nodeB = list.findByValue("B");
        System.out.println("Next of B: " + nodeB.next.data);
        System.out.println("Prev of B: " + nodeB.prev.data);

        System.out.println("\n--- Jawaban No 7: Print dari belakang ---");
        list.printFromBack(); // Harusnya: C <-> B <-> A <-> null

        System.out.println("\n--- 8.E Insert At Index 1 ('X') ---");
        list.insertAt(1, new Node("X"));
        list.print();

        System.out.println("\n--- 8.F Insert After 'C' ('D') ---");
        list.insertAfter("C", new Node("D"));
        list.print();

        System.out.println("\n--- 8.G Insert Before 'B' ('Y') ---");
        list.insertBefore("B", new Node("Y"));
        list.print();

        System.out.println("\n--- 8.C Delete By Index 2 ('Y' hilang) ---");
        list.deleteByIndex(2);
        list.print();

        System.out.println("\n--- 8.D Delete By Value 'X' ---");
        list.deleteByValue("X");
        list.print();
    }
}