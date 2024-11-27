package graph;

import java.util.*;

public class ShortestDistanceAfterRoadAdditionQueriesI_3243 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(shortestDistanceAfterQueries(5, new int[][]{{2, 4}, {0, 2}, {0, 4}})));
        System.out.println(Arrays.toString(shortestDistanceAfterQueries(4, new int[][]{{0, 3}, {0, 2}})));
    }

    private static int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        final int[][] children = initialChildren(n, queries);

        final int[] distFromZero = new int[n];
        for (int i = 1; i < n; ++i) {
            distFromZero[i] = i;
        }

        final int[] bfsPad = new int[n];

        final int[] result = new int[queries.length];

        for (int q = 0; q < queries.length; ++q) {
            final int u = queries[q][0];
            final int v = queries[q][1];
            for (int c = 0; ; ++c) {
                if (children[u][c] == 0) {
                    children[u][c] = v;
                    break;
                }
            }
            bfsPad[0] = u;
            for (int bfsNext = 0, bfsEnd = 1; bfsNext < bfsEnd; ) {
                final int currNode = bfsPad[bfsNext++];
                for (final int nextNode : children[currNode]) {
                    if (nextNode == 0) {
                        break;
                    }
                    if (distFromZero[nextNode] <= distFromZero[currNode] + 1) {
                        continue;
                    }
                    distFromZero[nextNode] = distFromZero[currNode] + 1;
                    bfsPad[bfsEnd++] = nextNode;
                }
            }
            result[q] = distFromZero[n-1];
        }
        return result;
    }

    private static int[][] initialChildren(final int n, final int[][] queries) {
        final int[] numChildren = new int[n];
        Arrays.fill(numChildren, 1);
        numChildren[n-1] = 0;

        for (final int[] query : queries) {
            final int u = query[0];
            numChildren[u]++;
        }

        final int[][] children = new int[n][];
        for (int i = 0; i < n - 1; ++i) {
            children[i] = new int[numChildren[i]];
            children[i][0] = i + 1;
        }
        assert numChildren[n-1] == 0;
        children[n-1] = new int[0];
        return children;
    }
}
