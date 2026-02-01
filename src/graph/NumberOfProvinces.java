package graph;

public class NumberOfProvinces {
    public static void main(String[] args) {
        int[][] graph = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };

        NumberOfProvinces_BrutForce_Solution.findCircleNum(graph);
    }
}

class NumberOfProvinces_BrutForce_Solution {

    public static void dfs(int node, int[][] isConnected, boolean[] visit) {
        visit[node] = true;
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[node][i] == 1 && !visit[i]) {
                dfs(i, isConnected, visit);
            }
        }
    }

    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int numberOfComponents = 0;
        boolean[] visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                numberOfComponents++;
                dfs(i, isConnected, visit);
            }
        }

        return numberOfComponents;
    }
}


