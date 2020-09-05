/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

/* https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph */

/*
* Time Complexity: O(V+E)
* */

class BFSTraversal {

    public static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adjacentList, int N) {
        boolean[] visited = new boolean[N];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        ArrayList<Integer> bfsTraversed = new ArrayList<>(N);
        while (queue.size() > 0) {
            int s = queue.poll();
            bfsTraversed.add(s);
            ArrayList<Integer> adjVertices = adjacentList.get(s);
            Iterator<Integer> iterator = adjVertices.iterator();
            while (iterator.hasNext()) {
                int v = iterator.next();
                if (!visited[v]) {
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }
        return bfsTraversed;
    }

    private BFSTraversal() {
    }
}