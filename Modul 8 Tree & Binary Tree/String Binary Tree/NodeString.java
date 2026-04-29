class NodeString {
    String data;
    NodeString left, right;

    NodeString(String data) {
        this.data = data;
    }

    public void add(String data) {
        // compareTo menghasilkan nilai > 0 jika data lebih besar secara alfabetis
        if (data.compareTo(this.data) > 0) {
            if (this.right == null) {
                this.right = new NodeString(data);
            } else this.right.add(data);
        }
        // compareTo menghasilkan nilai <= 0 jika data lebih kecil/sama secara alfabetis
        if (data.compareTo(this.data) <= 0) {
            if (this.left == null) {
                this.left = new NodeString(data);
            } else this.left.add(data);
        }
    }
}