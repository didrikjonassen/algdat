package graphs;

public class ShortestPath {

    /**
     * @param v The number of vertices in the graph
     * @param e The edges in the graph. Assumed to be on the form {{u1, v1,
     *          c1},{u2, v2, c2},...,{un, vn, cn}} where u and v are vertices
     *          and c is the cost of going from u to v.
     * @param s The vertex in the graph which the search is done from.
     * @return The cost of the shortest path from Vertex s to all vertices.
     * List is on the form {{v0.distance, v0.parent},{v1.distance, v1.parent}...}
     */
    public static int[][] bellmanFord(int v, int[][] e, int s) {
        int[][] best = new int[v][2];
        for (int i = 0; i < v; i++) {
            best[i][0] = Integer.MAX_VALUE/2;
            best[i][1] = -1;
        }
        best[s][0] = 0;
        int cost;
        boolean changed = true;
        for (int i = 0; i < v && changed; i++) {
            changed = false;
            for (int[] edge : e) {
                cost = best[edge[0]][0] + edge[2];
                if (cost < best[edge[1]][0]) {
                    best[edge[1]][0] = cost;
                    best[edge[1]][1] = edge[0];
                    changed = true;
                }
            }
        }

        return best;
    }

}
