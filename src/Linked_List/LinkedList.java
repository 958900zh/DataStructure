package Linked_List;

public class LinkedList<E> {

    private class Node {
        private E e;
        private Node next;

        public Node() {
            this(null, null);
        }

        public Node(E e) {
            this(e, null);
        }

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private int size;
    private Node dummyHead;

    public LinkedList() {
        this.size = 0;
        this.dummyHead = new Node();
    }

    public void add(E e, int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("illegal index: " + index);

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        prev.next = new Node(e, prev.next);
        size++;
    }

    public void addFirst(E e) {
        add(e, 0);
    }

    public void addLast(E e) {
        add(e, size);
    }

    public boolean contains(E e) {
        Node cur = dummyHead.next;
        for (int i = 0; i < size; i++) {
            if (cur.e.equals(e))
                return true;
        }
        return false;
    }

    public Node get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("illegal index: " + index);
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    public Node getFirst() {
        return get(0);
    }

    public Node getLast() {
        return get(size - 1);
    }

    public void removeElement(E e) {
        Node prev = dummyHead;
        for (int i = 0; i < size; i++) {
            if (prev.next.e.equals(e))
                break;
            prev = prev.next;
        }

        if (prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size --;
        }
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("illegal index: " + index);
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size --;
        return delNode.e;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node node = dummyHead.next;
        while (node != null) {
            sb.append(node.e);
            if (node.next != null)
                sb.append(", ");
            node = node.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
