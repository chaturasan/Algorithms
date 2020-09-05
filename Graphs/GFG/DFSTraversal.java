/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

/* https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph */

/*
* multiple connected graph DFS
* Time Complexity: O(V+E)
* */

class DFSTraversal {

    private static ArrayList<Integer> dfsUtil(boolean[] visited, ArrayList<ArrayList<Integer>> g,int i, ArrayList<Integer> dfsTraversed) {
        visited[i] = true;
        dfsTraversed.add(i);
        List<Integer> adjVertices = g.get(i);
        Iterator<Integer> it = adjVertices.iterator();
        while(it.hasNext()) {
            int v = it.next();
            if(!visited[v])
                dfsUtil(visited, g, v, dfsTraversed);
        }
        return dfsTraversed;
    }

    public static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> g, int N) {
        boolean[] visited = new boolean[N];
        ArrayList<Integer> dfsTraversed = new ArrayList<>(N);
        for(int i = 0; i < N; i++) {
            if(!visited[i])
                dfsUtil(visited, g, i, dfsTraversed);
        }
        return dfsTraversed;
    }

    private DFSTraversal() {
    }
}