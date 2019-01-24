package Arrays;

public class Array<E> {

    private Object[] data;
    private int size;

    public Array() {
        this(10);
    }

    public Array(int initCapacity) {
        this.data = new Object[initCapacity];
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getCapacity() {
        return data.length;
    }

    public void add(E e) {
        add(e, size);
    }

    public void add(E e, int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("illegal index: " + index);
        if (size == data.length - 1)
            resize(data.length * 2);
        for (int i = size; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("illegal index: " + index);
        return (E) data[index];
    }

    public void set(E e, int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("illegal index: " + index);
        data[index] = e;
    }

    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(data[i]))
                return i;
        }
        return -1;
    }

    public boolean contains(E e) {
        return !(find(e) == -1);
    }

    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("illegal index: " + index);
        E delData = (E) data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        data[size] = null;
        if (size <= data.length / 4 && data.length / 2 != 0)
            resize(data.length / 2);
        return delData;
    }

    public void remove(E e) {
        int index = find(e);
        if (index != -1)
            remove(index);
    }

    private void resize(int newCapacity) {
        Object[] newData = new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i != size - 1)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
