package algdat.graphs;

public class ShortestPath {

    /**
     * 
     * @param v
     *            The number of vertices in the graph
     * @param e
     *            The edges in the graph. Assumed to be on the form {{u1, v1,
     *            c1},{u2, v2, c2},...,{un, vn, cn}} where u and v are vertices
     *            and c is the cost of going from u to v.
     * @param s
     *            The vertex in the graph which the search is done from.
     * @return The cost of the shortest path from Vertex s to all vertices.
     */
    public static int[] bellmanFord(int v, int[][] e, int s) {
        int[] best = new int[v];
        for (int i = 0; i < v; i++) {
            best[i] = Integer.MAX_VALUE/2;
        }
        best[s] = 0;
        for (int i = 0; i < v; i++) {
            for (int k = 0; k < e.length; k++) {
                int cost = best[e[k][0]] + e[k][2];
                if (cost < best[e[k][1]]) {
                    best[e[k][1]] = cost;
                }
            }
        }

        return best;
    }

}
