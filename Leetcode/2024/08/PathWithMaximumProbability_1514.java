package tree;

public class PathWithMaximumProbability_1514 {
    public static void main(String[] args) {
        System.out.println(maxProbability(3, new int[][]{{0,1},{1,2},{0,2}}, new double[]{0.5,0.5,0.2}, 0, 2));
        System.out.println(maxProbability(3, new int[][]{{0,1},{1,2},{0,2}}, new double[]{0.5,0.5,0.3}, 0, 2));
        System.out.println(maxProbability(3, new int[][]{{0,1}}, new double[]{0.5}, 0, 2));
        System.out.println(maxProbability(500, new int[][]{{193,229},{133,212},{224,465}}, new double[]{0.91,0.78,0.64}, 4, 364));
    }

    private static double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        double[] maxProb = new double[n];
        maxProb[start_node] = 1.0;

        for (int i = 0; i < n - 1; i++) {
            boolean updated = false;
            for (int j = 0; j < edges.length; j++) {
                int u = edges[j][0];
                int v = edges[j][1];
                double prob = succProb[j];

                if (maxProb[u] * prob > maxProb[v]) {
                    maxProb[v] = maxProb[u] * prob;
                    updated = true;
                }
                if (maxProb[v] * prob > maxProb[u]) {
                    maxProb[u] = maxProb[v] * prob;
                    updated = true;
                }
            }
            if (!updated) break;
        }

        return maxProb[end_node];
    }
}
