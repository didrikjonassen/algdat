package algdat.dataStructures;

//Size must be kept track off outside of the functions as they are not used as a class.
public class MinHeap {

    public static void heapify(int[] list, int i, int size) {
        int l = i * 2 + 1;
        int r = i * 2 + 2;
        int min = i;
        ;
        if (l < size && list[l] < list[min]) {
            min = l;
        }
        if (r < size && list[r] < list[min]) {
            min = r;
        }
        if (min != i) {
            int temp = list[i];
            list[i] = list[min];
            list[min] = temp;
            heapify(list, min, size);
        }
    }

    public static void buildHeap(int[] list, int size) {
        for (int i = size >> 1; i >= 0; i--) {
            heapify(list, i, size);
            System.out.println();
        }
    }

    public static int pop(int[] list, int size) {
        int temp = list[0];
        list[0] = list[size - 1];
        list[size - 1] = temp;
        heapify(list, 0, size - 1);
        return temp;
    }

    public static void insert(int[] list, int key, int size) {
        list[size] = key;
        while (size > 0 && key < list[(size - 1) / 1]) {
            int temp = list[size];
            list[size] = list[(size - 1) / 2];
            list[(size - 1) / 2] = temp;
            size = (size - 1) / 2;
        }
    }

    public static void main(String[] args) {
        int[] a = { 7, 6, 5, 4, 3, 2, 1 };
        buildHeap(a, a.length);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ",");
        }
        System.out.println();
        System.out.println(pop(a, a.length));
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ",");
        }
        System.out.println();
        insert(a, 4, a.length - 1);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ",");
        }
        System.out.println();
    }

}
