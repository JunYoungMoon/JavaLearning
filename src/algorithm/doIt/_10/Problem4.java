package algorithm.doIt._10;


class Problem4 {
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();

        minHeap.insert(5);
        minHeap.insert(8);
        minHeap.insert(1);
        minHeap.insert(2);
        minHeap.remove();
        minHeap.insert(9);
        minHeap.insert(22);
        minHeap.insert(11);

        minHeap.printHeap();

    }
}
