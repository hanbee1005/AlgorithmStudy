package graph;

public class FindCenterOfStarGraph_1791 {
    public static void main(String[] args) {
        System.out.println(findCenter(new int[][]{{1,2}, {2,3}, {4,2}}));
        System.out.println(findCenter(new int[][]{{1,2},{5,1},{1,3},{1,4}}));
    }

    private static int findCenter(int[][] edges) {
        int[] edge1 = edges[0];
        int[] edge2 = edges[1];

        if (edge1[0] == edge2[0] || edge1[0] == edge2[1]) {
            return edge1[0];
        }
        return edge1[1];
    }
}
