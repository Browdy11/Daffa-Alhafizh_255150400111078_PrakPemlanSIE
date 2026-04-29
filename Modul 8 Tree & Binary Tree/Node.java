class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }

    public void add(int data) {
        // Jika data lebih besar, masuk ke kanan
        if (data > this.data) {
            if (this.right == null) {
                this.right = new Node(data);
            } else this.right.add(data);
        }
        // Jika data lebih kecil atau sama dengan, masuk ke kiri
        if (data <= this.data) {
            if (this.left == null) {
                this.left = new Node(data);
            } else this.left.add(data);
        }
    }
}