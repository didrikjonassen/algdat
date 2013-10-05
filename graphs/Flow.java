package algdat.graphs;

import java.util.*;

public class Flow {
    /**
     * RelabelToFront flow algorithm running in O(V^3) time.
     * 
     * @param C
     *            Two dimensional matrix with the maximum capacity.
     * @param E
     *            List of neighbors. (Both to and from.)
     * @param source
     *            The source.
     * @param drain
     *            The drain.
     * @return Returns the maximum flow in the graph.
     */
    public static int relabelToFront(int[][] C, ArrayList<Integer>[] E,
            int source, int drain) {

        // Initialize Preflow Start
        int[] h = new int[C.length];
        int[] e = new int[C.length];
        int[][] f = new int[C.length][C.length];
        h[source] = C.length;
        for (int i = 0; i < E[source].size(); i++) {
            f[source][E[source].get(i)] = C[source][E[source].get(i)];
            f[E[source].get(i)][source] = -C[source][E[source].get(i)];
            e[E[source].get(i)] = C[source][E[source].get(i)];
            e[source] -= C[source][E[source].get(i)];
        }
        // Initialize Preflow End

        // Iterators over Edges
        Iterator[] it = new Iterator[C.length];
        for (int i = 0; i < it.length; i++) {
            it[i] = E[i].iterator();
        }
        // Iterators over Edges end

        // Setup u
        LinkedList<Integer> U = new LinkedList<Integer>();
        for (int i = 0; i < C.length; i++) {
            if (i != source && i != drain) {
                U.add(i);
            }
        }
        // Setup u over

        int k = 0;
        while (k < U.size()) {
            int u = U.get(k);
            int oldheight = h[u];

            // Discharge
            while (e[u] > 0) {
                if (!it[u].hasNext()) {
                    // start relabel
                    int min = Integer.MAX_VALUE / 2;
                    for (int i = 0; i < E[u].size(); i++) {
                        if (h[E[u].get(i)] < min
                                && C[u][E[u].get(i)] - f[u][E[u].get(i)] > 0) {
                            min = h[E[u].get(i)];
                        }
                    }
                    h[u] = min + 1;
                    // end relabel
                    it[u] = E[u].iterator();
                } else {
                    int v = (int) it[u].next();
                    if (C[u][v] - f[u][v] > 0 && h[u] == h[v] + 1) {
                        // start push
                        int df = Math.min(e[u], C[u][v] - f[u][v]);
                        f[u][v] += df;
                        f[v][u] -= df;
                        e[u] -= df;
                        e[v] += df;
                        // end push
                    }
                }
            }
            // End discharge
            if (h[u] > oldheight) {
                U.addFirst(U.remove(k));
                k = 1;
            } else {
                k++;
            }
        }
        return e[drain];
    }

    public static void main(String[] args) {

        int[][] C = { { 0, 16, 13, 0, 0, 0 }, { 0, 0, 0, 12, 0, 0 },
                { 0, 4, 0, 0, 14, 0 }, { 0, 0, 9, 0, 0, 20 },
                { 0, 0, 0, 7, 0, 4 }, { 0, 0, 0, 0, 0, 0 } };
        ArrayList<Integer>[] al = (ArrayList<Integer>[]) new ArrayList[6];
        for (int i = 0; i < 6; i++) {
            al[i] = new ArrayList();
        }
        for (int i = 0; i < 6; i++) {
            for (int k = 0; k < 6; k++) {
                if (C[i][k] > 0) {
                    al[i].add(k);
                    al[k].add(i);
                }
            }
        }
        System.out.println(relabelToFront(C, al, 0, 5));

    }

}
