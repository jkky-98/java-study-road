package collection.list;

import java.util.Arrays;

public class MyArrayList<E> implements MyList<E> {
    private static final int DEFUALT_CAPACITY = 5;

    private Object[] elementData;
    private int size = 0;

    public MyArrayList() {
        this.elementData = new Object[DEFUALT_CAPACITY];
    }

    public MyArrayList(int initialCapacity) {
        this.elementData = new Object[initialCapacity];
    }

    @Override
    public int size() {
        return size;
    }
    @Override
    public void add(E e) {
        // 코드 추가
        if (size == elementData.length) {
            grow();
        }
        elementData[size] = e;
        size++;
    }
    @Override
    public void add(int index, E e) {
        // 코드 추가
        if (size == elementData.length) {
            grow();
        }
        // 데이터 이동
        shiftRightFrom(index, e);
        elementData[index] = e;
        size++;
    }

    //코드 추가, 요소의 마지막부터 Index까지 오른쪽으로 밀기
    private void shiftRightFrom(int index, E e) {
        for (int i = size; i > index; i--) {
            elementData[i] = elementData[i-1];
        }
    }

    // 코드 추가
    @Override
    public E remove(int index) {
        E oldValue = get(index);
        shiftLeftFrom(index);
        size--;
        elementData[size] = null;
        return oldValue;
    }

    private void shiftLeftFrom(int index) {
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i+1];
        }
    }

    private void grow() {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity * 2;
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    @SuppressWarnings("unchecked")
    @Override
    public E get(int index) {
        return (E) elementData[index];
    }

    @Override
    public E set(int index, E element) {
        E oldValue = get(index);
        elementData[index] = element;
        return oldValue;
    }

    @Override
    public int indexOf(E o) {
        for (int i=0; i< size; i++) {
            if (o.equals(elementData[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(elementData, size)) + " size="+size + ", capacity=" +elementData.length;
    }
}
