package Stack;

import Arrays.Array;

public class ArrayStack<E> implements Stack<E> {

    private Array<E> array;

    public ArrayStack() {
        this.array = new Array<>();
    }

    public ArrayStack(int capacity) {
        this.array = new Array<>(capacity);
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public void push(E e) {
        array.add(e);
    }

    @Override
    public E pop() {
        return array.remove(array.getSize() - 1);
    }

    @Override
    public E peek() {
        return array.get(array.getSize() - 1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack: ");
        sb.append(array);
        sb.append(" <= top");
        return sb.toString();
    }
}
