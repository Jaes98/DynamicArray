import java.util.Arrays;

public class DynamicArray { 
    private int growSize = 20;
    int INITIAL_SIZE = 10;
    int size;
    public String[] dArray = new String[INITIAL_SIZE];

    public static void main(String[] args) {
        DynamicArray dArray = new DynamicArray();
    }
    public DynamicArray() {
        System.out.println("DynamicArray created");
    }


    public void add(String object) {
        if (size >= dArray.length) {
            System.out.println("Array er fuld, laver nyt array med " + growSize + " pladser.");
            grow();
        }
        dArray[size] = object;
        size++;
        printArray();
    }
    public void remove() {
        if(size == 0) {
            System.out.println("Array er tom");
            return;
        }
        dArray[size-1] = null;
        size--;
        if (canShrink()) {
        shrink();
        }
        printArray();
    }
    public void remove(int index) {
        dArray[index] = null;
        size--;
        for (int i = index; i < size; i++) {
        dArray[i] = dArray[i + 1];
    }
    if(canShrink()) {
        shrink();
    }
    printArray();
    }   
    public String get(int index) {
        return dArray[index];
    }
    public int size() {
        System.out.println("Size of array: " + size);
        return size;
    }
    public void set(int index, String object) {
        dArray[index] = object;
        printArray();
    }
    public void clear() {
        size = 0;
        if(canShrink()) {
            shrink();
        }
        printArray();
    }
    private void grow() {
        String[] newArray = new String[dArray.length + growSize];
        for (int i = 0; i < dArray.length; i++) {
            newArray[i] = dArray[i];
        }
        dArray = newArray;
        printArray();
    }
    public boolean canShrink() {
        boolean check = dArray.length > size;
        return check;
    }

    public void shrink() {
        String[] newArray = new String[size];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = dArray[i];
        }
        dArray = newArray;
        printArray();
    }
    public void printArray() {
        System.out.println(Arrays.toString(dArray));
    }

}