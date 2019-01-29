package Queue;

import Linked_List.LinkedList;

public class LinkedListQueue<E> implements Queue<E> {

    private LinkedList<E> linkedList = new LinkedList<>();

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        linkedList.addLast(e);
    }

    @Override
    public E dequeue() {
        return linkedList.removeFirst();
    }

    @Override
    public E peek() {
        return linkedList.getFirst();
    }
}
