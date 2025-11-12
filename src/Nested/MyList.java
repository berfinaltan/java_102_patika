package Nested;

public class MyList<T> {
    private T[] array;
    private int size = 0;
    private int capacity;

    public MyList() {
        this.capacity = 10;
        this.array = (T[]) new Object[capacity];
    }


    public MyList(int capacity) {
        this.capacity = capacity;
        this.array = (T[]) new Object[capacity];
    }


    public void add(T data) {
        if (size == capacity) {
            capacity *= 2;
            T[] newArray = (T[]) new Object[capacity];
            for (int i = 0; i < size; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        array[size++] = data;
    }


    public int size() {
        return size;
    }


    public int getCapacity() {
        return capacity;
    }


    public T get(int index) {
        if (index < 0 || index >= size)
            return null;
        return array[index];
    }

    // Eleman silme
    public T remove(int index) {
        if (index < 0 || index >= size)
            return null;
        T removed = array[index];
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[--size] = null;
        return removed;
    }


    public T set(int index, T data) {
        if (index < 0 || index >= size)
            return null;
        array[index] = data;
        return data;
    }


    public String toString() {
        if (size == 0) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            if (i != size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }


    public boolean isEmpty() {
        return size == 0;
    }


    public void clear() {
        array = (T[]) new Object[capacity];
        size = 0;
    }


    public T[] toArray() {
        T[] newArray = (T[]) new Object[size];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }


    public int indexOf(T data) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(data))
                return i;
        }
        return -1;
    }


    public int lastIndexOf(T data) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(data))
                return i;
        }
        return -1;
    }


    public MyList<T> sublist(int start, int finish) {
        if (start < 0 || finish >= size || start > finish)
            return null;
        MyList<T> subList = new MyList<>(finish - start + 1);
        for (int i = start; i <= finish; i++) {
            subList.add(array[i]);
        }
        return subList;
    }


    public boolean contains(T data) {
        return indexOf(data) != -1;
    }
}
class Main {
    public static void main(String[] args) {
        MyList<Integer> list = new MyList<>();

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        System.out.println("Liste: " + list);
        System.out.println("Eleman sayısı: " + list.size());
        System.out.println("Kapasite: " + list.getCapacity());
        System.out.println("2. indexteki değer: " + list.get(2));

        list.remove(1);
        System.out.println("Silme sonrası: " + list);

        list.set(1, 99);
        System.out.println("Güncelleme sonrası: " + list);

        System.out.println("Alt liste: " + list.sublist(0, 1));
        System.out.println("Contains 99? " + list.contains(99));
        System.out.println("İlk index: " + list.indexOf(99));
        System.out.println("Son index: " + list.lastIndexOf(99));
    }
}
