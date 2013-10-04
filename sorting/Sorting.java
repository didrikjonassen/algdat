package algdat.sorting;

public class Sorting {

    /**
     * A stable merge sort that sorts in O(n*log(n)) time.
     * 
     * @param list
     *            The list to be sorted
     * @param q
     *            The first element of the list to be sorted
     * @param r
     *            The last element of the list to be sorted. (Typically
     *            list.length-1)
     */
    public static void sort(int[] list, int q, int r) {
        if (q < r) {
            int p = (q + r) / 2;
            sort(list, q, p);
            sort(list, p + 1, r);
            merge(list, q, p, r);
        }
    }

    /**
     * Used by sort()
     * 
     * @param list
     *            The list to be sorted.
     * @param q
     *            The first item.
     * @param p
     *            The divider.
     * @param r
     *            The last item.
     */
    public static void merge(int[] list, int q, int p, int r) {
        int n1 = p - q + 1;
        int n2 = r - p;
        int[] a = new int[n1 + 1];
        int[] b = new int[n2 + 1];
        for (int i = 0; i < n1; i++) {
            a[i] = list[q + i];
        }
        for (int i = 0; i < n2; i++) {
            b[i] = list[p + i + 1];
        }
        a[a.length - 1] = Integer.MAX_VALUE;
        b[b.length - 1] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        for (int k = q; k <= r; k++) {
            if (a[i] <= b[j]) { // this is the line that compares. Change to >=
                                // for descending sort.
                list[k] = a[i++];
            } else {
                list[k] = b[j++];
            }
        }
    }

    /**
     * Finds the kth smallest item in a list of integers.
     * 
     * @param list
     *            The list to be searched in.
     * @param k
     *            The position to find. IMPORTANT: First position is 0, NOT 1.
     * @param p
     *            The first position in the list. Should most likely be 0 when
     *            called from the outside.
     * @param r
     *            The last item in the list. NOT the length of the list. Most
     *            likely length-1.
     * @return Returns the number in position k if list were a sorted ascending
     *         list.
     */
    public static int select(int[] list, int k, int p, int r) {
        int i = p - 1;
        int j = p;
        int pivot = list[r];
        int temp;
        for (; j < r; j++) {
            if (list[j] < pivot) {
                i++;
                temp = list[i];
                list[i] = list[j];
                list[j] = temp;
            }
        }
        i++;
        if (i == k) {
            return pivot;
        } else {
            list[r] = list[i];
            list[i] = pivot;
            if (k < i) {
                return select(list, k, p, i - 1);
            } else {
                return select(list, k, i + 1, r);
            }
        }
    }

}
