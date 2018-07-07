import java.util.Arrays;

public class MaxIntHeap {
    private int capacity = 10;
    private int size = 0;
    private int[] items = new int[capacity];

    public int size() { return size; }
    public int getLeftChildIndex(int index) { return 2 * index + 1; }
    public int getRightChildIndex(int index) { return 2 * index + 2; }
    public int getParentIndex(int index) { return (index - 1) / 2; }

    public boolean hasLeftChild(int index) { return (getLeftChildIndex(index)) < size; }
    public boolean hasRightChild(int index) { return getRightChildIndex(index) < size; }
    public boolean hasParent(int index) { return getParentIndex(index) < size; }

    public int leftChild(int index) { return items[getLeftChildIndex(index)]; }
    public int rightChild(int index) { return items[getRightChildIndex(index)]; }
    public int parent(int index) { return items[getParentIndex(index)]; }

    public void swap(int idx1, int idx2) {
        int tmp = items[idx1];
        items[idx1] = items[idx2];
        items[idx2] = tmp;
    }

    public void ensureCapacity() {
        if (size==capacity) {
            items = Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }

    public int peak() {
        if (size == 0) throw new IllegalStateException();
        return items[0];
    }

    public int poll() {
        if (size == 0) throw new IllegalStateException();
        int item = items[0];
        items[0] = items[--size];
        heapifyDown();
        return item;
    }

    public void add(int item) {
        ensureCapacity();
        items[size++] = item;
        heapifyUp();
    }

    public void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && items[index] > parent(index)) {
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    public void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int biggerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index) > leftChild(index)) {
                biggerChildIndex = getRightChildIndex(index);
            }
            if (items[index] > items[biggerChildIndex])
                break;
            swap(index, biggerChildIndex);
            index = biggerChildIndex;
        }
    }
}