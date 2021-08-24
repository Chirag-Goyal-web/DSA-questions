import java.util.*;
public class bellman_ford_algorithm{
    // {{src,dest,weight}}
    public static void bellmanFord(int[][] edges, int N, int src) {
        int[] prev = new int[N];
        Arrays.fill(prev, (int) 1e9);
        prev[src] = 0;

        boolean isNegativeCycle = false;
        for (int edgeCount = 1; edgeCount <= N; edgeCount++) {
            int[] curr = new int[N];
            for (int i = 0; i < N; i++)
                curr[i] = prev[i];

            boolean isAnyUpdate = false;
            for (int[] e : edges) {
                int u = e[0], v = e[1], w = e[2];
                if (prev[u]!=(int)1e9 && prev[u] + w < curr[v]) {
                    curr[v] = prev[u] + w;
                    isAnyUpdate = true;
                }
            }

            //If at the last iteration, there is any change, it means -ve cycle
            if (edgeCount == N && isAnyUpdate)
                isNegativeCycle = true;
            
            //If at any point, there is no update in complete iteration, 
            //then furthur also, there will be no update
            if (!isAnyUpdate)
                break;
        }
    }
}