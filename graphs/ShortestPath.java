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
     * @return The cost of the shortest path from Vertex 0 to all vertices.
     */
    public static int[] bellmanFord(int v, int[][] e) {
        int[] best = new int[v];
        for (int i = 1; i < v; i++) {
            best[i] = Integer.MAX_VALUE;
        }
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
