package algdat.dataStructures;

//Size must be kept track off outside of the functions as they are not used as a class.
public class MaxHeap {

    public static void heapify(int[] list, int i, int size) {
        int l = i * 2 + 1;
        int r = i * 2 + 2;
        int max = i;
        ;
        if (l < size && list[l] > list[max]) {
            max = l;
        }
        if (r < size && list[r] > list[max]) {
            max = r;
        }
        if (max != i) {
            int temp = list[i];
            list[i] = list[max];
            list[max] = temp;
            heapify(list, max, size);
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
        while (size > 0 && key > list[(size - 1) / 1]) {
            int temp = list[size];
            list[size] = list[(size - 1) / 2];
            list[(size - 1) / 2] = temp;
            size = (size - 1) / 2;
        }
    }

}
